package com.kevin.starwarsapi.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kevin.starwarsapi.model.Film;
import com.kevin.starwarsapi.model.Planet;
import com.kevin.starwarsapi.model.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PlanetRepository {

    private final RestTemplate restTemplate;
    private static final String PATH = "https://swapi.dev/api/planets/";

    public List<Planet> getAll( String page ){
        String res = restTemplate.getForObject(PATH + "?page="+ page +"&format=json", String.class );
        Type type = new TypeToken<ResponseWrapper<Planet>>(){}.getType();
        ResponseWrapper<Planet> planetResData = new Gson().fromJson(res, type);
        return planetResData.getResults();
    }

    public Optional<Planet> getById(int id ){
        try {
            Planet planet = restTemplate.getForObject(PATH+ id+"?format=json", Planet.class );
            return Optional.of( planet );
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
