package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Entities.TareaEntity;
import com.TBD.SistemaVoluntarios.Repositories.TareaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tarea")
public class TareaController {

    private final TareaRepository tareaRepository;

    public TareaController(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // CREATE: crear una nueva tarea.
    @PostMapping("/nueva-tarea")
    public ResponseEntity<String> crearTarea(@RequestBody TareaEntity tarea)
    {
        tareaRepository.createTarea(tarea);
        return ResponseEntity.ok("Tarea creada con exito");
    }
    // READ: Listar todas las tareas
    @GetMapping("/lista-tarea")
    public ResponseEntity<List<TareaEntity>> listar(Model model)
    {
        return ResponseEntity.ok(tareaRepository.findAll());
    }
    // UPDATE: Actualiza la descripcion de la tarea
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDesc(@PathVariable Integer id,
                                             @RequestParam("descrip") String descrip)
    {
        tareaRepository.updateDescrip(id, descrip);
        return ResponseEntity.ok("Descripcion actualizada con exito");
    }

    // UPDATE: Actualiza el estado de la tarea
    @PostMapping("/{id}")
    public ResponseEntity<String> updateInst(@PathVariable Integer id,
                                             @RequestParam("est") String est)
    {
        Integer id_est = Integer.parseInt(est);
        tareaRepository.updateEstado(id, id_est);
        return ResponseEntity.ok("Estado de la tarea actualizado con exito");
    }

    // DELETE: Elimina una tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEm(@PathVariable Integer id)
    {
        tareaRepository.deleteById(id);
        return ResponseEntity.ok("Tarea eliminada exitosamente");
    }
}
