package com.zakado.zkd.dao;



import com.zakado.zkd.model.Reviews;

import java.util.List;

public interface ReviewsDAO {
    List<Reviews> buscarTodas();

    List<Reviews> buscarCriticasPorIdPelicula(Integer idMovie);

    Reviews buscarCriticaPorId(Integer idReview);

    Reviews guardarCritica(Reviews critica);

    void eliminarCritica(Integer idCritica);
}
