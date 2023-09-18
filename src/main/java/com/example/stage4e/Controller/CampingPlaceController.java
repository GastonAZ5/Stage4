package com.example.stage4e.Controller;


import com.example.stage4e.Entities.CampingPlace;
import com.example.stage4e.Interfaces.CampingPlaceServiceInterface;
import com.example.stage4e.Service.CampingPlaceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campingPlace")
public class CampingPlaceController {
    @Autowired
    CampingPlaceServiceImp campingPlaceServiceImp;

    @PostMapping("/add/{idUser}")
    public ResponseEntity AddCampingPlace(@RequestBody CampingPlace campingPlace , @PathVariable Integer idUser ){
        return new ResponseEntity<>(campingPlaceServiceImp.AddCampingPlace(campingPlace,idUser), HttpStatus.valueOf(200));
    }
}
