package com.example.stage4e.Service;

import com.example.stage4e.Entities.Post;
import com.example.stage4e.Entities.User;
import com.example.stage4e.Interfaces.PostServiceInterface;
import com.example.stage4e.Repository.PostRepository;
import com.example.stage4e.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public String addPost(Integer idUser, Post post){
        User user = userRepository.findById(idUser).orElseThrow(null);
        post.setPublierPar(user);
        BadWordServiceImp badWordServiceImp = new BadWordServiceImp();
        if(badWordServiceImp.filterText(post.getContenu()).equals("This post contain bad word"))
            return "This post contains bad word";
        else {
        postRepository.save(post);
        return "Post added succesfsuly";
        }
    }

    @Override
    public String deletePost(Integer idPost){
        postRepository.deleteById(idPost);
        return ("Post deleted succefully ");
    }





    @Override
    public String updatePost(Post post,Integer idPost,Integer idUser) {



        Post p = postRepository.findById(idPost).get();
        post.setIdPost(p.getIdPost());
        User user = userRepository.findById(idUser).get();
        post.setPublierPar(user);

        BadWordServiceImp badWordServiceImp = new BadWordServiceImp();
        if (badWordServiceImp.filterText(post.getContenu()).equals("This post contain bad word"))
            return "This post contains bad word";
        else {
            postRepository.saveAndFlush(post);
            return "Post updated succesfsuly";
        }

    }

    @Override
    public List<Post> getAllPost(){return postRepository.findAll();}




}
