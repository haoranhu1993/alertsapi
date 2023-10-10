package com.walmart.alertsapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Alert {
    @Id
    @Column(name = "alert_id")
    private String alertId;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "model")
    private String model;

    @Column(name = "alert_type")
    private String alertType;

    @Column(name = "alert_ts")
    private Long alertTS;

    @Column(name = "severity")
    private String severity;

    @Column(name = "team_slack")
    private String teamSlack;
}
