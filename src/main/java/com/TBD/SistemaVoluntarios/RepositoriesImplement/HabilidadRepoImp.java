package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.HabilidadEntity;
import com.TBD.SistemaVoluntarios.Repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilidadRepoImp implements HabilidadRepository {
    @Autowired
    Sql2o sql2o;

    //CREATE: Crear una nueva habilidad
    @Override
    public void createHabilidad(HabilidadEntity habilidad)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO Habilidad (descrip)" +
                    "VALUES (:descrip)";
            con.createQuery(sql)
                    .addParameter("descrip", habilidad.getDescrip())
                    .executeUpdate();
        }
    }

    //READ: Buscar todas las hablidades
    @Override
    public List<HabilidadEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from habilidad order by ID_HABILIDAD")
                    .executeAndFetch(HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a una emergencia a partir de su ID
    @Override
    public HabilidadEntity findByID_HABILIDAD(Integer id) {
        try (Connection conn = sql2o.open()) {
            List <HabilidadEntity> habilidad = conn.createQuery("select * from habilidad where ID_HABILIDAD=:id")
                    .addParameter("id", id)
                    .executeAndFetch(HabilidadEntity.class);
            return habilidad.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //UPDATE: Actualiza la descripción de una habilidad
    @Override
    public void updateDescrip(Integer id, String nuevaDescrip) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE habilidad SET descrip = :nuevaDescrip WHERE ID_HABILIDAD = :id";
            con.createQuery(sql)
                    .addParameter("nuevaDescrip", nuevaDescrip)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


    // DELETE: elimina una habilidad por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM habilidad WHERE ID_HABILIDAD = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
