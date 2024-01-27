package com.zakado.zkd.dao.repository;


import com.zakado.zkd.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorsRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findByNameContainingIgnoreCase(String name);
}
