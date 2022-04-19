package com.tracker.mapper;

import com.tracker.dto.DeveloperDto;
import com.tracker.entities.Developer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeveloperMapper {

    DeveloperMapper INSTANCE = Mappers.getMapper(DeveloperMapper.class);

    DeveloperDto entityToDto(Developer developer);
    Developer dtoToEntity(DeveloperDto developerDto);
}
