package com.example.stage4e.Controller;

import com.example.stage4e.Entities.Post;
import com.example.stage4e.Service.PostServiceImp;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostServiceImp postServiceImp;

    @PostMapping("/addPost/{IdUser}")
    public ResponseEntity<?> addPublication(@RequestBody Post post , @PathVariable Integer IdUser) {
        return new ResponseEntity<>(postServiceImp.addPost(IdUser, post), HttpStatus.valueOf(200));
    }

    @PostMapping("/updatePost/{idPost}/{idUser}")
    public ResponseEntity<?> updatePost(@RequestBody Post post,@PathVariable Integer idPost,@PathVariable Integer idUser) {
        return new ResponseEntity<>(postServiceImp.updatePost(post,idPost,idUser), HttpStatus.valueOf(200));
    }

    @DeleteMapping("/delete/{idPost}")
    public ResponseEntity<?> deletePost(@PathVariable Integer idPost){
        return new ResponseEntity<>(postServiceImp.deletePost(idPost),HttpStatus.valueOf(200));
    }


    @GetMapping("/getAllPosts")
    public List<Post> getAllPosts() {
        return postServiceImp.getAllPost();
    }

}
