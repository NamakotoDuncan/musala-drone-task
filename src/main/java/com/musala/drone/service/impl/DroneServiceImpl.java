package com.musala.drone.service.impl;

import com.musala.drone.model.Drone;
import com.musala.drone.model.DroneMonitorLog;
import com.musala.drone.model.Medication;
import com.musala.drone.repository.DroneMonitoLogRepository;
import com.musala.drone.repository.DroneRepository;
import com.musala.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class DroneServiceImpl implements DroneService {
    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private DroneMonitoLogRepository droneMonitoLogRepository;


    @Override
    public Drone save(Drone drone) {
        return this.droneRepository.save(drone);
    }

    @Override
    public Drone update(String serialNumber, Drone drone) {
        droneRepository.findById(serialNumber).orElseThrow(() -> new NotFoundException("Drone not found for name :: " + serialNumber));
//        drone.setSerialNumber(drone.getSerialNumber());
        return this.droneRepository.save(drone);
    }

    @Override
    public List<Drone> getAll() {
        return droneRepository.findAll();
    }

    @Override
    public Drone getDroneByName(String serialNumber) {
        return droneRepository.getOne(serialNumber);
    }

    @Override
    public void loadDrone(String serialNumber, List<Medication> medications) {

    }

    @Override
    @Scheduled(cron = "@hourly")
    public void batteryMonitor() {
        for(Drone d:droneRepository.findAll()){
            DroneMonitorLog log = new DroneMonitorLog();
            log.setDrone(d);
            log.setBatteryCapacity(d.getBatteryCapacity());
            droneMonitoLogRepository.save(log);
        }
    }
}
