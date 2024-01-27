package com.zakado.zkd.dao.impl;


import com.zakado.zkd.dao.ActorsDAO;
import com.zakado.zkd.dao.repository.ActorsRepository;
import com.zakado.zkd.model.Actor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ActorsDAOImpl implements ActorsDAO {
    private final ActorsRepository actorsRepository;


    @Override
    public Actor updateActor(Actor actor) {
        return actorsRepository.save(actor);
    }

    @Override
    public Actor saveActor(Actor actor) {
        return actorsRepository.save(actor);
    }

    @Override
    public Actor searchActorById(Integer id) {
        return actorsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Actor> searchAllActors() {
        return actorsRepository.findAll();
    }

    @Override
    public List<Actor> searchMoviesByNameActor(String name) {
        return actorsRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void deleteActor(Actor actor) {
        actorsRepository.delete(actor);
    }
}
