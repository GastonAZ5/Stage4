package com.example.stage4e.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStore;
    private String name ;
    private String location;
    private String storePhone;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String storeEmail;

    @ManyToOne
    private User openedBy;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;

}
