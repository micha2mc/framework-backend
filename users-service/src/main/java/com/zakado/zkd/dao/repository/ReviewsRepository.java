package com.zakado.zkd.dao.repository;


import com.zakado.zkd.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findByIdMovie(int id);
}
