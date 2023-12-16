package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.EstadoTareaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EstadoTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Service
public class EstadoTareaRepoImp implements  EstadoTareaRepository {
    @Autowired
    Sql2o sql2o;

    //CREATE: Crear un nuevo estado
    @Override
    public void createEstadoTarea(EstadoTareaEntity estadoTarea)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO estado_tarea (descripcion)" +
                    "VALUES (:descripcion)";
            con.createQuery(sql)
                    .addParameter("descripcion", estadoTarea.getDescripcion())
                    .executeUpdate();
        }
    }

    //READ: Buscar todos los estados
    @Override
    public List<EstadoTareaEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from estado_tarea order by ID_ESTADO")
                    .executeAndFetch(EstadoTareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a un estado a partir de su ID
    @Override
    public EstadoTareaEntity findByID_ESTADO(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<EstadoTareaEntity> estadoTareaEntities = conn.createQuery("select * from estado_tarea where ID_ESTADO=:id")
                    .addParameter("id", id)
                    .executeAndFetch(EstadoTareaEntity.class);
            return estadoTareaEntities.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    // UPDATE: Actualizar descripcion para estado
    @Override
    public void update(Integer id, String desc) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE estado_tarea SET descripcion = :desc WHERE ID_ESTADO = :id";
            con.createQuery(sql)
                    .addParameter("desc", desc)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    // DELETE: elimina un estado por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM estado_tarea WHERE ID_ESTADO = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
