package com.kevin.starwarsapi.service;

import com.kevin.starwarsapi.dto.PeopleDTO;
import com.kevin.starwarsapi.exception.FilmNotFoundException;
import com.kevin.starwarsapi.model.People;
import com.kevin.starwarsapi.model.ResponseWrapper;
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

    public ResponseWrapper<PeopleDTO> getAll( int page ){
        ResponseWrapper<People> responseWrapper = repository.findAll( page );
        List<PeopleDTO> peopleDTOList = responseWrapper.getResults().stream().map( p -> PeopleDTO.parseToDTO( p )).collect(Collectors.toList());
        ResponseWrapper<PeopleDTO> peopleDTOResponseWrapper = ResponseWrapper.<PeopleDTO>builder()
                .count( responseWrapper.getCount() )
                .next( responseWrapper.getNext())
                .previous( responseWrapper.getPrevious())
                .results( peopleDTOList )
                .build();
        return peopleDTOResponseWrapper;
    }

    @SneakyThrows
    public People getById(int id ){
        People people = repository.findById( id ).orElse( null );
        if( people == null ){
            throw new FilmNotFoundException("No se encontro el personaje con id " + id);
        }
        return people;
    }

}
