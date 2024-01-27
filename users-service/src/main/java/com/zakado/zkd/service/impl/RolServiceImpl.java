package com.zakado.zkd.service.impl;

import com.zakado.zkd.dao.RolDAO;
import com.zakado.zkd.model.Rol;
import com.zakado.zkd.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolDAO rolDAO;
    @Override
    public List<Rol> buscarTodos() {
        return rolDAO.buscarTodos();
    }

    @Override
    public Rol buscarRolPorId(Integer idRol) {
        return rolDAO.buscarRolPorId(idRol);
    }

    @Override
    public void guardarRol(Rol rol) {
        rolDAO.guardarRol(rol);
    }

    @Override
    public void eliminarRol(Integer idRol) {
        rolDAO.eliminarRol(idRol);
    }
}
