package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.RankingEntity;
import com.TBD.SistemaVoluntarios.Repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepoImp implements RankingRepository {
    @Autowired
    private final Sql2o sql2o;

    public RankingRepoImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    // CREATE: crear un nuevo ranking en la bd
    @Override
    public void createRanking(RankingEntity ranking)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO ranking (ID_VOLUNTARIO, ID_TAREA, puntaje, flg_invitado, flg_participa) " +
                    "VALUES (:ID_VOLUNTARIO, :ID_TAREA, :puntaje, :flg_Invitado, :flg_Participa)";
            con.createQuery(sql)
                    .addParameter("ID_VOLUNTARIO", ranking.getID_VOLUNTARIO())
                    .addParameter("ID_TAREA", ranking.getID_TAREA())
                    .addParameter("puntaje", ranking.getPuntaje())
                    .addParameter("flg_invitado", ranking.getFlg_invitado())
                    .addParameter("flg_participa", ranking.getFlg_participa())
                    .executeUpdate();
        }
    }

    @Override
    // READ: Obtener todos los rankings
    public List<RankingEntity> leerTodoElRanking() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM ranking";
            return con.createQuery(sql).executeAndFetch(RankingEntity.class);
        }
    }

    @Override
    // READ: leer ranking por ID
    public RankingEntity leerRankingPorId(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM ranking WHERE ID_RANKING = :id";
            return con.createQuery(sql)
                    .addParameter("ID_RANKING", id)
                    .executeAndFetchFirst(RankingEntity.class);
        }
    }

    @Override
    // UPDATE: actualiza el puntaje de un ranking, en base a un ID.
    public void actualizarPuntaje(Integer id, Integer nuevoPuntaje) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE ranking SET puntaje = :nuevoPuntaje WHERE ID_RANKING = :id";
            con.createQuery(sql)
                    .addParameter("puntaje", nuevoPuntaje)
                    .addParameter("ID_RANKING", id)
                    .executeUpdate();
        }
    }

    @Override
    // DELETE: elimina un ranking por ID
    public void eliminarRankingPorId(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM ranking WHERE ID_RANKING = :id";
            con.createQuery(sql)
                    .addParameter("ID_RANKING", id)
                    .executeUpdate();
        }
    }
}
