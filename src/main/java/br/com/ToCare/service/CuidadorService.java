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

    public List<Cuidador> getAllCuidadores() {
        return cuidadorRepository.findAll();
    }

    public ResponseEntity<Cuidador> getCuidadorById(UUID id) {
        Optional<Cuidador> cuidador = cuidadorRepository.findById(id);
        return cuidador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Cuidador createCuidador(Cuidador cuidador) {
        return cuidadorRepository.save(cuidador);
    }

    public ResponseEntity<Cuidador> updateCuidador(UUID id, Cuidador cuidador) {
        if (!cuidadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cuidador.setId(id);
        return ResponseEntity.ok(cuidadorRepository.save(cuidador));
    }

    public ResponseEntity<Void> deleteCuidador(UUID id) {
        if (!cuidadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cuidadorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Cuidador> getCuidadorByCpfCnpj(String cpfCnpj) {
        Cuidador cuidador = cuidadorRepository.findByCpfCnpj(cpfCnpj);
        return cuidador != null ? ResponseEntity.ok(cuidador) : ResponseEntity.notFound().build();
    }
}