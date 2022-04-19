package com.tracker.service;

import com.tracker.dto.DeveloperDto;
import com.tracker.dto.ValidDroneDto;
import com.tracker.entities.Developer;

import java.util.List;

public interface DeveloperService {

    List<DeveloperDto> getAllDevelopers();
    DeveloperDto getDeveloperByName(String name);
    DeveloperDto updateDeveloper(String name,DeveloperDto developerDto);

    DeveloperDto updateDeveloper(DeveloperDto developerDto);

    String deleteDeveloperByName(String name);
    DeveloperDto addDeveloper(DeveloperDto developerDto);


}
