package br.com.ToCare.controller;

import br.com.ToCare.dto.CuidadorDTO;
import br.com.ToCare.dto.CuidadorRequest;
import br.com.ToCare.service.CuidadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cuidadores")
public class CuidadorController {

    @Autowired
    private CuidadorService service;

    @PostMapping
    public ResponseEntity<CuidadorDTO> criar(@RequestBody @Valid CuidadorRequest request) {
        return ResponseEntity.ok(service.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuidadorDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<CuidadorDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
