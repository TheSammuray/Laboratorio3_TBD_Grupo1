package com.TBD.SistemaVoluntarios.Repository;

import com.TBD.SistemaVoluntarios.Entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    // Puedes añadir consultas personalizadas aquí si es necesario
}
