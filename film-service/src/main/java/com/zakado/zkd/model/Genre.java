package com.zakado.zkd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genres", schema = "moviesactorsdb")
@Builder
public class Genre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nid")
    private Integer nid;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "genres")
    @JsonIgnoreProperties("genres")
    private Set<Movie> moviesEntities = new HashSet<>();
}
