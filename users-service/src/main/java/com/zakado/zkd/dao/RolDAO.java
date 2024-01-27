package com.zakado.zkd.dao;


import com.zakado.zkd.model.Rol;

import java.util.List;

public interface RolDAO {
    List<Rol> buscarTodos();

    Rol buscarRolPorId(Integer idRol);

    void guardarRol(Rol rol);

    void eliminarRol(Integer idRol);
}
