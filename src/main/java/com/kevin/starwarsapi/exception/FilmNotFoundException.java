package com.kevin.starwarsapi.exception;

public class FilmNotFoundException extends Exception{
    public FilmNotFoundException(String message){
        super( message );
    }
}
