package com.example.stage4e.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignalPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSignal;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date DateSignal;
    private Boolean confirmed;


    @ManyToOne
    private Post post;

    @ManyToOne
    private User signalPar;
}
