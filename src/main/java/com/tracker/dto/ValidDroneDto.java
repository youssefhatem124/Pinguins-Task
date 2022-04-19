package com.tracker.dto;

import com.tracker.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidDroneDto {

    private Integer id;
    private String serialNumber;
    private Long weightLimit;
    private Integer batteryLevel;
    private State state;
}

