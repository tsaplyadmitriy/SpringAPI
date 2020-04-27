package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserPreferences {

    private @Id    @GeneratedValue    Long id;
    private String categoryList;
    private Duration duration;

    UserPreferences(String categoryList,Duration duration){
      String categories=categoryList;
        this.categoryList = categories;
        this.duration = duration;

    }

   public UserPreferences(){

    }



}
