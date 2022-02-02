package com.example.superherp.Validator;

public class HeroNotFoundException extends RuntimeException {
    public HeroNotFoundException(Long id) {
        super("Hero with id  not found : " + id);
    }
}
