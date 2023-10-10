package com.walmart.alertsapi.controller;

import com.walmart.alertsapi.Dto.AlertDto;
import com.walmart.alertsapi.Dto.AlertsDetailDto;
import com.walmart.alertsapi.Dto.ResponseDto;
import com.walmart.alertsapi.entity.Alert;
import com.walmart.alertsapi.service.IAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(path = "/alerts", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AlertsController {
    @Autowired
    private IAlertService alertService;
    @PostMapping("")
    public ResponseEntity<ResponseDto> postAlerts(@RequestBody AlertDto alertDto){
        try {
            alertService.createAlert(alertDto);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(alertDto.getAlert_id(), ""));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(alertDto.getService_id(), "Internal Server Error"));
        }
    }

    @GetMapping
    public ResponseEntity<?> fetchAlerts(@RequestParam String service_id,
                                                       @RequestParam Long start_ts,
                                                       @RequestParam Long end_ts) {
        try {
            ArrayList<Alert> alertList = alertService.findByIDandTS(service_id, start_ts, end_ts);
            if (alertList.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseDto(service_id, "No alert found based on the service id, start ts and end ts given"));
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new AlertsDetailDto(service_id, alertList.get(0).getServiceName(), alertList));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(service_id, "Internal Server Error"));
        }
    }

}
