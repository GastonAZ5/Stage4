package com.example.stage4e.Service;

import com.example.stage4e.Entities.Store;
import com.example.stage4e.Entities.User;
import com.example.stage4e.Interfaces.StoreServiceInterface;
import com.example.stage4e.Repository.StoreRepository;
import com.example.stage4e.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class StoreServiceImp implements StoreServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StoreRepository storeRepository;

    public String AddStore(Store store, Integer idUser){

        User user = userRepository.findById(idUser).get();
        store.setOpenedBy(user);
        storeRepository.save(store);
        return "Store Created succesfuly";
    }


    //suppresion edit + affichage

}
