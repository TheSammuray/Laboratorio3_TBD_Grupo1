package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class TareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_TAREA;
    private String nombre;
    private String descrip;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Integer cant_vol_requeridos;
    private Integer cant_vol_inscritos;
    private Integer ID_EMERGENCIA;
    private Integer ID_ESTADO;
}
