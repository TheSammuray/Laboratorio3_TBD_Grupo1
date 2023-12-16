package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmeHabilidadEntity;
import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmeHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/emeHabilidad")
public class EmeHabilidadController {

    EmeHabilidadRepository emeHabilidadRepository;

    EmeHabilidadController(EmeHabilidadRepository EmeHabilidadRepository){
        this.emeHabilidadRepository = EmeHabilidadRepository;
    }


    // CREATE: crear una nueva relacion.
    @PostMapping("/nueva-emeHabilidad")
    public ResponseEntity<String> crearEmeHabilidad(@RequestBody EmeHabilidadEntity emeHabilidad)
    {
        emeHabilidadRepository.createEmeHabilidad(emeHabilidad);
        return ResponseEntity.ok("Relacion emergencia-habilidad creada con exito");
    }

    //READ: Lista todas las relaciones emergencia-habilidad
    @GetMapping("/lista-emeHabilidad")
    public ResponseEntity<List<EmeHabilidadEntity>> listar(Model model)
    {
        return ResponseEntity.ok(emeHabilidadRepository.findAll());
    }


    // UPDATE: Actualiza la habilidad de la relacion Emergencia-Habilidad
    @PostMapping("/actualizar-habilidad/{id}")
    public ResponseEntity<String> updateInst(@PathVariable Integer id,
                                             @RequestParam("Hab") String Hab)
    {
        Integer id_hab = Integer.parseInt(Hab);
        emeHabilidadRepository.update(id, id_hab);
        return ResponseEntity.ok("Habilidad actualizada con exito");
    }

    // DELETE: Elimina una relacion
    @DeleteMapping("/eliminar-relacion/{id}")
    public ResponseEntity<String> deleteEm(@PathVariable Integer id)
    {
        emeHabilidadRepository.deleteById(id);
        return ResponseEntity.ok("Relacion emergencia-habilidad eliminada exitosamente");
    }
}
