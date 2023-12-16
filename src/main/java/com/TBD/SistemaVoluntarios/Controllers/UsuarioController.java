package com.TBD.SistemaVoluntarios.Controllers;

import com.TBD.SistemaVoluntarios.Entities.UsuarioEntity;
import com.TBD.SistemaVoluntarios.Repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // CREATE: Crear un nuevo usuario...
    @PostMapping("/agregar-usuario")
    public ResponseEntity<Integer> nuevoUsuario(@RequestBody UsuarioEntity usuario) {
        usuarioRepository.createUsuario(usuario);
        UsuarioEntity usuarioRecuperado = usuarioRepository.findByEmail(usuario.getEmail());
        return ResponseEntity.ok(usuarioRecuperado.getID_USUARIO());
    }

    // READ: Leer todos los usuarios ...
    @GetMapping("/lista-usuarios")
    public ResponseEntity<List<UsuarioEntity>> listarUsuarios() {

        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    // READ: Leer todos los usuarios según su rol...
    @GetMapping("/lista-usuarios-por-rol")
    public ResponseEntity<List<UsuarioEntity>> listaPorRol(@RequestParam("rol") String rol) {
        return ResponseEntity.ok(usuarioRepository.findAllByRol(rol));
    }

    //READ: Buscar un usuario por su email...
    @GetMapping("/buscar")
    public ResponseEntity<UsuarioEntity> buscarUsuario(@RequestParam("email") String email) {
        return ResponseEntity.ok(usuarioRepository.findByEmail(email));
    }

    //READ: Buscar un usuario por su id...
    @GetMapping("/buscar-id")
    public ResponseEntity<UsuarioEntity> buscarUsuarioId(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(usuarioRepository.findByID_USUARIO(id));
    }

    //UPDATE: Actualizar EMAIL por ID...
    @PutMapping("/actualizar-email/{id}")
    public ResponseEntity<String> updateEmail(@PathVariable Integer id, @RequestParam String newEmail) {
        usuarioRepository.updateEmail(id, newEmail);
        return ResponseEntity.ok("Email del usuario actualizado exitosamente");
    }

    //UPDATE: Actualizar password por id.
    @PutMapping("/actualizar-pass/{id}")
    public ResponseEntity<String> updatePass(@PathVariable Integer id, @RequestParam String newPass) {
        usuarioRepository.updatePass(id, newPass);
        return ResponseEntity.ok("Password del usuario actualizado correctamente");
    }

    //DELETE: Eliminar un usuario por id.

    @DeleteMapping("/eliminar-usuario/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente");
    }

}
