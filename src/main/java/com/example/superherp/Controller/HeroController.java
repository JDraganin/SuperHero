package com.example.superherp.Controller;

import com.example.superherp.DTO.HeroDto;
import com.example.superherp.DTO.HeroDtoView;
import com.example.superherp.DTO.AddMissionToHeroDto;
import com.example.superherp.Service.HeroService;
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
@RequestMapping("/heroes")
public class HeroController {
    @Autowired
    private MissionService missionService;
    @Autowired
    private HeroService heroService;
    private final ModelMapper modelMapper = new ModelMapper();



    @PostMapping
    ResponseEntity<HeroDto> createHero(@Valid @RequestBody HeroDto newHero) {

        Hero hero = modelMapper.map(newHero, Hero.class);
        Hero createdHero = heroService.save(hero);
        HeroDto mapped = modelMapper.map(createdHero, HeroDto.class);
        return ResponseEntity.ok(mapped);
    }

    @GetMapping("/{id}")
    ResponseEntity<HeroDto> findById(@PathVariable(value = "id") Long id) {
        Optional<Hero> foundedHero = heroService.findById(id);
        if (foundedHero.isEmpty()) {
            throw new HeroNotFoundException(id);
        }
        HeroDto mappedDto = modelMapper.map(foundedHero.get(), HeroDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<HeroDtoView> addMissionToHero(@Valid @PathVariable(value = "id") Long id, @RequestBody AddMissionToHeroDto addMissionDTO) {
        Mission addedMission = modelMapper.map(addMissionDTO, Mission.class);
        Optional<Mission> byId = missionService.findById(addedMission.getId());

        if (byId.isEmpty()) {
            throw new MissionNotFoundException(addedMission.getId());
        }

        Optional<Hero> hero = heroService.findById(id);
        if (hero.isEmpty()) {
            throw new HeroNotFoundException(id);
        }
        heroService.save(hero.get().addMission(byId.get()));
        missionService.save(byId.get().addHero(hero.get()));

        HeroDtoView mapped = modelMapper.map(hero.get(), HeroDtoView.class);
        return ResponseEntity.ok(mapped);


    }


}
