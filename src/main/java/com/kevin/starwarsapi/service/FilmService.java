package com.kevin.starwarsapi.service;

import com.kevin.starwarsapi.dto.FilmDTO;
import com.kevin.starwarsapi.exception.FilmNotFoundException;
import com.kevin.starwarsapi.model.Film;
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

    public List<FilmDTO> getAll(){
        return repository.findAll().stream().map(film -> FilmDTO.parseToDTO( film ) ).collect(Collectors.toList());
    }

    @SneakyThrows
    public FilmDTO getById(int id ){
        Film film = repository.findById( id ).orElse( null );
        if( film == null ){
            throw new FilmNotFoundException("No se encontro el Film");
        }
        return FilmDTO.parseToDTO( film );
    }

}
