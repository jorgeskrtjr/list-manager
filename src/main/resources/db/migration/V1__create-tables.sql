CREATE TABLE task_list (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT
);

CREATE TABLE task (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    data_criacao TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    data_conclusao TIMESTAMPTZ,
    concluida BOOLEAN DEFAULT FALSE,
    task_list_id BIGINT,
    CONSTRAINT fk_task_list
        FOREIGN KEY (task_list_id)
        REFERENCES task_list(id)
        ON DELETE CASCADE
);
