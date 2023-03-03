package com.kevin.starwarsapi.service;

import com.kevin.starwarsapi.dto.PeopleDTO;
import com.kevin.starwarsapi.exception.FilmNotFoundException;
import com.kevin.starwarsapi.model.People;
import com.kevin.starwarsapi.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final PeopleRepository repository;

    public List<PeopleDTO> getAll( int page ){
        return repository.findAll( page ).stream().map(people -> PeopleDTO.parseToDTO( people ) ).collect(Collectors.toList());
    }

    @SneakyThrows
    public PeopleDTO getById(int id ){
        People people = repository.findById( id ).orElse( null );
        if( people == null ){
            throw new FilmNotFoundException("No se encontro el Film");
        }
        return PeopleDTO.parseToDTO( people );
    }

}
