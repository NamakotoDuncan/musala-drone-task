package com.musala.drone.controller;

import com.musala.drone.exceptions.DroneOverloadException;
import com.musala.drone.exceptions.LowBatteryException;
import com.musala.drone.model.Drone;
import com.musala.drone.model.DroneLoad;
import com.musala.drone.model.DroneState;
import com.musala.drone.model.Medication;
import com.musala.drone.service.DroneLoadService;
import com.musala.drone.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/drone")
public class DroneController {
    @Autowired
    private DroneService droneService;

    @Autowired
    private DroneLoadService droneLoadService;

    @GetMapping("/drone")
    @ResponseStatus(value= HttpStatus.OK)
    public ResponseEntity<List<?>> findAll() {
        List<?> list = droneService.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/drone/available")
    @ResponseStatus(value= HttpStatus.OK)
    public ResponseEntity<List<?>> findAvailable() {
        List<?> list = droneService.getAvailableDrones();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/drone/{serialNumber}")
    @ResponseStatus(value=HttpStatus.OK)
    public ResponseEntity<?> findById(@PathVariable("serialNumber") String serialNumber) {
        Drone drone = droneService.getDroneByName(serialNumber);
        return ResponseEntity.ok().body(drone);
    }

    @GetMapping("/drone/{serialNumber}/battery")
    @ResponseStatus(value=HttpStatus.OK)
    public ResponseEntity<?> checkBatteryLevel(@PathVariable("serialNumber") String serialNumber) {
        double drone = droneService.checkBatteryLevel(serialNumber);
        return ResponseEntity.ok().body(drone);
    }

    @GetMapping("/drone/{serialNumber}/load")
    @ResponseStatus(value=HttpStatus.OK)
    public ResponseEntity<?> getDroneLoad(@PathVariable("serialNumber") String serialNumber) {
        List<DroneLoad> loads = droneLoadService.getByDrone(serialNumber);
        return ResponseEntity.ok().body(loads);
    }

    @PutMapping("/drone/{serialNumber}")
    @ResponseStatus(value=HttpStatus.OK)
    public ResponseEntity<?> update(@PathVariable String  serialNumber, @RequestBody @Valid Drone drone) {
        Drone updatedDrone = droneService.update(serialNumber, drone);
        return ResponseEntity.ok().body(updatedDrone);
    }

    @PostMapping(path = "/drone",consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(value=HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody @Valid Drone drone) {
        Drone savedDrone = droneService.save(drone);
        return ResponseEntity.ok().body(savedDrone);
    }

    @PostMapping(path = "/drone/load",consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(value=HttpStatus.CREATED)
    public ResponseEntity<?> loadMedications(@RequestBody @Valid List<Medication> medications,@RequestBody @Valid Drone drone) {
        double totalWeight = medications.stream().filter(o -> o.getWeight() > 0).mapToDouble(Medication::getWeight).sum();
        if (totalWeight>Drone.WEIGHT_LIMIT){
            throw new DroneOverloadException("Medication Exceed drone weightLimit");
        }
        if (drone.getBatteryCapacity()<25){
            throw new LowBatteryException("Drone Battery level less than 25%");
        }
        List<DroneLoad> savedLoadList = new ArrayList<>();
        for (Medication tempMedication : medications) {
            DroneLoad droneLoad = new DroneLoad();
            droneLoad.setDrone(drone);
            droneLoad.setMedication(tempMedication);
            DroneLoad savedLoad = droneLoadService.save(droneLoad);
            savedLoadList.add(savedLoad);
        }
        drone.setStatus(DroneState.LOADED);
        droneService.update(drone.getSerialNumber(),drone);
        return ResponseEntity.ok().body(savedLoadList);
    }
}
