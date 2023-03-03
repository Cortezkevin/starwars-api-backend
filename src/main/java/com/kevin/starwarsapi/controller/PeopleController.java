package com.kevin.starwarsapi.controller;

import com.kevin.starwarsapi.dto.FilmDTO;
import com.kevin.starwarsapi.dto.PeopleDTO;
import com.kevin.starwarsapi.model.People;
import com.kevin.starwarsapi.model.ResponseWrapper;
import com.kevin.starwarsapi.service.FilmService;
import com.kevin.starwarsapi.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/starwars/api/people")
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleService service;

    @GetMapping
    public ResponseEntity<ResponseWrapper<PeopleDTO>> getAll(@RequestParam(value = "page", defaultValue = "1") int page ){
        return ResponseEntity.ok( service.getAll( page ) );
    }

    @GetMapping("/getMany/{ids}")
    public ResponseEntity<List<PeopleDTO>> getByManyIds(@PathVariable String ids){
        List<Integer> idList = Arrays.stream( ids.split(",") ).map(id -> Integer.parseInt( id ) ).collect(Collectors.toList());
        List<PeopleDTO> peopleDTOList = new ArrayList<>();
        for ( int id: idList ){
            peopleDTOList.add( PeopleDTO.parseToDTO( service.getById( id ) ));
        }
        return ResponseEntity.ok(peopleDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> getById(@PathVariable int id){
        return ResponseEntity.ok(service.getById( id ));
    }

}
