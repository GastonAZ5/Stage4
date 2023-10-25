package com.example.stage4e.Service;

import com.example.stage4e.Entities.Product;
import com.example.stage4e.Entities.Rating;
import com.example.stage4e.Entities.User;
import com.example.stage4e.Interfaces.RatingServiceInterface;
import com.example.stage4e.Repository.ProductRepository;
import com.example.stage4e.Repository.RatingRepository;
import com.example.stage4e.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImp implements RatingServiceInterface {
    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    public String AddRating(Rating rating , Integer idUser, Integer idProduct){

            if(rating.getScore() == 0){
                for (Rating rr : ratingRepository.findAll()
                ) {
                    if(rr.getUser().getUserId() == idUser && idProduct == rr.getProduct().getProductId())
                        ratingRepository.deleteById(rr.getIdRating());
                }
                return "Rating is 0";
            }
            for (Rating rr : ratingRepository.findAll()
            ) {
                if(rr.getUser().getUserId() == idUser && idProduct == rr.getProduct().getProductId())
                    ratingRepository.deleteById(rr.getIdRating());
            }

        User u = userRepository.findById(idUser).orElse(null);
        Product product = productRepository.findById(idProduct).orElse(null);
        rating.setUser(u);
        rating.setProduct(product);
        Double x= product.getRating();
        Integer y= countRatingsByProduct(product)+1;
        product.setRating((rating.getScore()+x)/y);
        ratingRepository.save(rating);
        return "Rating added successfully";
    }


    public List<Rating> getRatingsByProductId(Integer productId) {
        List<Rating> ll = new ArrayList<>();
        for (Rating r : ratingRepository.findAll()  )
        {
            if (r.getProduct().getProductId().equals(productId))
                ll.add(r);
        }
        return  ll;
    }


    public List<Rating> getRatingsByIdUser(Integer idUser) {
        List<Rating> ll = new ArrayList<>();
        for (Rating r : ratingRepository.findAll()  )
        {
            if (r.getUser().getUserId().equals(idUser))
                ll.add(r);
        }
        return  ll;
    }


    public Double CalculeScoreProduct(Integer idProduct){
        double sc = 0;
        double x = 0;
        Product product = productRepository.findById(idProduct).get();


        for (Rating r : getRatingsByProductId(idProduct)){
            sc =  sc + r.getScore();
            x++;

        }
        if(x != 0)
            return (double) sc/x;
        else
            return (double) 0;
    }



    public String Stat()
    {
        int positifrate =0;
        int negativeRate =0;

        for (Rating r : ratingRepository.findAll()
        ) {
            if(r.getScore()<3)
                positifrate++;
            else negativeRate++;


        }
        return ("There is " + positifrate +" positive rates & " + negativeRate + " negative rates");
    }

    public Integer countRatingsByProduct(Product product) {
        return ratingRepository.countRatingsByProduct(product);
    }

    //suppression + edit

}
