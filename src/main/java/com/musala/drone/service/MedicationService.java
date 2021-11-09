package com.musala.drone.service;

import com.musala.drone.model.Medication;

import java.util.List;

public interface MedicationService {
    Medication save(Medication medication);
    Medication update(String name, Medication medication);
    List<Medication> getAll();
    Medication getMedicationName(String name);
}
