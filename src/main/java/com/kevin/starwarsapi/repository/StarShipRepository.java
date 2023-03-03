package com.kevin.starwarsapi.repository;

import com.kevin.starwarsapi.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StarShipRepository {

    private final RestTemplate restTemplate;
    private static final String PATH = "https://swapi.dev/api/planets/";

    public Optional<Film> getById(int id ){
        try {
            Film planet = restTemplate.getForObject(PATH+ id+"?format=json", Film.class );
            return Optional.of( planet );
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
