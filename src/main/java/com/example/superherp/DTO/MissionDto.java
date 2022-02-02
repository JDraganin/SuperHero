package com.example.superherp.DTO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jdk.jfr.BooleanFlag;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class MissionDto {

    @NotEmpty(message = "Please provide mission name")
    private String missionName;

    @BooleanFlag
    private Boolean isCompleted;
    @JsonIgnoreProperties("missions")
    private List<HeroDto> heroesInTheMission;


}
