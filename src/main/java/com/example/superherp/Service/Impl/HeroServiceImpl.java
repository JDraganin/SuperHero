package com.example.superherp.Service.Impl;

import com.example.superherp.Repository.HeroRepository;
import com.example.superherp.Service.HeroService;
import com.example.superherp.models.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Optional<Hero> findById(Long id) {
        return heroRepository.findById(id);
    }


}
