package com.musala.drone.service;

import com.musala.drone.model.Drone;
import com.musala.drone.model.DroneLoad;

import java.util.List;

public interface DroneLoadService {
    DroneLoad save(DroneLoad droneLoad);
    DroneLoad update(Integer name, DroneLoad droneLoad);
    List<DroneLoad> getByDrone(String droneName);
}
