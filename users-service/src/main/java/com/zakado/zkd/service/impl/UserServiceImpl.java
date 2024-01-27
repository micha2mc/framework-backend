package com.zakado.zkd.service.impl;

import com.zakado.zkd.dao.ReviewsDAO;
import com.zakado.zkd.dao.UserDAO;
import com.zakado.zkd.model.Reviews;
import com.zakado.zkd.model.Rol;
import com.zakado.zkd.model.User;
import com.zakado.zkd.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final ReviewsDAO reviewsDAO;

    @Override
    public List<User> buscarTodos() {
        return userDAO.buscarTodos();
    }

    @Override
    public User buscarUsuarioPorId(Integer idUsuario) {
        return userDAO.buscarUsuarioPorId(idUsuario);
    }

    @Override
    public User buscarUsuarioPorNombre(String nombre) {
        return userDAO.buscarUsuarioPorNombre(nombre);
    }

    @Override
    public List<User> buscarVariosPorNombre(String nombre) {
        return userDAO.buscarVariosPorNombre(nombre);
    }

    @Override
    public User buscarUsuarioPorCorreo(String correo) {
        return userDAO.buscarUsuarioPorCorreo(correo);
    }

    @Override
    public void guardarUsuario(User usuario) {
        userDAO.guardarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        userDAO.eliminarUsuario(idUsuario);
    }

    @Override
    public void actualizarUsuario(User usuario) {
        User user = userDAO.buscarUsuarioPorId(usuario.getId());
        if (Objects.nonNull(user)) {
            userDAO.guardarUsuario(getDataToUpdateUser(usuario, user));
            log.info("Actualizada la película con ID {}", user.getId());
        } else {
            throw new RuntimeException("No existe usuario para actualizar");
        }
    }

    @Override
    public void eliminarCritica(Integer idUsuario, Integer idCrit) {
        User user = userDAO.buscarUsuarioPorId(idUsuario);
        if (Objects.nonNull(user)) {
            user.removeReviews(reviewsDAO.buscarCriticaPorId(idCrit));
        }
        reviewsDAO.eliminarCritica(idCrit);
    }

    @Override
    public User buscarUsuarioPorCorreoClave(String correo, String clave) {
        return userDAO.buscarUsuarioPorCorreoClave(correo, clave);
    }

    private User getDataToUpdateUser(User usuario, User user) {
        user.setUsername(usuario.getUsername());
        user.setPassword(usuario.getPassword());
        user.setEmail(usuario.getEmail());
        user.setEnable(usuario.getEnable());
        setRolesAndReviews(usuario, user);
        return user;
    }

    private void setRolesAndReviews(User usuario, User user) {
        if (Objects.nonNull(usuario.getRoles()) && !usuario.getRoles().isEmpty()) {
            for (Rol rol : usuario.getRoles()) {
                user.addRol(rol);
            }
        }
        if (Objects.nonNull(usuario.getReviews()) && !usuario.getReviews().isEmpty()) {
            for (Reviews reviews : usuario.getReviews()) {
                user.addReviews(reviews);
            }
        }
    }
}
