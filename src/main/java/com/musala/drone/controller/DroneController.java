package com.musala.drone.controller;

import com.musala.drone.model.Drone;
import com.musala.drone.model.DroneLoad;
import com.musala.drone.model.Medication;
import com.musala.drone.service.DroneLoadService;
import com.musala.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drone")
public class DroneController {
    @Autowired
    private DroneService droneService;

    @Autowired
    private DroneLoadService droneLoadService;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = droneService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<?> findById(@PathVariable String serialNumber) {
        Drone drone = droneService.getDroneByName(serialNumber);
        return ResponseEntity.ok().body(drone);
    }

    @PutMapping("/{serialNumber}")
    public ResponseEntity<?> update(@PathVariable String  serialNumber, @RequestBody Drone drone) {
        Drone updatedDrone = droneService.update(serialNumber, drone);
        return ResponseEntity.ok().body(updatedDrone);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Drone drone) {
        Drone savedDrone = droneService.save(drone);
        return ResponseEntity.ok().body(savedDrone);
    }

    @PostMapping("/load")
    public ResponseEntity<?> loadMedications(@RequestBody List<Medication> medications,@RequestBody Drone drone) {
        List<DroneLoad> savedLoadList = new ArrayList<>();
        for (Medication tempMedication : medications) {
            DroneLoad droneLoad = new DroneLoad();
            droneLoad.setDrone(drone);
            droneLoad.setMedication(tempMedication);
            DroneLoad savedLoad = droneLoadService.save(droneLoad);
            savedLoadList.add(savedLoad);
        }
        return ResponseEntity.ok().body(savedLoadList);
    }
}
