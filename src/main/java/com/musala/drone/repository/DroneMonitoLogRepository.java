package com.musala.drone.repository;

import com.musala.drone.model.DroneMonitorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneMonitoLogRepository extends JpaRepository<DroneMonitorLog, Integer> {
}
