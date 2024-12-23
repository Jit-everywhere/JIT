package com.justintime.jit.repository;

import com.justintime.jit.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category,Long>{
    boolean existsByCategoryName(String categoryName);
}
