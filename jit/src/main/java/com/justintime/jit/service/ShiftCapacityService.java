package com.justintime.jit.service;

import com.justintime.jit.entity.ShiftCapacity;

import java.util.List;

public interface ShiftCapacityService {

    List<ShiftCapacity> getAllShiftCapacities();
    List<ShiftCapacity> getShiftCapacitiesByRestaurantId(Long restaurantId);
    ShiftCapacity addShiftCapacity(ShiftCapacity shiftCapacity);
    ShiftCapacity updateShiftCapacity(Long id, ShiftCapacity updatedShiftCapacity);
    void deleteShiftCapacity(Long id);
}
