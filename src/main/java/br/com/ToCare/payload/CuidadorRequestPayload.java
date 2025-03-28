package br.com.ToCare.payload;

public record CuidadorRequestPayload(
        String nome,
        String cpfCnpj,
        String email,
        String telefone,
        Integer idade,
        String cep) {
}
