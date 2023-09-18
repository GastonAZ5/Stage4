package com.example.stage4e.Service;

import com.example.stage4e.Entities.Comment;
import com.example.stage4e.Entities.Post;
import com.example.stage4e.Entities.User;
import com.example.stage4e.Interfaces.CommentServiceInterface;
import com.example.stage4e.Repository.CommentRepository;
import com.example.stage4e.Repository.PostRepository;
import com.example.stage4e.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImp implements CommentServiceInterface {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository publicationRepository;

    @Autowired
    UserRepository userRepository;




    @Override
    public String addComment(Comment comment , Integer IdUser , Integer idPost) {
        Post p = publicationRepository.findById(idPost).orElse(null);
        User usr = userRepository.findById(IdUser).orElseThrow(null);
        comment.setCommentPar(usr);
        List<Comment> ll = new ArrayList<>();
        ll = p.getListOfComments();
        ll.add(comment);
        p.setListOfComments(ll);

        BadWordServiceImp badWord=new BadWordServiceImp();
        if(  badWord.filterText(comment.getContent()).equals("This post contain bad word"))
            return "This comment contains bad word";
        else {
            commentRepository.save(comment);
            publicationRepository.save(p);
            return "Comment added successfuly";
        }
    }

    @Override
    public String deleteComment(Integer idComment){
        commentRepository.deleteById(idComment);
        return ("Comment deleted succefully ");
    }





    @Override
    public String updateComment(Comment comment,Integer idComment,Integer idUser) {
        Comment com = commentRepository.findById(idComment).get();
        comment.setIdComment(com.getIdComment());
        User user = userRepository.findById(idUser).get();
        comment.setCommentPar(user);

        BadWordServiceImp badWordServiceImp = new BadWordServiceImp();
        if (badWordServiceImp.filterText(comment.getContent()).equals("This post contain bad word"))
            return "This comment contains bad word";
        else {
            commentRepository.saveAndFlush(comment);
            return "Comment updated succesfsuly";
        }

    }

    @Override
    public List<Comment> getAllComment(){return commentRepository.findAll();}


}
