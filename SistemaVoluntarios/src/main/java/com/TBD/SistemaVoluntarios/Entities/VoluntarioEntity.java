package com.TBD.SistemaVoluntarios.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Voluntarios")
public class VoluntarioEntity {

    @Id
    private String id;
    private String nombre;
    private Float latitud;
    private Float longitud;

    private List<HabilidadEntity> habilidades;

    // Getters y setters

    // Constructor(s)
}
