package br.com.ToCare.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuidadorDTO {
    private UUID id;
    private String nome;
    private String cpfCnpj;
    private Integer idade;
    private String email;
    private String telefone;
    private String descricao;
}
