package com.tracker.mapper;

import com.tracker.dto.MedicationDto;
import com.tracker.entities.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicationMapper {

    MedicationMapper INSTANCE = Mappers.getMapper(MedicationMapper.class);

    MedicationDto entityToDto(Medication medication);
    Medication dtoToEntity(MedicationDto medicationDto);
}
