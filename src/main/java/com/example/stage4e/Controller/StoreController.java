package com.example.stage4e.Controller;


import com.example.stage4e.Entities.Store;
import com.example.stage4e.Service.StoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreServiceImp storeServiceImp;

    @PostMapping("/add/{idUser}")
    public ResponseEntity<?> AddStore(@RequestBody Store store, @PathVariable Integer idUser){
      return   new ResponseEntity<>(storeServiceImp.AddStore(store,idUser), HttpStatus.valueOf(200));
    }

}
