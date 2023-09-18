package com.example.stage4e.Service;

import com.example.stage4e.Entities.Post;
import com.example.stage4e.Entities.React;
import com.example.stage4e.Entities.User;
import com.example.stage4e.Interfaces.ReactServiceInterface;
import com.example.stage4e.Repository.CommentRepository;
import com.example.stage4e.Repository.PostRepository;
import com.example.stage4e.Repository.ReactRepository;
import com.example.stage4e.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactServiceImp implements ReactServiceInterface {

    @Autowired
    ReactRepository reactrepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    public React addReact(React react, Integer idUsr , Integer idPost ) {
        for (React r : reactrepository.findAll()
        ) {
            if (r.getUser().getUserId() == idUsr && r.getPost().getIdPost() == idPost) {
                reactrepository.deleteById(r.getIdReact());
            }
        }

        User u = userRepository.findById(idUsr).orElse(null);
        Post pub= postRepository.getById(idPost);
        react.setUser(u);
        react.setPost(pub);
        reactrepository.save(react);
        return react;
    }

    public String DeleteReact (Integer idReact)
    {
        reactrepository.deleteById(idReact);
        return "React deleted successfuly";
    }

    public React updateReact(React react , Integer Idreact)
    {
        React r = reactrepository.findById(Idreact).get();
        r.setReactEnum(react.getReactEnum());
        return reactrepository.save(r);
    }

    public List<React> getPostReacts (Integer idPost)
    {
        Post pub = postRepository.findById(idPost).orElse(null);
        return pub.getReacts();
    }


}
