package com.kevin.starwarsapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class People {
    public String name;
    public String height;
    public String mass;
    public String hair_color;
    public String skin_color;
    public String eye_color;
    public String birth_year;
    public String gender;
    public String homeworld;
    public List<String> films;
    public List<Object> species;
    public List<String> vehicles;
    public List<String> starships;
    public String created;
    public String edited;
    public String url;
}
