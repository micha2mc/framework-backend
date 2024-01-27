package com.zakado.zkd.dao.repository;


import com.zakado.zkd.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByDescriptionContainingIgnoreCase(String genre);
}
