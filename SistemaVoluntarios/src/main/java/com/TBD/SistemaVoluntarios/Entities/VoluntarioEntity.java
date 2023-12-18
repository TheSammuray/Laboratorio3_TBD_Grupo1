package com.TBD.SistemaVoluntarios.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Voluntarios")
public class VoluntarioEntity {

    @Id
    private String id;
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("latitud")
    private Float latitud;
    @JsonProperty("longitud")
    private Float longitud;
    @JsonProperty("habilidades")
    private List<HabilidadEntity> habilidades;

    // Otros atributos...

    // Getters y setters

    public int getCantidadHabilidades() {
        return habilidades != null ? habilidades.size() : 0;
    }

    @Override
    public String toString() {
        return "VoluntarioEntity{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", habilidades=" + habilidades +
                '}';
    }
}
