package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.EmergenciaEntity;
import com.TBD.SistemaVoluntarios.Repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepoImp implements EmergenciaRepository{
    @Autowired
    private Sql2o sql2o;

    //CREATE: Crear una nueva emergencia
    @Override
    public void createEmergencia(EmergenciaEntity emergencia)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO Emergencia (nombre, descrip, fecha_inicio, fecha_fin, ID_INSTITUCION, latitud_emer, longitud_emer, estado)" +
                    "VALUES (:nombre, :descrip, :fecha_inicio, :fecha_fin, :ID_INSTITUCION, :latitud_emer, :longitud_emer, 'en curso')";
            con.createQuery(sql)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descrip", emergencia.getDescrip())
                    .addParameter("fecha_inicio", emergencia.getFecha_inicio())
                    .addParameter("fecha_fin", emergencia.getFecha_fin())
                    .addParameter("ID_INSTITUCION", emergencia.getID_INSTITUCION())
                    .addParameter("latitud_emer", emergencia.getLatitud_emer())
                    .addParameter("longitud_emer", emergencia.getLongitud_emer())
                    .executeUpdate();
        }
    }

    //READ: Buscar todas las emergencias
    @Override
    public List<EmergenciaEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select ID_EMERGENCIA, nombre, descrip, fecha_inicio, fecha_fin, ID_INSTITUCION, latitud_emer, longitud_emer, estado from emergencia order by ID_EMERGENCIA")
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a una emergencia a partir de su ID
    @Override
    public EmergenciaEntity findByID_EMERGENCIA(Integer id) {
        try (Connection conn = sql2o.open()) {
            List<EmergenciaEntity> emergencia = conn.createQuery("select * from emergencia where ID_EMERGENCIA=:id")
                    .addParameter("ID_EMERGENCIA", id)
                    .executeAndFetch(EmergenciaEntity.class);
            return emergencia.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //UPDATE: Actualiza la descripción de una emergencia
    @Override
    public void updateDescrip(Integer id, String nuevaDescrip) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE emergencia SET descrip = :nuevaDescrip WHERE ID_EMERGENCIA = :id";
            con.createQuery(sql)
                    .addParameter("nuevaDescrip", nuevaDescrip)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    //UPDATE: Actualiza la institucion de una emergencia
    @Override
    public void updateInstitucion(Integer id, Integer nuevaInstitucion) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE emergencia SET ID_INSTITUCION = :nuevaInstitucion WHERE ID_EMERGENCIA = :id";
            con.createQuery(sql)
                    .addParameter("nuevaInstitucion", nuevaInstitucion)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    // DELETE: elimina una emergencia por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM emergencia WHERE ID_EMERGENCIA = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
