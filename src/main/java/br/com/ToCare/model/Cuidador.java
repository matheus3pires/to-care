package br.com.ToCare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "pessoa",
       uniqueConstraints = {
           @UniqueConstraint(name = "unique_cpf_tipo", columnNames = {"cpf_cnpj", "identifica_cadastro"}),
           @UniqueConstraint(name = "unique_email_tipo", columnNames = {"email", "identifica_cadastro"})
       })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuidador {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    @Size(max = 255)
    private String nome;

    @NotBlank
    @Size(max = 20)
    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;

    @NotNull
    private Integer idade;

    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 20)
    private String telefone;

    @Size(max = 500)
    private String descricao;

    @NotBlank
    @Size(max = 20)
    @Column(name = "identifica_cadastro")
    private String identificaCadastro;

    @PrePersist
    @PreUpdate
    private void validarIdentificacao() {
        if (!identificaCadastro.equals("cuidador")) {
            throw new IllegalArgumentException("O campo identificaCadastro deve ser 'cuidador'.");
        }
    }
}