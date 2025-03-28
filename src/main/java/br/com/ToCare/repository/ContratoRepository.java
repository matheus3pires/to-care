package br.com.ToCare.repository;

import br.com.ToCare.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, UUID> {
    List<Contrato> findByUsuarioId(UUID usuarioId);
    List<Contrato> findByCuidadorId(UUID cuidadorId);
}
