package com.TBD.SistemaVoluntarios.Services;

// imports...

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    // Otros métodos del servicio...

    public double obtenerPromedioHabilidades() {
        List<VoluntarioEntity> voluntarios = voluntarioRepository.findAll();

        if (voluntarios.isEmpty()) {
            return 0.0;
        }

        int totalHabilidades = 0;
        for (VoluntarioEntity voluntario : voluntarios) {
            totalHabilidades += voluntario.getCantidadHabilidades();
        }

        return (double) totalHabilidades / voluntarios.size();
    }
}
