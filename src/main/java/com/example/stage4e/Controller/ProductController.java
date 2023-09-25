package com.example.stage4e.Controller;

import com.example.stage4e.Entities.Product;
import com.example.stage4e.Service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServiceImp productServiceImp;

    @PostMapping("/add/{idStore}")
    public ResponseEntity<?> AddProduct(@RequestBody Product product, @PathVariable Integer idStore){
        return new ResponseEntity<>(productServiceImp.AddProduct(product,idStore), HttpStatus.valueOf(200));
    }


    @GetMapping("/topRated")
    public Product getTopRatedProduct() {
        return productServiceImp.TopRatedProduct();
    }

    @GetMapping("/LowRated")
    public Product getMinimumRatedProduct() {
        return productServiceImp.findMinimumRatedProduct();
    }

}
