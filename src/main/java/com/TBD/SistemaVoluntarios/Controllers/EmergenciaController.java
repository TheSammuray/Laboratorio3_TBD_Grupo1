package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmergenciaRepository;
import com.TBD.SistemaVoluntarios.RepositoriesImplement.EmergenciaRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/emergencia")
public class EmergenciaController {

    private final EmergenciaRepository emergenciaRepository;

    EmergenciaController(EmergenciaRepository EmergenciaRepository){
        this.emergenciaRepository = EmergenciaRepository;
    }

    // CREATE: crear una nueva emergencia.
    @PostMapping("/nueva-emergencia")
    public ResponseEntity<String> crearEmergencia(@RequestBody EmergenciaEntity emergencia)
    {
        // 2023-10-23T12:33:35.927+00:00 tipo fecha_inicio
        emergenciaRepository.createEmergencia(emergencia);
        return ResponseEntity.ok("Emergencia creada con exito");
    }

    // READ: Listar todas las emergencias
    @GetMapping("/lista-emergencia")
    public ResponseEntity<List<EmergenciaEntity>> listar(Model model)
    {
        return ResponseEntity.ok(emergenciaRepository.findAll());
    }

    // UPDATE: Actualiza la descripcion de la emergencia
    @PutMapping("/actualizar-descripcion/{id}")
    public ResponseEntity<String> updateDesc(@PathVariable Integer id,
                                             @RequestParam("descrip") String descrip)
    {
        emergenciaRepository.updateDescrip(id, descrip);
        return ResponseEntity.ok("Descripcion actualizada con exito");
    }

    // UPDATE: Actualiza la institucion de la emergencia
    @PutMapping ("/actualizar-institucion/{id}")
    public ResponseEntity<String> updateInst(@PathVariable Integer id,
                                             @RequestParam("Inst") String Inst)
    {
        Integer id_inst = Integer.parseInt(Inst);
        emergenciaRepository.updateInstitucion(id, id_inst);
        return ResponseEntity.ok("Institucion actualizada con exito");
    }

    // DELETE: Elimina una emergencia
    @DeleteMapping("/eliminar-emergencia/{id}")
    public ResponseEntity<String> deleteEm(@PathVariable Integer id)
    {
        emergenciaRepository.deleteById(id);
        return ResponseEntity.ok("Emergencia eliminada exitosamente");
    }

}
