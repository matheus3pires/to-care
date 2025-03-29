CREATE TABLE localizacao
(
    id UUID NOT NULL,
    latitude DECIMAL(9,6) NOT NULL,
    longitude DECIMAL(9,6) NOT NULL,

    CONSTRAINT localizacao_pkey PRIMARY KEY (id),
    CONSTRAINT fk_localizacao_usuario FOREIGN KEY (id) REFERENCES usuario (id) ON DELETE CASCADE,
    CONSTRAINT fk_localizacao_cuidador FOREIGN KEY (id) REFERENCES cuidador (id) ON DELETE CASCADE
);
