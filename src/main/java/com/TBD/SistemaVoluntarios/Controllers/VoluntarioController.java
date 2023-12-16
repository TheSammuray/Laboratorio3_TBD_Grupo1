package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {

    private final VoluntarioRepository voluntarioRepository;

    public VoluntarioController(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    // CREATE: agregar un voluntario....
    @PostMapping("/nuevo-voluntario")
    public ResponseEntity<String> agregarVoluntario(@RequestBody VoluntarioEntity voluntario) {
        voluntarioRepository.save(voluntario);
        return ResponseEntity.ok("Voluntario agregado con éxito");
    }

    // READ: Listar todos los voluntarios...
    @GetMapping("/lista-voluntario")
    public ResponseEntity<List<VoluntarioEntity>> listar() {
        return ResponseEntity.ok(voluntarioRepository.findAll());
    }

    @GetMapping("/buscar")
    public ResponseEntity<VoluntarioEntity> buscarVoluntario(@RequestParam("nombre") String nombre) {
        return ResponseEntity.ok(voluntarioRepository.findByNombre(nombre));
    }

    // UPDATE: Actualiza la ubicacion de un voluntario...
    @PutMapping("/actualizar-ubicacion/{id}")
    public ResponseEntity<String> updateUbicacion(@PathVariable String id,
                                                  @RequestParam("nuevaLongitud") float nuevaLongitud,
                                                  @RequestParam("nuevaLatitud") float nuevaLatitud) {
        VoluntarioEntity voluntario = voluntarioRepository.findById(id).orElse(null);
        if (voluntario != null) {
            voluntario.setLongitud(nuevaLongitud);
            voluntario.setLatitud(nuevaLatitud);
            voluntarioRepository.save(voluntario);
            return ResponseEntity.ok("Ubicación actualizada con éxito");
        } else {
            return ResponseEntity.badRequest().body("No se encontró el voluntario con el ID proporcionado.");
        }
    }

    // DELETE: Elimina un voluntario.
    @DeleteMapping("/eliminar-voluntario/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        voluntarioRepository.deleteById(id);
        return ResponseEntity.ok("Voluntario eliminado exitosamente.");
    }
}
