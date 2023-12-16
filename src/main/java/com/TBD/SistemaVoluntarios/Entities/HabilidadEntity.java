package com.TBD.SistemaVoluntarios.Entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Data
public class HabilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_HABILIDAD;
    private  String descrip;
}
