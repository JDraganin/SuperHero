package com.example.superherp.Service.Impl;

import com.example.superherp.Repository.MissionRepository;
import com.example.superherp.Service.MissionService;
import com.example.superherp.models.Hero;
import com.example.superherp.models.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MissionServiceImpl implements MissionService {
    @Autowired
    private MissionRepository missionRepository;

    @Override
    public Mission save(Mission mission) {
        return missionRepository.save(mission);
    }

    @Override
    public Optional<Mission> findById(Long id) {
        return missionRepository.findById(id);
    }
}
