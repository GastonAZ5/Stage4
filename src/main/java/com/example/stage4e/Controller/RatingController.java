package com.example.stage4e.Controller;


import com.example.stage4e.Entities.Rating;
import com.example.stage4e.Service.RatingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingServiceImp ratingServiceImp;

    @PostMapping("/add/{idUser}/{idProduct}")
    public ResponseEntity<?>AddRating(@RequestBody Rating rating, @PathVariable Integer idUser, @PathVariable Integer idProduct){
        return new ResponseEntity<>(ratingServiceImp.AddRating(rating,idUser,idProduct), HttpStatus.valueOf(200));
    }

    @GetMapping("/getAllByIdProduct/{id}")
    public ResponseEntity<?> getRatingsByProductId(@PathVariable Integer id) {
        List<Rating> ratings = ratingServiceImp.getRatingsByProductId(id);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/getAllByIdUser/{id}")
    public ResponseEntity<?> getRatingsByUserId(@PathVariable Integer id) {
        List<Rating> ratings = ratingServiceImp.getRatingsByIdUser(id);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/getScore/{id}")
    public Double getScore (@PathVariable Integer id){
        return ratingServiceImp.CalculeScoreProduct(id);
    }

    @GetMapping("/getStatrate")
    public String getScore (){
        return ratingServiceImp.Stat();
    }

}
