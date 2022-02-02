package com.example.superherp.Service;

import com.example.superherp.models.Hero;
import com.example.superherp.models.Mission;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface MissionService {
    Mission save(Mission mission);
    Optional<Mission> findById(Long aLong);
}
