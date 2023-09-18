package com.example.stage4e.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampingPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer campingPlaceId;
    private String name;
    private String description;
    private String location;
    private String email;
    private String telNumber;
    private Integer placeDispo;
    private Float Price;

    @ManyToOne
    User createdBy;


    @OneToMany(cascade= CascadeType.ALL, mappedBy = "bookedIn")
    List<Booking> bookings1;

}
