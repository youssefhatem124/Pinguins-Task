package com.tracker.service;

import com.tracker.dto.MedicationDto;
import com.tracker.dto.ValidDroneDto;

import java.util.List;

public interface MedicationService {

    MedicationDto addMedication(MedicationDto medicationDto);
    MedicationDto getMedicationByCode(String code);
    String assignMedicationToDrone(String medicationCode, ValidDroneDto validDrone);
    List<MedicationDto> getMedicationsByDroneId(Integer droneId);
}
