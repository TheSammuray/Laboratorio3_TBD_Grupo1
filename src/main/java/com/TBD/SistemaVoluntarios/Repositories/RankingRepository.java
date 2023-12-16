package com.TBD.SistemaVoluntarios.Repositories;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import java.util.List;

public interface RankingRepository{
    // CREATE: crear un nuevo ranking en la bd
    void createRanking(RankingEntity ranking);

    // READ: Obtener todos los rankings
    List<RankingEntity> leerTodoElRanking();

    // READ: leer ranking por ID
    RankingEntity leerRankingPorId(Integer id);

    // UPDATE: actualiza el puntaje de un ranking, en base a un ID.
    void actualizarPuntaje(Integer id, Integer nuevoPuntaje);

    // DELETE: elimina un ranking por ID
    void eliminarRankingPorId(Integer id);
}
