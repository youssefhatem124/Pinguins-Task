package com.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDto {

    private static final int SERIAL_NUMBER_MIN = 3;
    private static final int SERIAL_NUMBER_MAX = 20;

    @Size(max = SERIAL_NUMBER_MAX, min = SERIAL_NUMBER_MIN)
    @NotNull
    @NotBlank(message = "not allow for empty name")
    private String name;
}
