package com.example.stage4e.Service;

import com.example.stage4e.Entities.Category;
import com.example.stage4e.Entities.Product;
import com.example.stage4e.Entities.Rating;
import com.example.stage4e.Entities.Store;
import com.example.stage4e.Interfaces.ProductServiceInterface;
import com.example.stage4e.Repository.ProductRepository;
import com.example.stage4e.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ProductServiceImp implements ProductServiceInterface {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    ProductRepository productRepository;

    public String AddProduct(Product product, Integer idStore) {
        Store store = storeRepository.findById(idStore).get();
        //store.setProducts((List<Product>) product);
        productRepository.save(product);

        return "Product added successfully ";
    }

    public Product TopRatedProduct() {
        List<Product> list = productRepository.findAll();

        Product topRatedProduct = null;
        double maxAverageRating = Double.NEGATIVE_INFINITY;

        for (Product product : list) {
            double averageRating = calculateAverageRating(product.getRatings());
            if (averageRating > maxAverageRating) {
                maxAverageRating = averageRating;
                topRatedProduct = product;
            }
        }
        return topRatedProduct;

    }



        private double calculateAverageRating(List<Rating> ratings) {
            if (ratings.isEmpty()) {
                return 0.0;
            }

            double sum = 0.0;
            for (Rating rating : ratings) {
                sum += rating.getScore();
            }

            return sum / ratings.size();
        }


    public Product findMinimumRatedProduct() {
        List<Product> allProducts = productRepository.findAll();

        Product minimumRatedProduct = null;
        double minAverageRating = Double.POSITIVE_INFINITY;

        for (Product product : allProducts) {
            double averageRating = calculateAverageRating(product.getRatings());
            if (averageRating < minAverageRating) {
                minAverageRating = averageRating;
                minimumRatedProduct = product;
            }
        }

        return minimumRatedProduct;
    }



    }






