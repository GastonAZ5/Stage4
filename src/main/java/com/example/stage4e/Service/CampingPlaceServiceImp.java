package com.example.stage4e.Service;

import com.example.stage4e.Entities.CampingPlace;
import com.example.stage4e.Entities.Role;
import com.example.stage4e.Entities.User;
import com.example.stage4e.Interfaces.CampingPlaceServiceInterface;
import com.example.stage4e.Repository.CampingPlaceRepository;
import com.example.stage4e.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampingPlaceServiceImp implements CampingPlaceServiceInterface {

    @Autowired
    CampingPlaceRepository campingPlaceRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public String AddCampingPlace(CampingPlace campingPlace, Integer idUser){
        User user = userRepository.findById(idUser).get();
        System.out.println(user.getRole());
        String x = user.getRole().toString();
        if (x.equals("ADMIN"))
        {
            campingPlace.setCreatedBy(user);
            campingPlaceRepository.save(campingPlace);
            return "CampingPlace added Successfuly";


        }
        else
        {
            return "Only ADMINS can Add CampingPlaces ";
        }
    }

}
