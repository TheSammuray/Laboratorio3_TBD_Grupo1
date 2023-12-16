package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoluntarioRepository extends MongoRepository<VoluntarioEntity, String> {

    // CREATE: Agregar un voluntario
    void agregarVoluntario(VoluntarioEntity voluntario, Integer id);

    // Método para buscar por nombre
    VoluntarioEntity findByNombre(String nombre);

    // Método para buscar por ID_VOLUNTARIO
    VoluntarioEntity findByID_VOLUNTARIO(Integer id);

    // Método para eliminar por ID_VOLUNTARIO
    void deleteByID_VOLUNTARIO(Integer id);

    // UPDATE: Actualiza la ubicación de un voluntario.
    void updateUbicacion(Integer id, float nuevaLongitud, float nuevaLatitud);

    // DELETE: elimina un voluntario por ID
    void deleteById(Integer id);
}
