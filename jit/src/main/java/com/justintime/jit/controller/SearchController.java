package com.justintime.jit.controller;

import com.justintime.jit.dto.SearchResultDto;
import com.justintime.jit.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    public List<SearchResultDto> searchByName(
            @RequestParam String query,
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        return searchService.searchByName(query, latitude, longitude);
    }
}
