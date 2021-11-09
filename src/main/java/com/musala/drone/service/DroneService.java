package com.musala.drone.service;

import com.musala.drone.model.Drone;
import com.musala.drone.model.Medication;

import java.util.List;

public interface DroneService {
    Drone save(Drone drone);
    Drone update(String serialNumber, Drone drone);
    List<Drone> getAll();
    Drone getDroneByName(String serialNumber);
    void loadDrone(String name,List<Medication> medications);
}
