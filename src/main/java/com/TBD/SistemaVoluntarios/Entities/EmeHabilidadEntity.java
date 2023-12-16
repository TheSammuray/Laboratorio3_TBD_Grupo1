package com.TBD.SistemaVoluntarios.Entities;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class EmeHabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID_EME_HAB;
    Integer ID_EMERGENCA;
    Integer ID_HABILIDAD;
}
