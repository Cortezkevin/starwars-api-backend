package com.kevin.starwarsapi.repository;

import com.google.gson.Gson;
import com.kevin.starwarsapi.model.Film;
import com.kevin.starwarsapi.model.ResponseWrapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import com.google.gson.reflect.TypeToken;

@Repository
@RequiredArgsConstructor
public class FilmRepository {

    private final RestTemplate restTemplate;
    private static final String PATH = "https://swapi.dev/api/films/";

    public List<Film> findAll(){
        String res = restTemplate.getForObject(PATH + "?format=json", String.class );
        Type type = new TypeToken<ResponseWrapper<Film>>(){}.getType();
        ResponseWrapper<Film> filmResData = new Gson().fromJson(res, type);
        return filmResData.getResults();
    }

    public Optional<Film> findById(int id ){
        try {
            Film film = restTemplate.getForObject(PATH+ id+"?format=json", Film.class );
            return Optional.of( film );
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
