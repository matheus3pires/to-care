package br.com.ToCare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "cuidador", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cpf_cnpj")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuidador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 20, unique = true)
    private String cpfCnpj;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, length = 8)
    private String cep;
}