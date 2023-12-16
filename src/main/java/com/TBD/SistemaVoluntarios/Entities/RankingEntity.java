package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class RankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID_RANKING;
    Integer ID_VOLUNTARIO;
    Integer ID_TAREA;
    Integer puntaje;
    Integer flg_invitado;
    Integer flg_participa;
}
