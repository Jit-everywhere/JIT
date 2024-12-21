package com.justintime.jit.service;

import com.justintime.jit.dto.SearchResultDto;
import java.util.List;

public interface SearchService {
    List<SearchResultDto> searchByName(String query);
}
