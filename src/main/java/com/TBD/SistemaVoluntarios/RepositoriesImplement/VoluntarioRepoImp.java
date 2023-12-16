package com.TBD.SistemaVoluntarios.RepositoriesImplement;

import com.TBD.SistemaVoluntarios.Entities.VoluntarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class VoluntarioRepoImp implements VoluntarioRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    // CREATE: Agregar un voluntario
    @Override
    public void agregarVoluntario(VoluntarioEntity voluntario, Integer id) {
        voluntario.setIdUsuario(id); // Asigna el ID_USUARIO al voluntario
        mongoTemplate.save(voluntario);
    }

    // READ: Buscar todos los voluntarios.
    @Override
    public List<VoluntarioEntity> findAll() {
        return mongoTemplate.findAll(VoluntarioEntity.class);
    }

    @Override
    public VoluntarioEntity findByNombre(String nombre) {
        return mongoTemplate.findOne(
                // Utiliza un objeto Query para realizar la búsqueda por nombre
                org.springframework.data.mongodb.core.query.Query.query(
                        org.springframework.data.mongodb.core.query.Criteria.where("nombre").is(nombre)),
                VoluntarioEntity.class);
    }

    // READ: Buscar a un voluntario a partir de su ID.
    @Override
    public VoluntarioEntity findByID_VOLUNTARIO(Integer id) {
        return mongoTemplate.findById(id.toString(), VoluntarioEntity.class);
    }

    // UPDATE: Actualiza la ubicación de un voluntario.
    @Override
    public void updateUbicacion(Integer id, float nuevaLongitud, float nuevaLatitud) {
        VoluntarioEntity voluntario = mongoTemplate.findById(id.toString(), VoluntarioEntity.class);
        if (voluntario != null) {
            voluntario.setLongitud(nuevaLongitud);
            voluntario.setLatitud(nuevaLatitud);
            mongoTemplate.save(voluntario);
        }
    }

    // DELETE: elimina un voluntario por ID
    @Override
    public void deleteById(Integer id) {
        // Implementa la lógica para eliminar un voluntario por ID
        mongoTemplate.remove(
                org.springframework.data.mongodb.core.query.Query.query(
                        org.springframework.data.mongodb.core.query.Criteria.where("_id").is(id.toString())),
                VoluntarioEntity.class);
    }

    @Override
    public void deleteByID_VOLUNTARIO(Integer id) {
        // Implementa la lógica para eliminar un voluntario por ID
        mongoTemplate.remove(
                org.springframework.data.mongodb.core.query.Query.query(
                        org.springframework.data.mongodb.core.query.Criteria.where("_id").is(id.toString())),
                VoluntarioEntity.class);
    }

    // Implementa el método insert de la interfaz MongoRepository
    @Override
    public <S extends VoluntarioEntity> S insert(S s) {
        // Implementa la lógica para insertar un voluntario
        return mongoTemplate.insert(s);
    }

    @Override
    public <S extends VoluntarioEntity> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends VoluntarioEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public List<VoluntarioEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public <S extends VoluntarioEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends VoluntarioEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<VoluntarioEntity> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public <S extends VoluntarioEntity> S save(S entity) {
        return null;
    }

    @Override
    public Optional<VoluntarioEntity> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(VoluntarioEntity entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends VoluntarioEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Page<VoluntarioEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends VoluntarioEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends VoluntarioEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends VoluntarioEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends VoluntarioEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends VoluntarioEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
