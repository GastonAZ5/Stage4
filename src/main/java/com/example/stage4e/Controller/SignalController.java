package com.example.stage4e.Controller;

import com.example.stage4e.Entities.SignalPost;
import com.example.stage4e.Service.SignalPostServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signal")
public class SignalController {
    @Autowired
    SignalPostServiceImp signalService;
    @PostMapping("/addSignal/{idUser}/{idPost}")
    public String AddSignal (@PathVariable Integer idUser , @PathVariable Integer idPost){
        return signalService.AddSignalToPost(new SignalPost() , idUser , idPost);
    }
//
//    @GetMapping(path = "/signalPost/confirm")
//    public String SignalPost() {return signalService.ConfirmingSignal();}
}
