package com.TBD.SistemaVoluntarios.Repositories;


import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface HabilidadRepository{
    //CREATE: Crear una nueva habilidad
    void createHabilidad(HabilidadEntity habilidad);

    List<HabilidadEntity> findAll();

    //READ: Buscar a una emergencia a partir de su ID
    HabilidadEntity findByID_HABILIDAD(Integer id);

    //UPDATE: Actualiza la descripción de una habilidad
    void updateDescrip(Integer id, String nuevaDescrip);

    // DELETE: elimina una habilidad por ID
    void deleteById(Integer id);
}
