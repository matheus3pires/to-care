package br.com.ToCare.payload;

import java.time.LocalDate;

public record ContratoRequestPayload(
        String usuarioId,
        String cuidadorId,
        LocalDate dataInicioContrato,
        LocalDate dataFimContrato,
        Integer notaAvaliacao,
        String comentario) {
}
