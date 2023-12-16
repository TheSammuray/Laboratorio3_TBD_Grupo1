package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.TareaHabilidadEntity;
import com.TBD.SistemaVoluntarios.Entities.VolHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.VolHabilidadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/volHabilidad")
public class VolHabilidadController {
    private final VolHabilidadRepository volHabilidadRepository;

    public VolHabilidadController(VolHabilidadRepository volHabilidadRepository) {
        this.volHabilidadRepository = volHabilidadRepository;
    }


    // CREATE: crear una nueva relacion voluntario-habilidad.
    @PostMapping("/nueva-vol-habilidad")
    public ResponseEntity<String> crearVolHabilidad(@RequestParam Integer idVol, @RequestParam Integer idHab)
    {
        volHabilidadRepository.createVolHab(idVol, idHab);
        return ResponseEntity.ok("Relacion voluntario-habilidad creada con exito");
    }

    // READ: Listar todas las relaciones
    @GetMapping("/lista-volHabilidad")
    public ResponseEntity<List<VolHabilidadEntity>> listar()
    {
        return ResponseEntity.ok(volHabilidadRepository.findAll());
    }

    // UPDATE: Actualiza la habilidad de la relacion
    @PostMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id,
                                         @RequestParam("Hab") String Hab)
    {
        Integer id_hab = Integer.parseInt(Hab);
        volHabilidadRepository.updateID_HABILIDAD(id, id_hab);
        return ResponseEntity.ok("Habilidad actualizada con exito");
    }

    // DELETE: Elimina una relacion
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id)
    {
        volHabilidadRepository.deleteById(id);
        return ResponseEntity.ok("Relacion voluntario-habilidad eliminada exitosamente");
    }


}
