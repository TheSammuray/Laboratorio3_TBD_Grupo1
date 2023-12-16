package com.TBD.SistemaVoluntarios.Repositories;


import com.TBD.SistemaVoluntarios.Entities.EstadoTareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface EstadoTareaRepository{
    //CREATE: Crear un nuevo estado
    void createEstadoTarea(EstadoTareaEntity estadoTarea);

    List<EstadoTareaEntity> findAll();

    //READ: Buscar a un estado a partir de su ID
    EstadoTareaEntity findByID_ESTADO(Integer id);

    // UPDATE: Actualizar descripcion para estado
    void update(Integer id, String desc);

    // DELETE: elimina un estado por ID
    void deleteById(Integer id);
}
