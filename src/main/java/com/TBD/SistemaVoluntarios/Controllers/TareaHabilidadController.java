package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmeHabilidadEntity;
import com.TBD.SistemaVoluntarios.Entities.TareaHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.TareaHabilidadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tareaHabilidad")
public class TareaHabilidadController {
    private final TareaHabilidadRepository tareaHabilidadRepository;

    public TareaHabilidadController(TareaHabilidadRepository tareaHabilidadRepository) {
        this.tareaHabilidadRepository = tareaHabilidadRepository;
    }

    // CREATE: crear una nueva relacion.
    @PostMapping("/nueva-tar-habilidad")
    public ResponseEntity<String> crearTareaHabilidad(@RequestBody TareaHabilidadEntity tareaHabilidad)
    {
        tareaHabilidadRepository.createTareaHabilidad(tareaHabilidad);
        return ResponseEntity.ok("Relacion tarea-habilidad creada con exito");
    }

    // READ: Listar todas las relaciones
    @GetMapping("/lista-tarea-habilidad")
    public ResponseEntity<List<TareaHabilidadEntity>> listar(Model model)
    {
        return ResponseEntity.ok(tareaHabilidadRepository.findAll());
    }


    // UPDATE: Actualiza la habilidad de la relacion
    @PostMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id,
                                             @RequestParam("Hab") String Hab)
    {
        Integer id_hab = Integer.parseInt(Hab);
        tareaHabilidadRepository.update(id, id_hab);
        return ResponseEntity.ok("Habilidad actualizada con exito");
    }

    // DELETE: Elimina una relacion
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id)
    {
        tareaHabilidadRepository.deleteById(id);
        return ResponseEntity.ok("Relacion tarea-habilidad eliminada exitosamente");
    }

}
