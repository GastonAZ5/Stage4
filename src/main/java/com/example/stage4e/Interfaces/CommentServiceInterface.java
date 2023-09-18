package com.example.stage4e.Interfaces;

import com.example.stage4e.Entities.Comment;
import com.example.stage4e.Entities.Post;

import java.util.List;

public interface CommentServiceInterface {
    public String addComment(Comment comment , Integer IdUser , Integer idPost);

    public String deleteComment(Integer idComment);

    public String updateComment(Comment comment,Integer idComment,Integer idUser);


    public List<Comment> getAllComment();
}
