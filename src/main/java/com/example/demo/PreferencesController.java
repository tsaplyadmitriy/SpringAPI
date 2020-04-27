package com.example.demo;


import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
public class PreferencesController {

    private  final PreferencesRepository repository;

    public PreferencesController(PreferencesRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/prefs")
    List<UserPreferences> all(){
        return repository.findAll();
    }

    @PostMapping("/prefs")
    UserPreferences newUserPreferences (@RequestBody UserPreferences prefs){
        return repository.save(prefs);
    }

    @GetMapping("/prefs/{idValue}")
    UserPreferences one(@PathVariable Long idValue){
        return repository.findById(idValue).orElseThrow(()-> new PreferencesNotFoundException(idValue));
    }

    @PostMapping("/prefs/{idValue}")
    UserPreferences replace(@RequestBody UserPreferences userPref, @PathVariable Long idValue){
        return repository.findById(idValue).map(pref ->{
            pref.setCategoryList(userPref.getCategoryList());
            pref.setDuration(userPref.getDuration());
            return repository.save(pref);
        }).orElseGet(()->{
            userPref.setId(idValue);
            return repository.save(userPref);
        });


    }

    @DeleteMapping("/prefs/{idValue}")
    void delete(@PathVariable Long idValue){
        repository.deleteById(idValue);
    }

}
