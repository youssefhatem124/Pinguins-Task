package com.tracker.entities;

import com.tracker.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
@Setter
@Getter
@DiscriminatorValue("story")
public class Story extends Issue {

    private Integer estimatedPointValue;
    @Enumerated(EnumType.STRING)
    private Status status;

}
