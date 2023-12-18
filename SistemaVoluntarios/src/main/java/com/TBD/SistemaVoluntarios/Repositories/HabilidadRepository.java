package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HabilidadRepository extends MongoRepository<HabilidadEntity, String> {

    // Puedes agregar consultas personalizadas aquí si es necesario
}