package com.example.superherp.Repository;

import com.example.superherp.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface HeroRepository extends JpaRepository<Hero,Long> {
    @Override
    Optional<Hero> findById(Long aLong);
}
