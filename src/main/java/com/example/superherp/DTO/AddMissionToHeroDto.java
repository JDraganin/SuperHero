package com.example.superherp.DTO;

import jdk.jfr.BooleanFlag;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AddMissionToHeroDto {
    @NotNull(message = "Please provide mission id")
    private Long id;

    @NotEmpty(message = "Please provide mission name")
    private String missionName;

    @BooleanFlag
    private Boolean isCompleted;
}
