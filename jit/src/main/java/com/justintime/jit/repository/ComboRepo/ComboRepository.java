package com.justintime.jit.repository.ComboRepo;

import com.justintime.jit.entity.ComboEntities.Combo;
import com.justintime.jit.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepository extends BaseRepository<Combo,Long> {

}
