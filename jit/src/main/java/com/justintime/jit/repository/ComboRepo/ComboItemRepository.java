package com.justintime.jit.repository.ComboRepo;

import com.justintime.jit.entity.ComboEntities.ComboItem;
import com.justintime.jit.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboItemRepository extends BaseRepository<ComboItem,Long> {
}
