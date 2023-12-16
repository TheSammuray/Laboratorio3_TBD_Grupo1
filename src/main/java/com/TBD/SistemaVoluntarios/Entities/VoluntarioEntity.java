package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class VoluntarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_VOLUNTARIO;

    @Column(name="ID_USUARIO")
    private Integer ID_USUARIO;
    private String nombre;

    //Cuidar formato WGS84, el cual establece
    //que las coordenadas son angulares.
    private Float latitud;
    private Float longitud;


}
