package com.zakado.zkd.service;


import com.zakado.zkd.model.Genre;

import java.util.List;

public interface GenreService {
    Genre saveGenre(Genre genre);

    List<Genre> getAllGenres();

    Genre searchGenreById(Integer id);

    void deleteGenre(Integer id);
}
