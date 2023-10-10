package com.walmart.alertsapi.service;

import com.walmart.alertsapi.Dto.AlertDto;
import com.walmart.alertsapi.entity.Alert;

import java.util.ArrayList;

public interface IAlertService {
    void createAlert(AlertDto alertDto);

    ArrayList<Alert> findByIDandTS(String service_id, Long start_ts, Long end_ts);
}
