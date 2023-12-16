package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface VoluntarioRepository {
    //CREATE: Agregar un voluntario
    void agregarVoluntario(VoluntarioEntity voluntario, Integer id);

    List<VoluntarioEntity> findAll();

    VoluntarioEntity findByNombre(String nombre);

    //READ: Buscar a un voluntario a partir de su ID.
    VoluntarioEntity findByID_VOLUNTARIO(Integer id);

    //UPDATE: Actualiza la ubicacion de un voluntario
    void updateUbicacion(Integer id, float nuevaLongitud, float nuevaLatitud);

    // DELETE: elimina un voluntario por ID
    void deleteById(Integer id);
}
