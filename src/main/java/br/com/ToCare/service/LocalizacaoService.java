package br.com.ToCare.service;

import br.com.ToCare.model.Localizacao;
import br.com.ToCare.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public Localizacao salvarLocalizacao(Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    public Optional<Localizacao> buscarLocalizacaoPorId(UUID id) {
        return localizacaoRepository.findById(id);
    }

    public void deletarLocalizacao(UUID id) {
        localizacaoRepository.deleteById(id);
    }
}
