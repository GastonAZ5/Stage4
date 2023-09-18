package com.example.stage4e.Controller;
import com.example.stage4e.Entities.React;
import com.example.stage4e.Entities.ReactEnum;
import com.example.stage4e.Service.ReactServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/react")
public class ReactController {


    @Autowired
    ReactServiceImp reactService;

    @PostMapping("/addReact/{IdUser}/{IdPost}/{react}")
    public React AddReact (@PathVariable String react , @PathVariable Integer IdUser , @PathVariable Integer IdPost)
    {
        React a = new React();
        a.setReactEnum(ReactEnum.valueOf(react));
        return reactService.addReact(a,IdUser,IdPost);

    }

    @PutMapping("/updateReact/{Idreact}")
    public React updatereact(@RequestBody React r , @PathVariable Integer Idreact)
    {return reactService.updateReact(r , Idreact);}

    @DeleteMapping("/deleteReact/{Idreact}")
    public ResponseEntity<?> deleteReact(@PathVariable Integer Idreact)
    {
        return new ResponseEntity<>(reactService.DeleteReact(Idreact), HttpStatus.valueOf(200));

    }

@GetMapping("/getPostReact/{idPost}")
    public List<React>getPostReact(@PathVariable Integer idPost){return reactService.getPostReacts(idPost);}
}
