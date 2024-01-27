package com.zakado.zkd.service.impl;

import com.zakado.zkd.dao.ReviewsDAO;
import com.zakado.zkd.model.Reviews;
import com.zakado.zkd.service.CriticasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CriticasServiceImpl implements CriticasService {

    private final ReviewsDAO reviewsDAO;
    @Override
    public List<Reviews> buscarTodas() {
        return reviewsDAO.buscarTodas();
    }

    @Override
    public List<Reviews> buscarCriticasPorIdPelicula(Integer idPel) {
        return reviewsDAO.buscarCriticasPorIdPelicula(idPel);
    }

    @Override
    public Reviews buscarCriticasPorId(Integer idCrit) {
        return reviewsDAO.buscarCriticaPorId(idCrit);
    }

    @Override
    public Reviews guardarCritica(Reviews critica) {
        return reviewsDAO.guardarCritica(critica);
    }

    @Override
    public void actualizarCritica(Reviews reviews) {
        reviewsDAO.guardarCritica(reviews);
    }

    @Override
    public void eliminarCritica(Integer id) {
        reviewsDAO.eliminarCritica(id);
    }
}
