package com.example.superherp.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Hero {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String superHeroName;

    @NonNull
    private String email;

    @NonNull
    private LocalDate dateOfBirth;


    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "heroes_missions",
            joinColumns = {@JoinColumn(name = "hero_id")},
            inverseJoinColumns = {@JoinColumn(name = "mission_id")}
    )

    private List<Mission> missions = new ArrayList<>();

    public Hero addMission(Mission mission) {
        this.missions.add(mission);
        return this;

    }

    @Override
    public String toString() {
        return "HeroDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", superHeroName='" + superHeroName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';


    }
}
