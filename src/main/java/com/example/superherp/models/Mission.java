package com.example.superherp.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor

public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String missionName;

    private Boolean isCompleted;

    @ManyToMany(mappedBy = "missions", fetch = FetchType.LAZY)

    private List<Hero> heroesInTheMission;

    public Mission addHero(Hero hero) {
        this.heroesInTheMission.add(hero);
        return this;
    }

    @Override
    public String toString() {
        return "MissionDto{" +
                "missionName='" + missionName + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
