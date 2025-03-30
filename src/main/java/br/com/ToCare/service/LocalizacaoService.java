package br.com.ToCare.service;

import br.com.ToCare.model.Localizacao;
import br.com.ToCare.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
public class LocalizacaoService {

    private static final double EARTH_RADIUS = 6371.0;

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

    public double calcularDistancia(Double lat1, Double lon1, Double lat2, Double lon2) {
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c * 1000; // Distância em metros
    }

    public List<Localizacao> localizarUsuariosProximos(Double latitude, Double longitude) {
        List<Localizacao> todasLocalizacoes = localizacaoRepository.findAll();
        return todasLocalizacoes.stream()
                .filter(localizacao -> calcularDistancia(latitude, longitude, localizacao.getLatitude(), localizacao.getLongitude()) <= 10)
                .toList();
    }

}
