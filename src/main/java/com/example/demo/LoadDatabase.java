package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;


@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PreferencesRepository repo) {

        return args -> {

            ArrayList<Category> catList =new ArrayList<>(Arrays.asList(Category.ARCHITECTURE));
            log.info("Preloading " + repo.save(new UserPreferences(catList.toString(), Duration.FOUR_HOUR)));
            log.info("Preloading " + repo.save(new UserPreferences(catList.toString(), Duration.TWO_HOUR)));
        };
    }

}
