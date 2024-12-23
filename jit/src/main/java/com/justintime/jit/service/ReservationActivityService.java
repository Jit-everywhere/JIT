package com.justintime.jit.service;

import com.justintime.jit.entity.ReservationActivity;

import java.util.List;
import java.util.Optional;

public interface ReservationActivityService{
    List<ReservationActivity> getAllReservationActivities();
    ReservationActivity createReservationActivity(ReservationActivity reservationActivity);
    Optional<ReservationActivity> getReservationActivityById(Long id);
    void deleteReservationActivity(Long id);
}
