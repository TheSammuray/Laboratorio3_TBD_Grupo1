package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import com.TBD.SistemaVoluntarios.Repositories.RankingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rankings")
public class RankingController {
    private final RankingRepository rankingRepository;

    public RankingController(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }


    // CREATE: crear un nuevo ranking.
    @PostMapping("/agregar-ranking")
    public ResponseEntity<String> crearRanking(RankingEntity ranking)
    {
        rankingRepository.createRanking(ranking);
        return ResponseEntity.ok("Ranking creado con exito");
    }

    // READ: leer todos los rankings.
    @GetMapping("/lista-rankings")
    public ResponseEntity<List<RankingEntity>> leerTodoElRanking()
    {
        List<RankingEntity> rankings = rankingRepository.leerTodoElRanking();
        return ResponseEntity.ok(rankings);
    }

    // READ: leer un ranking por ID.
    @GetMapping("/{id}")
    public ResponseEntity<RankingEntity> leerRankingPorId(Integer id)
    {
        RankingEntity ranking = rankingRepository.leerRankingPorId(id);
        return ResponseEntity.ok(ranking);
    }

    // UPDATE: actualiza el puntaje de un ranking, en base a un ID.
    @PutMapping("/id")
    public ResponseEntity<String> actualizarPuntaje(Integer id, @RequestParam("nuevoPuntaje") Integer nuevoPuntaje)
    {
        rankingRepository.actualizarPuntaje(id, nuevoPuntaje);
        return ResponseEntity.ok("Puntaje actualizado con exito.");
    }

    // DELETE: eliminar un ranking por ID.
    @DeleteMapping("/id")
    public ResponseEntity<String> eliminarRankingPorId(Integer id)
    {
        rankingRepository.eliminarRankingPorId(id);
        return ResponseEntity.ok("Ranking eliminado exitosamente.");
    }

}
