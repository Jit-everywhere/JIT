package com.justintime.jit.service.impl;

import com.justintime.jit.entity.ShiftCapacity;
import com.justintime.jit.repository.ShiftCapacityRepository;
import com.justintime.jit.service.ShiftCapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftCapacityServiceImpl implements ShiftCapacityService {

    @Autowired
    private ShiftCapacityRepository shiftCapacityRepository;

    public List<ShiftCapacity> getAllShiftCapacities() {
        return shiftCapacityRepository.findAll();
    }

    public List<ShiftCapacity> getShiftCapacitiesByRestaurantId(Long restaurantId) {
        return shiftCapacityRepository.findByRestaurantId(restaurantId);
    }

    public ShiftCapacity addShiftCapacity(ShiftCapacity shiftCapacity) {
        return shiftCapacityRepository.save(shiftCapacity);
    }

    public ShiftCapacity updateShiftCapacity(Long id, ShiftCapacity updatedShiftCapacity) {
        ShiftCapacity existingShiftCapacity = shiftCapacityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShiftCapacity not found"));

        existingShiftCapacity.setStartTime(updatedShiftCapacity.getStartTime());
        existingShiftCapacity.setEndTime(updatedShiftCapacity.getEndTime());
        existingShiftCapacity.setTotalCapacity(updatedShiftCapacity.getTotalCapacity());
        existingShiftCapacity.setUpdatedDttm(updatedShiftCapacity.getUpdatedDttm());

        return shiftCapacityRepository.save(existingShiftCapacity);
    }

    public void deleteShiftCapacity(Long id) {
        shiftCapacityRepository.deleteById(id);
    }
}
