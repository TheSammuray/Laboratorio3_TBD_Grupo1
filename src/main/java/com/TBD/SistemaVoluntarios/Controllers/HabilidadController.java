package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.HabilidadRepository;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.HabilidadRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadController {

    private final HabilidadRepository habilidadRepository;

    HabilidadController(HabilidadRepository HabilidadRepository){
        this.habilidadRepository = HabilidadRepository;
    }

    // CREATE: crear una nueva habilidad.
    @PostMapping("/nueva-habilidad")
    public ResponseEntity<String> crearHabilidad(@RequestBody HabilidadEntity habilidad)
    {
        habilidadRepository.createHabilidad(habilidad);
        return ResponseEntity.ok("Habilidad creada con exito");
    }

    // READ: Listar todas las habilidades
    @GetMapping("/lista-habilidad")
    public ResponseEntity<List<HabilidadEntity>> listar(Model model)
    {
        return ResponseEntity.ok(habilidadRepository.findAll());
    }
    // UPDATE: Actualiza la descripcion de la habilidad
    @PutMapping("/actualizar-habilidad/{id}")
    public ResponseEntity<String> updateDesc(@PathVariable Integer id,
                                             @RequestParam("descrip") String descrip)
    {
        habilidadRepository.updateDescrip(id, descrip);
        return ResponseEntity.ok("Descripcion actualizada con exito");
    }

    // DELETE: Elimina una habilidad
    @DeleteMapping("/eliminar-habilidad/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id)
    {
        habilidadRepository.deleteById(id);
        return ResponseEntity.ok("Habilidad eliminada exitosamente");
    }

}
