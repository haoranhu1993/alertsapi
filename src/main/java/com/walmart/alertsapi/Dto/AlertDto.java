package com.walmart.alertsapi.Dto;

import lombok.Data;

@Data
public class AlertDto {
    private String alert_id;
    private String service_id;
    private String service_name;
    private String model;
    private String alert_type;
    private Long alert_ts;
    private String severity;
    private String team_slack;
}
