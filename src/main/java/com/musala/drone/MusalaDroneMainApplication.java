package com.musala.drone;

import com.musala.drone.model.Drone;
import com.musala.drone.model.DroneLoad;
import com.musala.drone.model.DroneMonitorLog;
import com.musala.drone.model.Medication;
import com.musala.drone.repository.DroneLoadRepository;
import com.musala.drone.repository.DroneMonitoLogRepository;
import com.musala.drone.repository.DroneRepository;
import com.musala.drone.repository.MedicationRepository;
import com.musala.drone.utils.MockDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
public class MusalaDroneMainApplication {
    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private DroneLoadRepository droneLoadRepository;

    @Autowired
    private DroneMonitoLogRepository droneMonitoLogRepository;


    public static void main(String[] args) {
        SpringApplication.run(MusalaDroneMainApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            List<Drone> drones = droneRepository.findAll();
            if (drones.isEmpty()) {
                log.info("******* Inserting Drones to DB *******");
                droneRepository.saveAll(MockDataUtil.droneSupplier.get());
            } else {
                log.info("******* Drones stored in DB Size :: {}", drones.size());
                log.info("******* Drones stored in DB :: {}", drones);
            }

            List<Medication> medications = medicationRepository.findAll();
            if (medications.isEmpty()) {
                log.info("******* Inserting Medications to DB *******");
                medicationRepository.saveAll(MockDataUtil.medicationSupplier.get());
            } else {
                log.info("******* Medications stored in DB Size :: {}", medications.size());
                log.info("******* Medications stored in DB :: {}", medications);
            }

            List<DroneLoad> droneLoads = droneLoadRepository.findAll();
            if (droneLoads.isEmpty()) {
                log.info("******* Inserting droneLoads to DB *******");
                droneLoadRepository.saveAll(MockDataUtil.droneLoadSupplier.get());
            } else {
                log.info("******* droneLoads stored in DB Size :: {}", droneLoads.size());
                log.info("******* droneLoads stored in DB :: {}", droneLoads);
            }

            List<DroneMonitorLog> droneLogs = droneMonitoLogRepository.findAll();
            if (droneLogs.isEmpty()) {
                log.info("******* Inserting droneLogs to DB *******");
                droneMonitoLogRepository.saveAll(MockDataUtil.droneMonitorLogSupplier.get());
            } else {
                log.info("******* droneLogs stored in DB Size :: {}", droneLogs.size());
                log.info("******* droneLogs stored in DB :: {}", droneLogs);
            }
        };
    }
}
