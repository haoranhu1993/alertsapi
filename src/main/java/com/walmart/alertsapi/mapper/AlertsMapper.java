package com.walmart.alertsapi.mapper;

import com.walmart.alertsapi.Dto.AlertDto;
import com.walmart.alertsapi.entity.Alert;

public class AlertsMapper {
    public static AlertDto mapToAlertDto(Alert alert, AlertDto alertDto) {
        alertDto.setAlert_id(alert.getAlertId());
        alertDto.setService_id(alert.getServiceId());
        alertDto.setService_name(alert.getServiceName());
        alertDto.setModel(alert.getModel());
        alertDto.setAlert_type(alert.getAlertType());
        alertDto.setAlert_ts(alert.getAlertTS());
        alertDto.setSeverity(alert.getSeverity());
        alertDto.setTeam_slack(alert.getTeamSlack());
        return alertDto;
    }

    public static Alert mapToAlert(AlertDto alertDto, Alert alert) {
        alert.setAlertId(alertDto.getAlert_id());
        alert.setServiceId(alertDto.getService_id());
        alert.setServiceName(alertDto.getService_name());
        alert.setModel(alertDto.getModel());
        alert.setAlertType(alertDto.getAlert_type());
        alert.setAlertTS(alertDto.getAlert_ts());
        alert.setSeverity(alertDto.getSeverity());
        alert.setTeamSlack(alertDto.getTeam_slack());
        return alert;
    }
}
