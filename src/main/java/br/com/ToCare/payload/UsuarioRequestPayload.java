package br.com.ToCare.payload;

public record UsuarioRequestPayload(
        String nome,
        String cpfCnpj,
        String email,
        String telefone,
        Integer idade,
        String cep,
        Double latitude,
        Double longitude) {
}
