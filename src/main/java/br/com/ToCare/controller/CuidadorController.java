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
    public List<Cuidador> buscarTodosCuidadores() {
        return cuidadorService.buscarTodosCuidadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuidador> buscarCuidadorPorId(@PathVariable UUID id) {
        return cuidadorService.buscarCuidadorPorId(id);
    }

    @PostMapping
    public Cuidador createCuidador(@RequestBody Cuidador cuidador) {
        return cuidadorService.salvarCuidador(cuidador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuidador> atualizarCuidador(@PathVariable UUID id, @RequestBody Cuidador cuidador) {
        return cuidadorService.atualizarCuidador(id, cuidador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCuidador(@PathVariable UUID id) {
        return cuidadorService.deletarCuidador(id);
    }

    @GetMapping("/cpf-cnpj/{cpfCnpj}")
    public ResponseEntity<Cuidador> getCuidadorByCpfCnpj(@PathVariable String cpfCnpj) {
        return cuidadorService.buscarCuidadorPorCpfCnpj(cpfCnpj);
    }
}