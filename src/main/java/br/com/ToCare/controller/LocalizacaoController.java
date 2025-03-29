package br.com.ToCare.controller;

import br.com.ToCare.model.Localizacao;
import br.com.ToCare.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @PostMapping
    public ResponseEntity<Localizacao> salvarLocalizacao(@RequestBody Localizacao localizacao) {
        Localizacao novaLocalizacao = localizacaoService.salvarLocalizacao(localizacao);
        return ResponseEntity.ok(novaLocalizacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localizacao> buscarLocalizacaoPorId(@PathVariable UUID id) {
        Optional<Localizacao> localizacao = localizacaoService.buscarLocalizacaoPorId(id);
        return localizacao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocalizacao(@PathVariable UUID id) {
        localizacaoService.deletarLocalizacao(id);
        return ResponseEntity.noContent().build();
    }
}
