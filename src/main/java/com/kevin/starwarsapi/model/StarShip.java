package com.kevin.starwarsapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarShip {
    public String name;
    public String model;
    public String manufacturer;
    public String cost_in_credits;
    public String length;
    public String max_atmosphering_speed;
    public String crew;
    public String passengers;
    public String cargo_capacity;
    public String consumables;
    public String hyperdrive_rating;
    @JsonProperty("MGLT")
    public String mGLT;
    public String starship_class;
    public List<String> pilots;
    public List<String> films;
    public String created;
    public String edited;
    public String url;
}
