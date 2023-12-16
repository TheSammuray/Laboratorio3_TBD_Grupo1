package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<String> agregarVoluntario(@RequestBody VoluntarioEntity voluntario, @RequestParam Integer id)
    {
        voluntarioRepository.agregarVoluntario(voluntario, id);
        return ResponseEntity.ok("Voluntario agregado con exito");
    }

    // READ: Listar todos los voluntarios...
    @GetMapping("/lista-voluntario")
    public ResponseEntity<List<VoluntarioEntity>> listar(Model model)
    {
        return ResponseEntity.ok(voluntarioRepository.findAll());
    }

    @GetMapping("/buscar")
    public ResponseEntity<VoluntarioEntity> buscarVoluntario(@RequestParam("nombre") String nombre) {
        return ResponseEntity.ok(voluntarioRepository.findByNombre(nombre));
    }

    // UPDATE: Actualiza la ubicacion de un voluntario...
    @PutMapping("/actualizar-ubicacion/{id}")
    public ResponseEntity<String> updateUbicacion(@PathVariable Integer id,
                                                  @RequestParam("nuevaLongitud") float nuevaLongitud,
                                                  @RequestParam("nuevaLatitud") float nuevaLatitud)
    {
        voluntarioRepository.updateUbicacion(id, nuevaLongitud, nuevaLatitud);
        return ResponseEntity.ok("Ubicacion actualizada con exito");
    }

    // DELETE: Elimina un voluntario.
    @DeleteMapping("/eliminar-voluntario/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id)
    {
        voluntarioRepository.deleteById(id);
        return ResponseEntity.ok("Voluntario eliminado exitosamente.");
    }

}
