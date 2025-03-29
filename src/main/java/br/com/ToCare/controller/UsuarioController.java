package br.com.ToCare.controller;

import br.com.ToCare.model.Usuario;
import br.com.ToCare.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioService.buscarTodosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable UUID id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable UUID id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable UUID id) {
        return usuarioService.deletarUsuario(id);
    }

    @GetMapping("/cpf-cnpj/{cpfCnpj}")
    public ResponseEntity<Usuario> getUsuarioByCpfCnpj(@PathVariable String cpfCnpj) {
        return usuarioService.buscarUsuarioPorByCpfCnpj(cpfCnpj);
    }
}
