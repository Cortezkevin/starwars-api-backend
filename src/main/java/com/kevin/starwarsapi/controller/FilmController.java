package com.kevin.starwarsapi.controller;

import com.kevin.starwarsapi.dto.FilmDTO;
import com.kevin.starwarsapi.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/starwars/api/film")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService service;

    @GetMapping
    public ResponseEntity<List<FilmDTO>> getAll(){
        List<FilmDTO> filmList = service.getAll();
        return filmList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok( filmList );
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(service.getById( id ));
    }

}
