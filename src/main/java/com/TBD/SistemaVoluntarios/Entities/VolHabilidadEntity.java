package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data

public class VolHabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer ID_VOL_HAB;
    private  Integer ID_VOLUNTARIO;
    private  Integer ID_HABILIDAD;
}
