package com.example.superherp.Service;

import com.example.superherp.models.Hero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface HeroService {
    Hero save(Hero hero);
    Optional<Hero> findById(Long aLong);


}
