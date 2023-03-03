package com.kevin.starwarsapi.controller;

import com.kevin.starwarsapi.dto.FilmDTO;
import com.kevin.starwarsapi.dto.PeopleDTO;
import com.kevin.starwarsapi.service.FilmService;
import com.kevin.starwarsapi.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/starwars/api/people")
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleService service;

    @GetMapping
    public ResponseEntity<List<PeopleDTO>> getAll( @RequestParam(value = "page") int page ){
        List<PeopleDTO> peopleList = service.getAll( page );
        return peopleList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok( peopleList );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(service.getById( id ));
    }

}
