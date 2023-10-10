package com.walmart.alertsapi.Dto;

import com.walmart.alertsapi.entity.Alert;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class AlertsDetailDto {
    private String serviceId;
    private String serviceName;
    private ArrayList<Alert> alertsList;
}
