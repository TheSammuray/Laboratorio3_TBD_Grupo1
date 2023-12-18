package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoluntarioRepository extends MongoRepository<VoluntarioEntity, String> {

    // Puedes añadir consultas personalizadas aquí si es necesario
}
