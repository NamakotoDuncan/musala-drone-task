package com.musala.drone.controller;

import com.musala.drone.model.Drone;
import com.musala.drone.model.Medication;
import com.musala.drone.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medication")
public class MedicationController {
    @Autowired
    private MedicationService service;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = service.getAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findById(@PathVariable String name) {
        Medication med = service.getMedicationName(name);
        return ResponseEntity.ok().body(med);
    }

    @PutMapping("/{name}")
    public ResponseEntity<?> update(@PathVariable String name, @RequestBody Medication medication) {
        Medication updatedMedication = service.update(name, medication);
        return ResponseEntity.ok().body(updatedMedication);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Medication medication) {
        Medication savedMedication = service.save(medication);
        return ResponseEntity.ok().body(savedMedication);
//        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/{id}")
//                .buildAndExpand(savedMedication.getName())
//                .toUri();
//        return ResponseEntity.created(uri).body(savedMedication);
    }
}
