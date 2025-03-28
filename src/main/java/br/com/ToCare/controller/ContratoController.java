package br.com.ToCare.controller;

import br.com.ToCare.model.Contrato;
import br.com.ToCare.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> getAllContratos() {
        return contratoService.getAllContratos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> getContratoById(@PathVariable UUID id) {
        return contratoService.getContratoById(id);
    }

    @PostMapping
    public Contrato createContrato(@RequestBody Contrato contrato) {
        return contratoService.createContrato(contrato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> updateContrato(@PathVariable UUID id, @RequestBody Contrato contrato) {
        return contratoService.updateContrato(id, contrato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable UUID id) {
        return contratoService.deleteContrato(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Contrato> getContratosByUsuarioId(@PathVariable UUID usuarioId) {
        return contratoService.getContratosByUsuarioId(usuarioId);
    }

    @GetMapping("/cuidador/{cuidadorId}")
    public List<Contrato> getContratosByCuidadorId(@PathVariable UUID cuidadorId) {
        return contratoService.getContratosByCuidadorId(cuidadorId);
    }
}
