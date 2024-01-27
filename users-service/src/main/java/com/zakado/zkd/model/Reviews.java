package com.zakado.zkd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reviews", schema = "usersdb")
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid", nullable = false)
    private Integer id;
    private Integer idMovie;
    private String assessment;
    private Integer note;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "nid")
    @JsonIgnoreProperties("reviews")
    private User user;

}