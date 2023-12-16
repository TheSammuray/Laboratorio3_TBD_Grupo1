package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class EstadoTareaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_ESTADO;
    private String descripcion;
}
