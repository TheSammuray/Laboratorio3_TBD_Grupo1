package com.TBD.SistemaVoluntarios.Repositories;



import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface EmergenciaRepository{

    void createEmergencia(EmergenciaEntity emergencia);
    List<EmergenciaEntity> findAll();

    //READ: Buscar a una emergencia a partir de su ID
    EmergenciaEntity findByID_EMERGENCIA(Integer id);

    //UPDATE: Actualiza la descripción de una emergencia
    void updateDescrip(Integer id, String nuevaDescrip);

    //UPDATE: Actualiza la institucion de una emergencia
    void updateInstitucion(Integer id, Integer nuevaInstitucion);

    // DELETE: elimina una emergencia por ID
    void deleteById(Integer id);
}
