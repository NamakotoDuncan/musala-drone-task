package com.musala.drone.utils;

import com.musala.drone.model.Drone;
import com.musala.drone.model.DroneState;
import com.musala.drone.model.Medication;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MockDataUtil {
    private MockDataUtil(){

    }

    public static Supplier<List<Drone>> droneSupplier =  () ->
            Arrays.asList(
        Drone.builder().batteryCapacity(89).serialNumber("AOOO1").model("SONY").status(DroneState.IDLE).build(),
        Drone.builder().batteryCapacity(89).serialNumber("AOOO2").model("SAMSUNG").status(DroneState.IDLE).build(),
        Drone.builder().batteryCapacity(89).serialNumber("AOOO3").model("APPLE").status(DroneState.IDLE).build(),
        Drone.builder().batteryCapacity(89).serialNumber("AOOO4").model("LG").status(DroneState.IDLE).build()
    );

    public static Supplier<List<Medication>> medicationSupplier = () ->
            Arrays.asList(Medication.builder().name("PARACETAMOL").code("001").weight(35).imageUrl("https://tinyurl.com/3ykwwwe4").build(),
    Medication.builder().name("PARACETAMOL").code("001").weight(250).imageUrl("https://tinyurl.com/3ykwwwe4").build(),
    Medication.builder().name("INSULIN").code("002").weight(315).imageUrl("https://tinyurl.com/3ykwwwe4").build(),
    Medication.builder().name("EYE DROP").code("003").weight(125).imageUrl("https://tinyurl.com/3ykwwwe4").build(),
    Medication.builder().name("STEROID").code("002").weight(200).imageUrl("https://tinyurl.com/3ykwwwe4").build()
    );
}
