package com.TBD.SistemaVoluntarios.RepositoriesImplement;


import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class VoluntarioRepoImp implements VoluntarioRepository{
    @Autowired
    Sql2o sql2o;

    //CREATE: Agregar un voluntario
    @Override
    public void agregarVoluntario(VoluntarioEntity voluntario, Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO voluntario (id_usuario, nombre, latitud, longitud)" +
                    "VALUES (:id, :nombre, :latitud, :longitud )";
            con.createQuery(sql)
                    .addParameter("id", id) // Agrega el ID_USUARIO aquí
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("latitud", voluntario.getLatitud())
                    .addParameter("longitud", voluntario.getLongitud()) // Arregla el nombre del parámetro aquí
                    .executeUpdate();
        }
    }


    //READ: Buscar todos los voluntarios.
    @Override
    public List<VoluntarioEntity> findAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from voluntario order by ID_VOLUNTARIO")
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VoluntarioEntity findByNombre(String nombre) {
        try (Connection conn = sql2o.open()) {
            List <VoluntarioEntity> voluntario = conn.createQuery("select * from voluntario where nombre=:nombre")
                    .addParameter("nombre", nombre)
                    .executeAndFetch(VoluntarioEntity.class);
            return voluntario.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //READ: Buscar a un voluntario a partir de su ID.
    @Override
    public VoluntarioEntity findByID_VOLUNTARIO(Integer id) {
        try (Connection conn = sql2o.open()) {
            List <VoluntarioEntity> voluntario = conn.createQuery("select * from voluntario where ID_VOLUNTARIO=:id")
                    .addParameter("ID_VOLUNTARIO", id)
                    .executeAndFetch(VoluntarioEntity.class);
            return voluntario.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //UPDATE: Actualiza la ubicacion de un voluntario.
    @Override
    public void updateUbicacion(Integer id, float nuevaLongitud, float nuevaLatitud) {
        try (Connection con = sql2o.beginTransaction()) {
            // Realizar la actualización de la longitud
            con.createQuery("UPDATE voluntario SET longitud = :nuevaLongitud WHERE ID_VOLUNTARIO = :id")
                    .addParameter("nuevaLongitud", nuevaLongitud)
                    .addParameter("id", id)
                    .executeUpdate();

            // Realizar la actualización de la latitud
            con.createQuery("UPDATE voluntario SET latitud = :nuevaLatitud WHERE ID_VOLUNTARIO = :id")
                    .addParameter("nuevaLatitud", nuevaLatitud)
                    .addParameter("id", id)
                    .executeUpdate();

            // Confirmar la el cambio.
            con.commit();
        } catch (Exception e) {
            // Realizar un rollback en caso de excepción
            System.out.println(e.getMessage());
        }
    }


    // DELETE: elimina un voluntario por ID
    @Override
    public void deleteById(Integer id) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM voluntario WHERE ID_VOLUNTARIO = :id";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
