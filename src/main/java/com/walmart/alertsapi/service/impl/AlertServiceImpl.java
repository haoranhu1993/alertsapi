package com.walmart.alertsapi.service.impl;

import com.walmart.alertsapi.Dto.AlertDto;
import com.walmart.alertsapi.entity.Alert;
import com.walmart.alertsapi.mapper.AlertsMapper;
import com.walmart.alertsapi.repository.AlertRepository;
import com.walmart.alertsapi.service.IAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlertServiceImpl implements IAlertService {
    @Autowired
    private AlertRepository alertRepository;
    @Override
    public void createAlert(AlertDto alertDto) {
            Alert alert = AlertsMapper.mapToAlert(alertDto, new Alert());

            Alert savedAlert = alertRepository.save(alert);
    }

    @Override
    public ArrayList<Alert> findByIDandTS(String service_id, Long start_ts, Long end_ts) {
        ArrayList<Alert> alertList = new ArrayList<>();
        alertList = alertRepository.findByIDandTS(service_id, start_ts, end_ts);
        return alertList;
    }
}
