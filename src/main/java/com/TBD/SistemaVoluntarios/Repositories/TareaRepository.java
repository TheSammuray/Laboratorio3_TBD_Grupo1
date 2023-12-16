package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface TareaRepository{
    //CREATE: Crear una nueva tarea
    void createTarea(TareaEntity tarea);

    List<TareaEntity> findAll();

    //READ: Buscar a una tarea a partir de su ID
    TareaEntity findByID_TAREA(Integer id);

    //UPDATE: Actualiza la descripción de una tarea
    void updateDescrip(Integer id, String nuevaDescrip);

    //UPDATE: Actualiza el estado de una tarea
    void updateEstado(Integer id, Integer nuevoEstado);

    // DELETE: elimina una emergencia por ID
    void deleteById(Integer id);
}
