package com.justintime.jit.service.impl;

import com.justintime.jit.entity.ReservationActivity;
import com.justintime.jit.repository.ReservationActivityRepository;
import com.justintime.jit.service.ReservationActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationActivityServiceImpl implements ReservationActivityService {
    @Autowired
    private ReservationActivityRepository reservationActivityRepository;

    public List<ReservationActivity> getAllReservationActivities() {
        return reservationActivityRepository.findAll();
    }

    public Optional<ReservationActivity> getReservationActivityById(Long id) {
        return reservationActivityRepository.findById(id);
    }

    public ReservationActivity createReservationActivity(ReservationActivity reservationActivity) {
        return reservationActivityRepository.save(reservationActivity);
    }

    public void deleteReservationActivity(Long id) {
        reservationActivityRepository.deleteById(id);
    }
}
