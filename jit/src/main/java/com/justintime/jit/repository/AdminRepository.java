package com.justintime.jit.repository;

import com.justintime.jit.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends BaseRepository<Admin, Long> {
}
