package com.example.stage4e.Controller;

import com.example.stage4e.Entities.Booking;
import com.example.stage4e.Service.BookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingServiceImp bookingServiceImp;

    @PostMapping("/add/{idUser}/{idCampingSpace}")
    public ResponseEntity AddBooking(@RequestBody Booking booking , @PathVariable Integer idUser,@PathVariable Integer idCampingSpace ){
        return new ResponseEntity<>(bookingServiceImp.AddBooking(booking,idUser,idCampingSpace), HttpStatus.valueOf(200));
    }
}
