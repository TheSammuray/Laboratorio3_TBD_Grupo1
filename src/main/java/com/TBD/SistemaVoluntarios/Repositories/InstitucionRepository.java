package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.InstitucionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface InstitucionRepository{
    //CREATE: Crear una nueva institucion.
    void createInstitucion(InstitucionEntity institucion);

    List<InstitucionEntity> findAll();

    //READ: Buscar a una institucion a partir de su ID.
    InstitucionEntity findByID_INSTITUCION(Integer id);

    //UPDATE: Actualiza la descripción de una institucion.
    void updateDescrip(Integer id, String nuevaDescrip);

    // DELETE: elimina una institucion por ID.
    void deleteById(Integer id);
}
