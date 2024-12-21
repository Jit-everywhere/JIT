package com.justintime.jit.repository;

import com.justintime.jit.entity.Category;

public interface CategoryRepository extends BaseRepository<Category,Long>{
    boolean existsByCategoryName(String categoryName);
}
