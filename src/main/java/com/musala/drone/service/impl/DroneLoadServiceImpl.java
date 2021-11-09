package com.musala.drone.service.impl;

import com.musala.drone.model.DroneLoad;
import com.musala.drone.repository.DroneLoadRepository;
import com.musala.drone.service.DroneLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DroneLoadServiceImpl implements DroneLoadService {
    @Autowired
    private DroneLoadRepository repository;

    @Override
    public DroneLoad save(DroneLoad droneLoad) {
        return this.repository.save(droneLoad);
    }

    @Override
    public DroneLoad update(Integer name, DroneLoad droneLoad) {
        DroneLoad dl =  repository.findById(name).orElseThrow(() -> new NotFoundException("DroneLoad not found for name :: " + name));
        dl.setDrone(droneLoad.getDrone());
        return  this.repository.save(dl);
    }

    @Override
    public List<DroneLoad> getByDrone(String droneName) {
        return  this.repository
                .findAll().stream().
                filter(droneLoad -> droneLoad.getDrone().getSerialNumber().equals(droneName))
                .collect(Collectors.toList());
    }
}
