package com.musala.drone.service.impl;

import com.musala.drone.model.Drone;
import com.musala.drone.model.Medication;
import com.musala.drone.repository.DroneRepository;
import com.musala.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {
    @Autowired
    private DroneRepository repository;

    @Override
    public Drone save(Drone drone) {
        return this.repository.save(drone);
    }

    @Override
    public Drone update(String serialNumber, Drone drone) {
        repository.findById(serialNumber).orElseThrow(() -> new NotFoundException("Drone not found for name :: " + serialNumber));
//        drone.setSerialNumber(drone.getSerialNumber());
        return this.repository.save(drone);
    }

    @Override
    public List<Drone> getAll() {
        return repository.findAll();
    }

    @Override
    public Drone getDroneByName(String serialNumber) {
        return repository.getOne(serialNumber);
    }

    @Override
    public void loadDrone(String serialNumber, List<Medication> medications) {

    }
}
