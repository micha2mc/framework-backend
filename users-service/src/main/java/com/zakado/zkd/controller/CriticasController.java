package com.zakado.zkd.controller;


import com.zakado.zkd.model.Reviews;
import com.zakado.zkd.service.CriticasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class CriticasController {

    private final CriticasService criticasService;

    @GetMapping
    public List<Reviews> buscarTodas() {
        return criticasService.buscarTodas();
    }

    @GetMapping("/movie/{idPel}")
    public List<Reviews> buscarCriticasPorIdPelicula(@PathVariable("idPel") Integer idPel) {
        return criticasService.buscarCriticasPorIdPelicula(idPel);
    }

    @GetMapping("/{id}")
    public Reviews buscarCriticaPorId(@PathVariable("id") Integer id) {
        return criticasService.buscarCriticasPorId(id);
    }

    @PostMapping
    public ResponseEntity<Reviews> guardarCritica(@RequestBody Reviews critica) {
        Reviews reviews = criticasService.guardarCritica(critica);
        return new ResponseEntity<>(reviews, HttpStatus.CREATED);
    }
    @PutMapping
    public void actualizarCritica(@RequestBody Reviews critica) {
        criticasService.actualizarCritica(critica);
    }

    @DeleteMapping("/{id}")
    public void eliminarCritica(@PathVariable("id") Integer id){
        criticasService.eliminarCritica(id);
    }
}
