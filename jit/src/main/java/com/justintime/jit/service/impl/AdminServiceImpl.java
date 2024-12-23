package com.justintime.jit.service.impl;

import com.justintime.jit.entity.Admin;
import com.justintime.jit.repository.AdminRepository;
import com.justintime.jit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin adminDetails) {
        return adminRepository.findById(id).map(admin -> {
            admin.setRestaurant(adminDetails.getRestaurant());
            admin.setUser(adminDetails.getUser());
            admin.setCreatedDttm(adminDetails.getCreatedDttm());
            admin.setUpdatedDttm(adminDetails.getUpdatedDttm());
            return adminRepository.save(admin);
        }).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
