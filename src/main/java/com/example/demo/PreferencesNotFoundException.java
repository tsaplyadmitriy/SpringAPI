package com.example.demo;

public class PreferencesNotFoundException extends RuntimeException {

    PreferencesNotFoundException(Long id){
        super("Could not found entity with id: "+id+ " .");
    }
}
