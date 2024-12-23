package com.justintime.jit.service;

import com.justintime.jit.entity.ReservationActivity;

import java.util.List;
import java.util.Optional;

public interface ReservationActivityService {
    List<ReservationActivity> getAllReservationActivities();
    Optional<ReservationActivity> getReservationActivityById(Long id);
    ReservationActivity updateReservationActivity(Long id, ReservationActivity reservationActivityDetails);
    ReservationActivity saveReservationActivity(ReservationActivity reservationActivity);
    void deleteReservationActivity(Long id);
}
