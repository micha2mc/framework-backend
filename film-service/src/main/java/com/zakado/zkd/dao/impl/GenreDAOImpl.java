package com.zakado.zkd.dao.impl;


import com.zakado.zkd.dao.GenreDAO;
import com.zakado.zkd.dao.repository.GenreRepository;
import com.zakado.zkd.model.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreDAOImpl implements GenreDAO {
    private final GenreRepository genreRepository;

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre searchGenreById(Integer id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genre> searchMoviesByGenre(String genre) {
        return genreRepository.findByDescriptionContainingIgnoreCase(genre);
    }

    @Override
    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}
