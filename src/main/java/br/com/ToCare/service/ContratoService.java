package br.com.ToCare.service;

import br.com.ToCare.model.Contrato;
import br.com.ToCare.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> getAllContratos() {
        return contratoRepository.findAll();
    }

    public ResponseEntity<Contrato> getContratoById(UUID id) {
        Optional<Contrato> contrato = contratoRepository.findById(id);
        return contrato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Contrato createContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public ResponseEntity<Contrato> updateContrato(UUID id, Contrato contrato) {
        if (!contratoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contrato.setId(id);
        return ResponseEntity.ok(contratoRepository.save(contrato));
    }

    public ResponseEntity<Void> deleteContrato(UUID id) {
        if (!contratoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        contratoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public List<Contrato> getContratosByUsuarioId(UUID usuarioId) {
        return contratoRepository.findByUsuarioId(usuarioId);
    }

    public List<Contrato> getContratosByCuidadorId(UUID cuidadorId) {
        return contratoRepository.findByCuidadorId(cuidadorId);
    }
}
