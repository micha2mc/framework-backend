package com.zakado.zkd.controller;


import com.zakado.zkd.model.User;
import com.zakado.zkd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> buscarTodos() {
        return userService.buscarTodos();
    }

    @GetMapping("/{id}")
    public User buscarUsuarioPorId(@PathVariable("id") Integer id) {
        return userService.buscarUsuarioPorId(id);
    }

    @GetMapping("/correo/{correo}")
    public User buscarUsuarioPorCorreo(@PathVariable("correo") String correo) {
        return userService.buscarUsuarioPorCorreo(correo);
    }

    @GetMapping("/nombre/{nombre}")
    public User buscarUsuarioPorNombre(@PathVariable("nombre") String nombre) {
        return userService.buscarUsuarioPorNombre(nombre);
    }
    @GetMapping("/search/{nombre}")
    public List<User> buscarVariosPorNombre(@PathVariable("nombre") String nombre) {
        return userService.buscarVariosPorNombre(nombre);
    }

    @GetMapping("/login/{correo}/{clave}")
    public User buscarUsuarioPorCorreoConClave(@PathVariable("correo") String correo, @PathVariable("clave") String clave) {
        return userService.buscarUsuarioPorCorreoClave(correo, clave);
    }

    @PostMapping
    public void guardarUsuario(@RequestBody User usuario) {
        userService.guardarUsuario(usuario);
    }

    @PutMapping
    public void actualizarUsuario(@RequestBody User usuario) {
        userService.actualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") Integer id) {
        userService.eliminarUsuario(id);
    }
}
