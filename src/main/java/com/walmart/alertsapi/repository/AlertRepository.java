package com.walmart.alertsapi.repository;

import com.walmart.alertsapi.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AlertRepository extends JpaRepository<Alert, String> {
    @Query("select a from Alert a where a.serviceId = :service_id AND a.alertTS >= :start_ts " +
            "AND a.alertTS <= :end_ts")
    ArrayList<Alert> findByIDandTS(String service_id, Long start_ts, Long end_ts);
}
