package br.com.ToCare.controller;

import br.com.ToCare.model.Cuidador;
import br.com.ToCare.service.CuidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cuidadores")
public class CuidadorController {

    @Autowired
    private CuidadorService cuidadorService;

    @GetMapping
    public List<Cuidador> getAllCuidadores() {
        return cuidadorService.getAllCuidadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuidador> getCuidadorById(@PathVariable UUID id) {
        return cuidadorService.getCuidadorById(id);
    }

    @PostMapping
    public Cuidador createCuidador(@RequestBody Cuidador cuidador) {
        return cuidadorService.createCuidador(cuidador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuidador> updateCuidador(@PathVariable UUID id, @RequestBody Cuidador cuidador) {
        return cuidadorService.updateCuidador(id, cuidador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuidador(@PathVariable UUID id) {
        return cuidadorService.deleteCuidador(id);
    }

    @GetMapping("/cpf-cnpj/{cpfCnpj}")
    public ResponseEntity<Cuidador> getCuidadorByCpfCnpj(@PathVariable String cpfCnpj) {
        return cuidadorService.getCuidadorByCpfCnpj(cpfCnpj);
    }
}