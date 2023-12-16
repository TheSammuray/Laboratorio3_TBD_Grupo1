package com.TBD.SistemaVoluntarios.Repositories;



import com.TBD.SistemaVoluntarios.Entities.VolHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface VolHabilidadRepository{
    //CREATE: Crear un nuevo intermedio
    void createVolHab(Integer idVol, Integer idHab);

    List<VolHabilidadEntity> findAll();

    //READ: Buscar una relacion a partir de el id de voluntario
    VolHabilidadEntity findByID_VOLUNTARIO(Integer id);

    //READ: Buscar una relacion a partir de el id de habilidad
    VolHabilidadEntity findByID_HABILIDAD(Integer id);

    //UPDATE: Actualiza el id de voluntario
    void updateID_VOLUNTARIO(Integer id, Integer nuevoIdVol);

    //UPDATE: Actualiza el id de habilidad
    void updateID_HABILIDAD(Integer id, Integer nuevoIDHab);

    // DELETE: elimina un ranking por ID
    void deleteById(Integer id);
}
