package br.com.ToCare.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuidadorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpfCnpj;

    @NotNull
    private Integer idade;

    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    private String descricao;
}