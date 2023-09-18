package com.example.stage4e.Interfaces;


import com.example.stage4e.Entities.Post;
import com.example.stage4e.Entities.React;

import java.util.List;

public interface PostServiceInterface {
    public String addPost(Integer idUser, Post post);

    public String deletePost(Integer idPost);


    public String updatePost(Post post, Integer idPost,Integer idUser);


    public List<Post> getAllPost();
































}
