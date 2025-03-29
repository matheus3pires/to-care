package br.com.ToCare.service;

import br.com.ToCare.model.Usuario;
import br.com.ToCare.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public ResponseEntity<Usuario> buscarUsuarioPorId(UUID id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public ResponseEntity<Usuario> atualizarUsuario(UUID id, Usuario usuario) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    public ResponseEntity<Void> deletarUsuario(UUID id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Usuario> buscarUsuarioPorByCpfCnpj(String cpfCnpj) {
        Usuario usuario = usuarioRepository.findByCpfCnpj(cpfCnpj);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }
}
