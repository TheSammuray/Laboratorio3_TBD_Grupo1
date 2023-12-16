package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data

public class TareaHabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_TARHAB;
    private Integer ID_EME_HAB;
    private Integer ID_TAREA;
}
