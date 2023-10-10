package com.walmart.alertsapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data @AllArgsConstructor
public class ResponseDto {
    private String alertId;
    private String error;
}
