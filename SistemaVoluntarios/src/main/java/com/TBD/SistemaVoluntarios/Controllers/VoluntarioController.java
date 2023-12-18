package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import com.TBD.SistemaVoluntarios.Services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

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

    @GetMapping("/promedio-habilidades")
    public ResponseEntity<Double> obtenerPromedioHabilidades() {
        double promedioHabilidades = voluntarioService.obtenerPromedioHabilidades();
        return new ResponseEntity<>(promedioHabilidades, HttpStatus.OK);
    }
}
