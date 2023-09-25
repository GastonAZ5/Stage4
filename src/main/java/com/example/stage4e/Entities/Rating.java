package com.example.stage4e.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRating;

    private Double score;
    @JsonIgnore

    @ManyToOne
    private Product product;
    @JsonIgnore

    @ManyToOne
    private User user;
}
