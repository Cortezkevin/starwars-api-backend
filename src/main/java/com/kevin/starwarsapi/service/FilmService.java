package com.kevin.starwarsapi.service;

import com.kevin.starwarsapi.dto.FilmDTO;
import com.kevin.starwarsapi.dto.PeopleDTO;
import com.kevin.starwarsapi.exception.FilmNotFoundException;
import com.kevin.starwarsapi.model.Film;
import com.kevin.starwarsapi.model.People;
import com.kevin.starwarsapi.model.ResponseWrapper;
import com.kevin.starwarsapi.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository repository;

    public ResponseWrapper<FilmDTO> getAll(){
        ResponseWrapper<Film> responseWrapper = repository.findAll( );
        List<FilmDTO> filmDTOList = responseWrapper.getResults().stream().map(f -> FilmDTO.parseToDTO( f )).collect(Collectors.toList());
        ResponseWrapper<FilmDTO> filmDTOResponseWrapper = ResponseWrapper.<FilmDTO>builder()
                .count( responseWrapper.getCount() )
                .next( responseWrapper.getNext())
                .previous( responseWrapper.getPrevious())
                .results( filmDTOList )
                .build();
        return filmDTOResponseWrapper;
    }

    @SneakyThrows
    public Film getById(int id ){
        Film film = repository.findById( id ).orElse( null );
        if( film == null ){
            throw new FilmNotFoundException("No se encontro el Film");
        }
        return film;
    }

}
