package com.kevin.starwarsapi.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kevin.starwarsapi.model.People;
import com.kevin.starwarsapi.model.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PeopleRepository {

    private final RestTemplate restTemplate;
    private static final String PATH = "https://swapi.dev/api/people/";

    public List<People> findAll( int page ){
        try {
            String res = restTemplate.getForObject(PATH + "?page="+ page + "&format=json", String.class );
            Type type = new TypeToken<ResponseWrapper<People>>(){}.getType();
            ResponseWrapper<People> peopleResData = new Gson().fromJson(res, type);
            return peopleResData.getResults();
        }catch (Exception e){
            return List.of();
        }

    }

    public Optional<People> findById(int id ){
        try {
            People people = restTemplate.getForObject(PATH+ id+"?format=json", People.class );
            return Optional.of( people );
        }catch (Exception e){
            return Optional.empty();
        }
    }

}
