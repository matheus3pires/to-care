CREATE TABLE cuidador
(
    id UUID NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf_cnpj VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    idade INTEGER NOT NULL,
    cep VARCHAR(8) NOT NULL,

    CONSTRAINT cuidador_pkey PRIMARY KEY (id),
    CONSTRAINT unique_cpf_cuidador UNIQUE (cpf_cnpj)
);
