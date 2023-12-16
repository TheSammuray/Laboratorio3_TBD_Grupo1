package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data

public class InstitucionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer ID_INSTITUCION;
    private String nombre;
    private  String descrip;
}
