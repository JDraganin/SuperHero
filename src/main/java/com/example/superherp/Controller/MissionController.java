package com.example.superherp.Controller;

import com.example.superherp.DTO.HeroDto;

import com.example.superherp.DTO.MissionDto;
import com.example.superherp.Service.MissionService;
import com.example.superherp.Validator.HeroNotFoundException;
import com.example.superherp.Validator.MissionNotFoundException;
import com.example.superherp.models.Hero;
import com.example.superherp.models.Mission;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/mission")
public class MissionController {
    @Autowired
    private MissionService missionService;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    ResponseEntity<MissionDto> createMission(@Valid @RequestBody MissionDto newMission) {

        Mission mission = modelMapper.map(newMission, Mission.class);
        Mission createdMission = missionService.save(mission);
        MissionDto mapped = modelMapper.map(createdMission, MissionDto.class);
        return ResponseEntity.ok(mapped);
    }

    @GetMapping("/{id}")
    ResponseEntity<MissionDto> findById(@PathVariable(value = "id") Long id) {
        Optional<Mission> foundedMission = missionService.findById(id);
        if (foundedMission.isEmpty()) {
            throw new MissionNotFoundException(id);
        }
       MissionDto mapped = modelMapper.map(foundedMission.get(), MissionDto.class);
        return ResponseEntity.ok(mapped);
    }

}
