package com.example.stage4e.Controller;


import com.example.stage4e.Entities.Comment;
import com.example.stage4e.Entities.Post;
import com.example.stage4e.Repository.CommentRepository;
import com.example.stage4e.Service.CommentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImp commentServiceImp;

    @PostMapping("/addComment/{idUser}/{idPost}")
    public ResponseEntity<?> addComment(@RequestBody Comment comment, @PathVariable Integer idUser, @PathVariable Integer idPost){
        return new  ResponseEntity<>(commentServiceImp.addComment(comment,idUser,idPost), HttpStatus.valueOf(200)) ;
    }
    @PostMapping("/updateComment/{idComment}/{idUser}")
    public ResponseEntity<?> updateComment(@RequestBody Comment comment ,@PathVariable Integer idComment, @PathVariable Integer idUser) {
        return new ResponseEntity<>(commentServiceImp.updateComment(comment, idComment,idUser), HttpStatus.valueOf(200));
    }


    @DeleteMapping("/delete/{idComment}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer idComment){
        return new ResponseEntity<>(commentServiceImp.deleteComment(idComment),HttpStatus.valueOf(200));
    }


    @GetMapping("/getAllComment")
    public List<Comment> getAllComments() {
        return commentServiceImp.getAllComment();
    }

}


