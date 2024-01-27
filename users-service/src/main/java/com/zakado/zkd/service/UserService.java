package com.zakado.zkd.service;


import com.zakado.zkd.model.User;

import java.util.List;

public interface UserService {
    List<User> buscarTodos();

    User buscarUsuarioPorId(Integer idUsuario);

    User buscarUsuarioPorNombre(String nombre);
    List<User> buscarVariosPorNombre(String nombre);

    User buscarUsuarioPorCorreo(String correo);

    void guardarUsuario(User usuario);

    void eliminarUsuario(Integer idUsuario);

    void actualizarUsuario(User usuario);

    void eliminarCritica(Integer idUsuario, Integer idMatricula);

    User buscarUsuarioPorCorreoClave(String correo, String clave);
}
