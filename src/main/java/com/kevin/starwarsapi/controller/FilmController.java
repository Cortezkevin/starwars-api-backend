package com.kevin.starwarsapi.controller;

import com.kevin.starwarsapi.dto.FilmDTO;
import com.kevin.starwarsapi.dto.PeopleDTO;
import com.kevin.starwarsapi.model.Film;
import com.kevin.starwarsapi.model.ResponseWrapper;
import com.kevin.starwarsapi.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/starwars/api/film")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService service;

    @GetMapping
    public ResponseEntity<ResponseWrapper<FilmDTO>> getAll(){
        return ResponseEntity.ok( service.getAll() );
    }

    @GetMapping("/getMany/{ids}")
    public ResponseEntity<List<FilmDTO>> getByManyIds(@PathVariable String ids){
        List<Integer> idList = Arrays.stream( ids.split(",") ).map(id -> Integer.parseInt( id ) ).collect(Collectors.toList());
        List<FilmDTO> filmDTOList = new ArrayList<>();
        for ( int id: idList ){
            filmDTOList.add( FilmDTO.parseToDTO(service.getById( id )) );
        }
        return ResponseEntity.ok(filmDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getById(@PathVariable int id){
        return ResponseEntity.ok(service.getById( id ));
    }

}
