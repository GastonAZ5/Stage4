package com.example.stage4e.Entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComment")
    private Integer idComment; // Clé primaire
    private String content;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date datePublication;
    private Integer nbrLike;

    @JsonIgnore

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<React> reacts;

    @JsonIgnore
    @ManyToOne
    User CommentPar;
        }
