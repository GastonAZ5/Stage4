package com.example.stage4e.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String reference;
    private String name;
    private String description;
    private Integer quantity;
    private String brand;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Float price;
    private Integer discount;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date productionDate;
    private String warranty;
    private Double rating= (double) 0;

    @ManyToMany(mappedBy="products", cascade = CascadeType.ALL)
    private List<Store> stores;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    public Product() {
        this.reference = generateReference();
    }


    private String generateReference() {
        return "REF-" + java.util.UUID.randomUUID();
    }
}
