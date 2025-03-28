CREATE TABLE contrato
(
    id UUID NOT NULL,
    usuario_id UUID NOT NULL,
    cuidador_id UUID NOT NULL,
    data_inicio_contrato DATE NOT NULL,
    data_fim_contrato DATE,
    nota_avaliacao INTEGER,
    comentario TEXT,

    CONSTRAINT contrato_pkey PRIMARY KEY (id),
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE,
    CONSTRAINT fk_cuidador FOREIGN KEY (cuidador_id) REFERENCES cuidador(id) ON DELETE CASCADE
);
