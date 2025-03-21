package br.com.ToCare.service;

import br.com.ToCare.dto.CuidadorDTO;
import br.com.ToCare.dto.CuidadorRequest;
import br.com.ToCare.model.Cuidador;
import br.com.ToCare.repository.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CuidadorService {

    @Autowired
    private CuidadorRepository repository;

    public CuidadorDTO criar(CuidadorRequest request) {
        Cuidador cuidador = new Cuidador(null, request.getNome(), request.getCpfCnpj(), request.getIdade(),
                                         request.getEmail(), request.getTelefone(), request.getDescricao(), "cuidador");
        cuidador = repository.save(cuidador);
        return new CuidadorDTO(cuidador.getId(), cuidador.getNome(), cuidador.getCpfCnpj(), cuidador.getIdade(),
                               cuidador.getEmail(), cuidador.getTelefone(), cuidador.getDescricao());
    }

    public CuidadorDTO buscarPorId(UUID id) {
        return repository.findById(id)
                         .map(cuidador -> new CuidadorDTO(cuidador.getId(), cuidador.getNome(), cuidador.getCpfCnpj(),
                                                          cuidador.getIdade(), cuidador.getEmail(), cuidador.getTelefone(),
                                                          cuidador.getDescricao()))
                         .orElseThrow(() -> new RuntimeException("Cuidador não encontrado"));
    }

    public List<CuidadorDTO> listar() {
        return repository.findAll()
                         .stream()
                         .map(cuidador -> new CuidadorDTO(cuidador.getId(), cuidador.getNome(), cuidador.getCpfCnpj(),
                                                          cuidador.getIdade(), cuidador.getEmail(), cuidador.getTelefone(),
                                                          cuidador.getDescricao()))
                         .collect(Collectors.toList());
    }

    public void deletar(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cuidador não encontrado");
        }
        repository.deleteById(id);
    }
}