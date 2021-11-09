package com.musala.drone.service;

import com.musala.drone.model.Drone;
import com.musala.drone.model.Medication;

import java.util.List;

public interface DroneService {
    Drone save(Drone drone);
    Drone update(String name, Drone drone);
    List<Drone> getAll();
    Drone getDroneByName(String name);
    void loadDrone(String name,List<Medication> medications);
}
