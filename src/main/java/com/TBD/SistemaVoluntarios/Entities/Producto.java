package com.TBD.SistemaVoluntarios.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class Producto {

    @Id
    private String id;
    private String nombre;
    private double precio;

    // Getters y setters

    // Constructor(s)
}
