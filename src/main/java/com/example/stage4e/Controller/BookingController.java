package com.example.stage4e.Controller;

import com.example.stage4e.Entities.Booking;
import com.example.stage4e.Entities.Comment;
import com.example.stage4e.Repository.BookingRepository;
import com.example.stage4e.Service.BookingServiceImp;
import com.example.stage4e.Util.QRCodeGenerator;
import com.google.zxing.WriterException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingServiceImp bookingServiceImp;

    @Autowired
    BookingRepository bookingRepository;


    @PostMapping("/add/{idUser}/{idCampingSpace}")
    public ResponseEntity AddBooking(@RequestBody Booking booking , @PathVariable Integer idUser,@PathVariable Integer idCampingSpace ){
        return new ResponseEntity<>(bookingServiceImp.AddBooking(booking,idUser,idCampingSpace), HttpStatus.valueOf(200));
    }

    @GetMapping("/getAllBooking")
    public ResponseEntity<List<Booking>> getAllBooking() throws IOException, WriterException {
        List<Booking> bookings = bookingServiceImp.getAllBooking();
        if (bookings.size()!=0){
            for (Booking booking: bookings){
                QRCodeGenerator.generateQRCode(booking);
            }

        }
        return new ResponseEntity<>(bookingServiceImp.getAllBooking(),HttpStatus.valueOf(200)) ;
    }

    @GetMapping("/getOneBooking/{idBooking}")
    public ResponseEntity<?> getOneBooking(@PathVariable Integer idBooking) throws WriterException, IOException {
        Booking booking =bookingRepository.getById(idBooking);
        System.out.println(booking);
        QRCodeGenerator.generateQRCode (booking);
        return new ResponseEntity<>(booking,HttpStatus.valueOf(200));
    }

    @PutMapping("/update/{idBooking}/{idCamp}")
    public ResponseEntity<?> updateBooking(@RequestBody Booking booking, @PathVariable Integer idBooking,@PathVariable Integer idCamp){
        return new ResponseEntity<>(bookingServiceImp.UpdateBooking(booking,idBooking,idCamp),HttpStatus.valueOf(200));
    }

    @DeleteMapping("/delete/{idBooking}")
    public ResponseEntity<?> deleteBooking(@PathVariable Integer idBooking){
        return new ResponseEntity<>(bookingServiceImp.DeleteBooking(idBooking),HttpStatus.valueOf(200));
    }
}
