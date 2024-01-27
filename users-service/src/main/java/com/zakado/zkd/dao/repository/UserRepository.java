package com.zakado.zkd.dao.repository;


import com.zakado.zkd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    List<User> findByUsernameContainingIgnoreCase(String username);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
