package com.musala.drone.utils;

import com.musala.drone.model.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

public class MockDataUtil {
    private MockDataUtil(){

    }

    public static Supplier<List<Drone>> droneSupplier =  () ->
            Arrays.asList(
        Drone.builder().batteryCapacity(89).serialNumber("AOOO-1").model(DroneModel.CRUISERWEIGHT).status(DroneState.IDLE).build(),
        Drone.builder().batteryCapacity(89).serialNumber("AOOO-2").model(DroneModel.HEAVYWEIGHT).status(DroneState.IDLE).build(),
        Drone.builder().batteryCapacity(89).serialNumber("AOOO-3").model(DroneModel.LIGHTWEIGHT).status(DroneState.IDLE).build(),
        Drone.builder().batteryCapacity(89).serialNumber("AOOO-4").model(DroneModel.MIDDLEWEIGHT).status(DroneState.IDLE).build()
    );

    public static Supplier<List<Medication>> medicationSupplier = () ->
            Arrays.asList(Medication.builder().name("PARACETAMOL").code("001").weight(35).imageUrl("https://tinyurl.com/3ykwwwe4").build(),
    Medication.builder().name("PARACETAMOL").code("001").weight(250).imageUrl("https://tinyurl.com/3ykwwwe4").build(),
    Medication.builder().name("INSULIN").code("002").weight(315).imageUrl("https://tinyurl.com/3ykwwwe4").build(),
    Medication.builder().name("EYE DROP").code("003").weight(125).imageUrl("https://tinyurl.com/3ykwwwe4").build(),
    Medication.builder().name("STEROID").code("002").weight(200).imageUrl("https://tinyurl.com/3ykwwwe4").build()
    );

    public static Supplier<List<DroneLoad>> droneLoadSupplier = () ->
      /*
        Drone d1 = Drone.builder().batteryCapacity(89).serialNumber("AOOO-1").model(DroneModel.CRUISERWEIGHT).status(DroneState.IDLE).build();
        Drone d2 = Drone.builder().batteryCapacity(89).serialNumber("AOOO-2").model(DroneModel.CRUISERWEIGHT).status(DroneState.IDLE).build();
        Medication m1 = Medication.builder().name("PARACETAMOL").code("001").weight(35).imageUrl("https://tinyurl.com/3ykwwwe4").build();
        Medication m2 = Medication.builder().name("INSULIN").code("002").weight(315).imageUrl("https://tinyurl.com/3ykwwwe4").build();
        DroneLoad dl1 = DroneLoad.builder().drone(d1).medication(m2).build();
        DroneLoad dl2 = DroneLoad.builder().drone(d2).medication(m1).build();
        return [dl1,dl2];
        */
        Arrays.asList(
                DroneLoad.builder().drone(Drone.builder().batteryCapacity(89).serialNumber("AOOO-12").model(DroneModel.CRUISERWEIGHT).status(DroneState.IDLE).build()).
                        medication(Medication.builder().name("PARACETAMOLw").code("007").weight(35).imageUrl("https://tinyurl.com/3ykwwwe4").build())
                        .loadTime(new Date()).deliveryTime(new Date()).build()
        );

    public static Supplier<List<DroneMonitorLog>> droneMonitorLogSupplier = () ->
            Arrays.asList(
                    DroneMonitorLog.builder().batteryCapacity(25).drone(
                            Drone.builder().batteryCapacity(89).serialNumber("AOOO-1A").model(DroneModel.CRUISERWEIGHT).status(DroneState.IDLE).build()
                    ).build()
            );
}
