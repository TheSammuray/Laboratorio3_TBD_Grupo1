package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class EmergenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_EMERGENCIA;
    private String nombre;
    private String descrip;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Integer ID_INSTITUCION;
    private Float latitud_emer;
    private Float longitud_emer;
    private String estado;
}
