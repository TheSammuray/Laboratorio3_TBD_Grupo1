package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.TareaEntity;
import com.TBD.SistemaVoluntarios.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepoImp implements TareaRepository{
    @Autowired
    private final Sql2o sql2o;

    public TareaRepoImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE: Crear una nueva tarea
    @Override
    public void createTarea(TareaEntity tarea)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO tarea (nombre, descrip, fecha_inicio, fecha_fin, cant_vol_requeridos, cant_vol_inscritos, ID_EMERGENCIA, ID_ESTADO)" +
                    "VALUES (:nombre, :descrip, :fecha_inicio, :fecha_fin, :cant_vol_requeridos, :cant_vol_inscritos, :ID_EMERGENCIA, :ID_ESTADO)";
            con.createQuery(sql)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descrip", tarea.getDescrip())
                    .addParameter("fecha_inicio", tarea.getFecha_inicio())
                    .addParameter("fecha_fin", tarea.getFecha_fin())
                    .addParameter("cant_vol_requeridos", tarea.getCant_vol_requeridos())
                    .addParameter("cant_vol_inscritos", tarea.getCant_vol_inscritos())
                    .addParameter("ID_EMERGENCIA", tarea.getID_EMERGENCIA())
                    .addParameter("ID_ESTADO", tarea.getID_ESTADO())
                    .executeUpdate();
        }
    }

    //READ: Buscar todas las tareas
    @Override
    public List<TareaEntity> findAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select ID_TAREA, nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, " +
                            "ID_EMERGENCIA, fecha_inicio, fecha_fin, ID_ESTADO from tarea order by ID_TAREA ")
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a una tarea a partir de su ID
    @Override
    public TareaEntity findByID_TAREA(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<TareaEntity> tareas = conn.createQuery("select * from tarea where ID_TAREA=:id")
                    .addParameter("ID_TAREA", id)
                    .executeAndFetch(TareaEntity.class);
            return tareas.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //UPDATE: Actualiza la descripción de una tarea
    @Override
    public void updateDescrip(Integer id, String nuevaDescrip) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE tarea SET descrip = :nuevaDescrip WHERE ID_TAREA = :id";
            con.createQuery(sql)
                    .addParameter("descrip", nuevaDescrip)
                    .addParameter("ID_TAREA", id)
                    .executeUpdate();
        }
    }

    //UPDATE: Actualiza el estado de una tarea
    @Override
    public void updateEstado(Integer id, Integer nuevoEstado) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE tarea SET ID_ESTADO = :nuevoEstado WHERE ID_TAREA = :id";
            con.createQuery(sql)
                    .addParameter("ID_ESTADO", nuevoEstado)
                    .addParameter("ID_TAREA", id)
                    .executeUpdate();
        }
    }

    // DELETE: elimina una emergencia por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM tarea WHERE ID_TAREA = :id";
            con.createQuery(sql)
                    .addParameter("ID_TAREA", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
