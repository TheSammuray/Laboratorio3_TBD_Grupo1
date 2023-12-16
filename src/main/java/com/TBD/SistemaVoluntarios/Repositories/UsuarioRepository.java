package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface UsuarioRepository{
    List<UsuarioEntity> findAll();
    List<UsuarioEntity> findAllByRol(String rol);
    UsuarioEntity findByID_USUARIO(Integer id);
    UsuarioEntity findByEmail(String email);
    void createUsuario(UsuarioEntity usuario);

    //UPDATE: Actualiza el Password de un usuario
    void updatePass(Integer id, String nuevoPass);

    void deleteById(Integer Id);
    void updateEmail(Integer id, String email);
}
