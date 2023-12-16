package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.VolHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.VolHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolHabilidadRepoImp implements VolHabilidadRepository {
    @Autowired
    Sql2o sql2o;

    //CREATE: Crear un nuevo intermedio
    @Override
    public void createVolHab(Integer idVol, Integer idHab)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO vol_habilidad (ID_VOLUNTARIO, ID_HABILIDAD) " +
                    "VALUES (:idVol, :idHab)";
            con.createQuery(sql)
                    .addParameter("idVol", idVol)
                    .addParameter("idHab", idHab)
                    .executeUpdate();
        }
    }

    //READ: Buscar todos los intermedios
    @Override
    public List<VolHabilidadEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from vol_habilidad order by ID_VOL_HAB")
                    .executeAndFetch(VolHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar una relacion a partir de el id de voluntario
    @Override
    public VolHabilidadEntity findByID_VOLUNTARIO(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<VolHabilidadEntity> volHabilidadEntities = conn.createQuery("select * from vol_habilidad where ID_VOLUNTARIO=:id")
                    .addParameter("ID_VOLUNTARIO", id)
                    .executeAndFetch(VolHabilidadEntity.class);
            return volHabilidadEntities.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //READ: Buscar una relacion a partir de el id de habilidad
    @Override
    public VolHabilidadEntity findByID_HABILIDAD(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<VolHabilidadEntity> volHabilidadEntities = conn.createQuery("select * from vol_habilidad where ID_HABILIDAD=:id")
                    .addParameter("ID_HABILIDAD", id)
                    .executeAndFetch(VolHabilidadEntity.class);
            return volHabilidadEntities.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //UPDATE: Actualiza el id de voluntario
    @Override
    public void updateID_VOLUNTARIO(Integer id, Integer nuevoIdVol) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE vol_habilidad SET ID_VOLUNTARIO = :nuevoIdVol WHERE ID_VOL_HAB = :id";
            con.createQuery(sql)
                    .addParameter("ID_VOLUNTARIO", nuevoIdVol)
                    .addParameter("ID_VOL_HAB", id)
                    .executeUpdate();
        }
    }
    //UPDATE: Actualiza el id de habilidad
    @Override
    public void updateID_HABILIDAD(Integer id, Integer nuevoIDHab) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE vol_hablidad SET ID_HABILIDAD = :nuevoIdHab WHERE ID_HABILIDAD = :id";
            con.createQuery(sql)
                    .addParameter("ID_HABILIDAD", nuevoIDHab)
                    .addParameter("ID_VOL_HAB", id)
                    .executeUpdate();
        }
    }

    // DELETE: elimina una relacion por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM vol_habilidad WHERE ID_VOL_HAB = :id";
            con.createQuery(sql)
                    .addParameter("ID_VOL_HAB", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
