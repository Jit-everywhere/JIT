package com.justintime.jit.service.impl;

import com.justintime.jit.service.MenuItemService;
import com.justintime.jit.repository.MenuItemRepository;
import com.justintime.jit.entity.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

    @Service
    public class MenuItemServiceImpl extends BaseServiceImpl<MenuItem,Long> implements MenuItemService {

        @Autowired
        private MenuItemRepository menuItemRepository;

        public List<MenuItem> getAllMenuItems() {
            return menuItemRepository.findAll();
        }

        public List<MenuItem> getMenuItemsByRestaurantId(Long restaurantId) {
            return menuItemRepository.findByRestaurantId(restaurantId);
        }

        public MenuItem addMenuItem(MenuItem menuItem) {
            menuItem.setUpdatedDttm(LocalDateTime.now());
            return menuItemRepository.save(menuItem);
        }

        public MenuItem updateMenuItem(Long id, MenuItem updatedItem) {
            MenuItem existingItem = menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("MenuItem not found"));
            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setStock(updatedItem.getStock());
            existingItem.setUpdatedDttm(LocalDateTime.now());
            return menuItemRepository.save(existingItem);
        }

        public void deleteMenuItem(Long id) {
            menuItemRepository.deleteById(id);
        }
    }


