package com.tracker.entities;

import com.tracker.enums.Priority;
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
@DiscriminatorValue("bug")
public class Bug extends Issue {

    private Integer estimatedPointValue;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Priority priority;
}
