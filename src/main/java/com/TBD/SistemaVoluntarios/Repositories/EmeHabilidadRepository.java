package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.EmeHabilidadEntity;
import java.util.List;

public interface EmeHabilidadRepository{

    //CREATE: Crear una nueva conexion
    void createEmeHabilidad(EmeHabilidadEntity emeHabilidad);

    List<EmeHabilidadEntity> findAll();

    //READ: Buscar a una emergencia a partir de su ID
    EmeHabilidadEntity findByID_EME_HAB(Integer id);

    // UPDATE: Actualizar habilidad para emergencia
    void update(Integer id, Integer nuevaHabilidad);

    // DELETE: elimina una emergencia por ID
    void deleteById(Integer id);
}
