package com.TBD.SistemaVoluntarios.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "Producto")
public class Producto {

    @Id
    private String id;
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("precio")
    private double precio;


    // Getters y setters
}