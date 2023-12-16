package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Entities.EstadoTareaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EstadoTareaRepository;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.EstadoTareaRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/estadoTarea")
public class EstadoTareaController {

    private final EstadoTareaRepository estadoTareaRepository;

    EstadoTareaController(EstadoTareaRepository EstadoTareaRepository){
        this.estadoTareaRepository = EstadoTareaRepository;
    }

    // CREATE: crear un nuevo estado.
    @PostMapping("/nueva-estado-tarea")
    public ResponseEntity<String> crearEstadoTarea(@RequestBody EstadoTareaEntity estadoTarea)
    {
        estadoTareaRepository.createEstadoTarea(estadoTarea);
        return ResponseEntity.ok("Estado creado con exito");
    }

    // READ: Listar todos los estado tarea.
    @GetMapping("/lista-estadoTarea")
    public ResponseEntity<List<EstadoTareaEntity>> listar(Model model)
    {
        return ResponseEntity.ok(estadoTareaRepository.findAll());
    }

    // UPDATE: Actualiza la descripcion de la estado
    @PutMapping("/actualizar-descripcion/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id,
                                             @RequestParam("descrip") String descrip)
    {
        estadoTareaRepository.update(id, descrip);
        return ResponseEntity.ok("Descripcion actualizada con exito");
    }


    // DELETE: Elimina un estado-tarea por id
    @DeleteMapping("/eliminar-estado-tarea/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id)
    {
        estadoTareaRepository.deleteById(id);
        return ResponseEntity.ok("Estado-tarea eliminado exitosamente");
    }

}
