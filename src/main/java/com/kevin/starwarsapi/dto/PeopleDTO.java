package com.kevin.starwarsapi.dto;

import com.kevin.starwarsapi.model.Film;
import com.kevin.starwarsapi.model.People;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {

    private String name;
    private String height;
    private String mass;
    private String birth_year;
    private String gender;
    private String url;

    public static PeopleDTO parseToDTO( People people ){
        return PeopleDTO.builder().name(people.getName()).height(people.getHeight()).mass(people.getMass()).birth_year(people.getBirth_year()).gender(people.getGender()).url(people.getUrl()).build();
    }
}
