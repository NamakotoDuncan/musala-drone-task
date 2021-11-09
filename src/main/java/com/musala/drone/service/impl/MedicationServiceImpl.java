package com.musala.drone.service.impl;

import com.musala.drone.model.Medication;
import com.musala.drone.repository.MedicationRepository;
import com.musala.drone.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.webjars.NotFoundException;

import java.util.List;

public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository repository;

    @Override
    public Medication save(Medication medication) {
        return this.repository.save(medication);
    }

    @Override
    public Medication update(String name, Medication medication) {
        Medication med = repository.findById(name).orElseThrow(() -> new NotFoundException("Drone not found for name :: " + name));
        med.setWeight(medication.getWeight());
        return repository.save(med);
    }

    @Override
    public List<Medication> getAll() {
        return this.repository.findAll();    }

    @Override
    public Medication getMedicationName(String name) {
        return this.repository.getOne(name);
    }
}
