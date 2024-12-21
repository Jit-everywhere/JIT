package com.justintime.jit.service;

import com.justintime.jit.entity.MenuItem;

import java.util.List;

public interface MenuItemService extends BaseService<MenuItem,Long>{

    List<MenuItem> getAllMenuItems();
    List<MenuItem> getMenuItemsByRestaurantId(Long restaurantId);
    MenuItem addMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Long id, MenuItem updatedItem);
    void deleteMenuItem(Long id);
}
