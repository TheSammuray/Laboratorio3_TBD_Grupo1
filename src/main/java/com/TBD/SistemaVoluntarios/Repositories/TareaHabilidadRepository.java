package com.TBD.SistemaVoluntarios.Repositories;


import com.TBD.SistemaVoluntarios.Entities.TareaHabilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface TareaHabilidadRepository{
    //CREATE: Crear una nueva conexion
    void createTareaHabilidad(TareaHabilidadEntity tareaHabilidad);

    List<TareaHabilidadEntity> findAll();

    //READ: Buscar a una conexion a partir de su ID
    TareaHabilidadEntity findByID_TARHAB(Integer id);

    // UPDATE: Actualizar descripcion para estado
    void update(Integer id, Integer nuevaHab);

    // DELETE: elimina una conexion por ID
    void deleteById(Integer id);
}
