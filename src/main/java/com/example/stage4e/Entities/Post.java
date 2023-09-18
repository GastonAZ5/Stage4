package com.example.stage4e.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table( name = "Post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPost")
    private Integer idPost; // Clé primaire
    private String sujet ;
    private  String contenu;


    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", sujet='" + sujet + '\'' +
                ", contenu='" + contenu + '\'' +
                ", publierPar=" + publierPar +
                //", likerPar=" + likerPar +
                //", listOfComments=" + listOfComments +
                '}';
    }

    @JsonIgnore
    @ManyToOne
    User publierPar;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "post")
    List<SignalPost> signalPosts;

    @OneToMany(cascade = CascadeType.ALL)
    List<Comment> listOfComments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<React> reacts;
}
