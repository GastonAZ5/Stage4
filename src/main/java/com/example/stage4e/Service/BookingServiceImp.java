package com.example.stage4e.Service;

import com.example.stage4e.Entities.*;
import com.example.stage4e.Interfaces.BookingServiceInterface;
import com.example.stage4e.Repository.BookingRepository;
import com.example.stage4e.Repository.CampingPlaceRepository;
import com.example.stage4e.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingServiceImp implements BookingServiceInterface {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CampingPlaceRepository campingPlaceRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public String AddBooking(Booking booking, Integer userId, Integer campingPlaceId){
        CampingPlace cmp=campingPlaceRepository.findById(campingPlaceId).get();
        User user = userRepository.findById(userId).get();
        booking.setBookedBy(user);
        booking.setBookedIn(cmp);
        booking.setBookerPhone(user.getTelephone());
        Integer x =cmp.getPlaceDispo();
        System.out.println(x);
        if (booking.getPlaces()<=x)
        {

            bookingRepository.save(booking);
            cmp.setPlaceDispo(x-booking.getPlaces());
            campingPlaceRepository.save(cmp);

            return "Booking added successfuly";

        }

        else {

            NearestCheckOut();
            return "There is no more places to be booked in " +cmp.getName() + " But you can Book after " + NearestCheckOut();

        }


    }

    public Date NearestCheckOut(){
        List<Booking> list = bookingRepository.findAll();
        Comparator<Booking> comparateurParEndDate = Comparator.comparing(Booking::getEndDate);
        Collections.sort(list, comparateurParEndDate);
        for (Booking booking : list) {
            System.out.println(booking.getEndDate());
        }
        Booking bk= new Booking();
        bk=list.get(0);
        Date date =bk.getEndDate();




        return date ;
    }


    public List<Booking> getAllBooking() {return bookingRepository.findAll();}


}
