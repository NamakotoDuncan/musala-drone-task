package com.musala.drone.service.impl;

import com.musala.drone.model.Drone;
import com.musala.drone.model.Medication;
import com.musala.drone.repository.DroneRepository;
import com.musala.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.webjars.NotFoundException;

import java.util.List;

public class DroneServiceImpl implements DroneService {
    @Autowired
    private DroneRepository repository;

    @Override
    public Drone save(Drone drone) {
        return this.repository.save(drone);
    }

    @Override
    public Drone update(String name, Drone drone) {
        repository.findById(name).orElseThrow(() -> new NotFoundException("Drone not found for name :: " + name));
//        drone.setSerialNumber(drone.getSerialNumber());
        return this.repository.save(drone);
    }

    @Override
    public List<Drone> getAll() {
        return repository.findAll();
    }

    @Override
    public Drone getDroneByName(String name) {
        return repository.getOne(name);
    }

    @Override
    public void loadDrone(String name, List<Medication> medications) {

    }
}
