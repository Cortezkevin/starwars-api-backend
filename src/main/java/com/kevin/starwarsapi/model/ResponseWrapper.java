package com.kevin.starwarsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper<T> {
    private int count;
    private String next;
    private String previous;
    private List<T> results;
}
