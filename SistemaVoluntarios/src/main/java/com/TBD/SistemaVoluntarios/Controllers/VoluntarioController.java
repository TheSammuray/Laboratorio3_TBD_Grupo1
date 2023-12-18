package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @GetMapping
    public List<VoluntarioEntity> obtenerTodosLosVoluntarios() {
        return voluntarioRepository.findAll();
    }

    @PostMapping
    public VoluntarioEntity crearVoluntario(@RequestBody VoluntarioEntity producto) {
        return voluntarioRepository.save(producto);
    }
}
