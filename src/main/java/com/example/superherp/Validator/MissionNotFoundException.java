package com.example.superherp.Validator;

public class MissionNotFoundException extends RuntimeException {
    public MissionNotFoundException(Long id) {
        super("Mission with id  not found : " + id);
    }
}
