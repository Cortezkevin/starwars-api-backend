package com.kevin.starwarsapi.dto;

import com.kevin.starwarsapi.model.Film;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {
    private int episode_id;
    private String title;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private String url;

    public static FilmDTO parseToDTO( Film film){
        return new FilmDTO( film.getEpisode_id(), film.getTitle(), film.getOpening_crawl(), film.getDirector(), film.getProducer(), film.getRelease_date(), film.getUrl());
    }
}
