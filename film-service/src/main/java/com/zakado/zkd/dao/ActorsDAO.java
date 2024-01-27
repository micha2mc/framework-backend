package com.zakado.zkd.dao;



import com.zakado.zkd.model.Actor;

import java.util.List;

public interface ActorsDAO {

    Actor updateActor(Actor actor);

    Actor saveActor(Actor actor);

    Actor searchActorById(Integer id);

    List<Actor> searchAllActors();

    List<Actor> searchMoviesByNameActor(String name);

    void deleteActor(Actor actor);
}
