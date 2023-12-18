package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {

    @Autowired
    private HabilidadRepository habilidadRepository;

    @GetMapping
    public List<HabilidadEntity> obtenerTodasLasHabilidades() {
        return habilidadRepository.findAll();
    }

    @PostMapping
    public HabilidadEntity crearHabilidad(@RequestBody HabilidadEntity habilidad) {
        return habilidadRepository.save(habilidad);
    }

    // Puedes agregar más métodos según tus necesidades
}
