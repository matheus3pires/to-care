package br.com.ToCare.service;

import br.com.ToCare.model.Cuidador;
import br.com.ToCare.repository.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuidadorService {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    public List<Cuidador> buscarTodosCuidadores() {
        return cuidadorRepository.findAll();
    }

    public ResponseEntity<Cuidador> buscarCuidadorPorId(UUID id) {
        Optional<Cuidador> cuidador = cuidadorRepository.findById(id);
        return cuidador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Cuidador salvarCuidador(Cuidador cuidador) {
        return cuidadorRepository.save(cuidador);
    }

    public ResponseEntity<Cuidador> atualizarCuidador(UUID id, Cuidador cuidador) {
        if (!cuidadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cuidador.setId(id);
        return ResponseEntity.ok(cuidadorRepository.save(cuidador));
    }

    public ResponseEntity<Void> deletarCuidador(UUID id) {
        if (!cuidadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cuidadorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Cuidador> buscarCuidadorPorCpfCnpj(String cpfCnpj) {
        Cuidador cuidador = cuidadorRepository.findByCpfCnpj(cpfCnpj);
        return cuidador != null ? ResponseEntity.ok(cuidador) : ResponseEntity.notFound().build();
    }
}