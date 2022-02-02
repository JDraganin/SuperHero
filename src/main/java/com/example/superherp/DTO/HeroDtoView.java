package com.example.superherp.DTO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
public class HeroDtoView {

    @NotEmpty
    @Size(min = 2, max = 20, message = "Is not a valid first name")
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 20, message = "Is not a valid last name")
    private String lastName;

    @NotEmpty
    @Size(min = 2, max = 20, message = "Is not a valid super hero name")
    private String superHeroName;

    @Pattern(regexp = "^(.+)@(.+)$")
    private String email;

    @Past
    private LocalDate dateOfBirth;





}
