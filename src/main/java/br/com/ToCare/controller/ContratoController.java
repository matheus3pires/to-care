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
    public List<Contrato> buscarTodosContratos() {
        return contratoService.buscarTodosContratos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContratoPorById(@PathVariable UUID id) {
        return contratoService.buscarContratoPorById(id);
    }

    @PostMapping
    public Contrato salvarContrato(@RequestBody Contrato contrato) {
        return contratoService.salvarContrato(contrato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> atualizarContrato(@PathVariable UUID id, @RequestBody Contrato contrato) {
        return contratoService.atualizarContrato(id, contrato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContrato(@PathVariable UUID id) {
        return contratoService.deletarContrato(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Contrato> buscarContratosPorUsuarioId(@PathVariable UUID usuarioId) {
        return contratoService.buscarContratosPorUsuarioId(usuarioId);
    }

    @GetMapping("/cuidador/{cuidadorId}")
    public List<Contrato> buscarContratosPorCuidadorId(@PathVariable UUID cuidadorId) {
        return contratoService.buscarContratosPorCuidadorId(cuidadorId);
    }
}
