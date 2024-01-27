package com.zakado.zkd.dao.impl;


import com.zakado.zkd.dao.UserDAO;
import com.zakado.zkd.dao.repository.UserRepository;
import com.zakado.zkd.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserDAOImpl implements UserDAO {
    private final UserRepository userRepository;

    @Override
    public List<User> buscarTodos() {
        return userRepository.findAll();
    }

    @Override
    public User buscarUsuarioPorId(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User buscarUsuarioPorNombre(String nombre) {
        return userRepository.findByUsername(nombre);
    }

    @Override
    public List<User> buscarVariosPorNombre(String nombre) {
        return userRepository.findByUsernameContainingIgnoreCase(nombre);
    }

    @Override
    public User buscarUsuarioPorCorreo(String correo) {
        return userRepository.findByEmail(correo);
    }

    @Override
    public void guardarUsuario(User usuario) {
        userRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        userRepository.deleteById(idUsuario);
    }

    @Override
    public void actualizarUsuario(User usuario) {
        userRepository.save(usuario);
    }

    @Override
    public User buscarUsuarioPorCorreoClave(String correo, String clave) {
        return userRepository.findByEmailAndPassword(correo, clave);
    }
}
