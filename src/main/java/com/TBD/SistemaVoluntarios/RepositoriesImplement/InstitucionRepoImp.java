package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.InstitucionEntity;
import com.TBD.SistemaVoluntarios.Repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionRepoImp implements InstitucionRepository {
    @Autowired
    Sql2o sql2o;

    //CREATE: Crear una nueva institucion.
    @Override
    public void createInstitucion(InstitucionEntity institucion)
    {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO institucion (nombre, descrip)" +
                    "VALUES (:nombre,:descrip)";
            con.createQuery(sql)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("descrip", institucion.getDescrip())
                    .executeUpdate();
        }
    }

    //READ: Buscar todas las instituciones.
    @Override
    public List<InstitucionEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from institucion order by ID_INSTITUCION")
                    .executeAndFetch(InstitucionEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a una institucion a partir de su ID.
    @Override
    public InstitucionEntity findByID_INSTITUCION(Integer id) {
        try (Connection conn = sql2o.open()) {
            List <InstitucionEntity> institucion = conn.createQuery("select * from institucion where ID_INSTITUCION=:id")
                    .addParameter("ID_INSTITUCION", id)
                    .executeAndFetch(InstitucionEntity.class);
            return institucion.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //UPDATE: Actualiza la descripción de una institucion.
    @Override
    public void updateDescrip(Integer id, String nuevaDescrip) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE institucion SET descrip = :nuevaDescrip WHERE ID_INSTITUCION = :id";
            con.createQuery(sql)
                    .addParameter("nuevaDescrip", nuevaDescrip)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


    // DELETE: elimina una institucion por ID.
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM institucion WHERE ID_INSTITUCION = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
