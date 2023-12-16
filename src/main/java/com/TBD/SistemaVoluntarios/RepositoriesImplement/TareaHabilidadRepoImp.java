package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.TareaHabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.TareaHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaHabilidadRepoImp implements TareaHabilidadRepository {
    @Autowired
    private final Sql2o sql2o;

    public TareaHabilidadRepoImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE: Crear una nueva conexion
    @Override
    public void createTareaHabilidad(TareaHabilidadEntity tareaHabilidad)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO tarea_habilidad (ID_EME_HAB, ID_TAREA)" +
                    "VALUES (:ID_EME_HAB, :ID_TAREA)";
            con.createQuery(sql)
                    .addParameter("ID_EME_HAB", tareaHabilidad.getID_EME_HAB())
                    .addParameter("ID_TAREA", tareaHabilidad.getID_TAREA())
                    .executeUpdate();
        }
    }

    //READ: Buscar todas las conexiones
    @Override
    public List<TareaHabilidadEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea_habilidad order by ID_TARHAB")
                    .executeAndFetch(TareaHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a una conexion a partir de su ID
    @Override
    public TareaHabilidadEntity findByID_TARHAB(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<TareaHabilidadEntity> tareaHabilidadEntities = conn.createQuery("select * from tarea_habilidad where ID_TARHAB=:id")
                    .addParameter("ID_TARHAB", id)
                    .executeAndFetch(TareaHabilidadEntity.class);
            return tareaHabilidadEntities.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    // UPDATE: Actualizar descripcion para estado
    @Override
    public void update(Integer id, Integer nuevaHab) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE tarea_habilidad SET ID_HABILIDAD = :desc WHERE ID_TARHAB = :id";
            con.createQuery(sql)
                    .addParameter("ID_HABILIDAD", nuevaHab)
                    .addParameter("ID_TARHAB", id)
                    .executeUpdate();
        }
    }

    // DELETE: elimina una conexion por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM tarea_habilidad WHERE ID_TARHAB = :id";
            con.createQuery(sql)
                    .addParameter("ID_TARHAB", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
