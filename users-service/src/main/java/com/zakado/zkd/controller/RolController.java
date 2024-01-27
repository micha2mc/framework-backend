package com.zakado.zkd.controller;


import com.zakado.zkd.model.Rol;
import com.zakado.zkd.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;
    @GetMapping
    public ResponseEntity<List<Rol>> searchAllMovies() {
        List<Rol> roles = rolService.buscarTodos();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Rol buscarRolPorId(@PathVariable("id") Integer id) {
        return rolService.buscarRolPorId(id);
    }

    @PostMapping
    public void guardarRol(@RequestBody Rol rol) {
        rolService.guardarRol(rol);
    }
}
