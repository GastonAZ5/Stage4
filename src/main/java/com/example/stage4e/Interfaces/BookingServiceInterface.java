package com.example.stage4e.Interfaces;

import com.example.stage4e.Entities.Booking;

public interface BookingServiceInterface {
    public String AddBooking(Booking booking, Integer userId, Integer campingPlaceId);
}
