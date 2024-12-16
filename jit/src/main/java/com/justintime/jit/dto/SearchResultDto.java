package com.justintime.jit.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SearchResultDto {
    // Getters and Setters
    private String type; // "Restaurant" or "Food"
    private String name;
    private List<String> associatedNames; // e.g., foods in a restaurant or restaurants serving a food
    private Double distance;
}
