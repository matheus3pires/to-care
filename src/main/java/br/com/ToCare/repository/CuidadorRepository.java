package br.com.ToCare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ToCare.model.Cuidador;
import java.util.Optional;
import java.util.UUID;

public interface CuidadorRepository extends JpaRepository<Cuidador, UUID> {
    Optional<Cuidador> findByCpfCnpj(String cpfCnpj);
    Optional<Cuidador> findByEmail(String email);
}
