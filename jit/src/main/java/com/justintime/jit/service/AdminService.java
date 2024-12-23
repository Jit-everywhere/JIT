package com.justintime.jit.service;

import com.justintime.jit.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService{
    List<Admin> getAllAdmins();
    Optional<Admin> getAdminById(Long id);
    Admin updateAdmin(Long id, Admin adminDetails);
    Admin saveAdmin(Admin admin);
    void deleteAdmin(Long id);
}
