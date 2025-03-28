package br.com.ToCare.repository;

import br.com.ToCare.model.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, UUID> {
    Cuidador findByCpfCnpj(String cpfCnpj);
}
