CREATE TABLE funcionario (
    rowid bigint auto_increment primary key, 
    nm_funcionario VARCHAR(255) not null
);

INSERT INTO funcionario (nm_funcionario) 
VALUES ('João'), ('Maria'), ('José'), ('Joana');

CREATE TABLE agenda (
    rowid bigint auto_increment primary key,
    nm_agenda VARCHAR(255) NOT NULL,
    periodo ENUM('MANHA', 'TARDE', 'AMBOS') NOT NULL
);

INSERT INTO agenda (nm_agenda, periodo)
VALUES 
    ('Ana Costa', 'AMBOS'), 
    ('Vila Belmiro', 'MANHA'),
    ('Ponta da Praia', 'TARDE'),
    ('Macuco', 'MANHA');

CREATE TABLE compromisso (
    rowid bigint auto_increment PRIMARY KEY,
    funcionario_id bigint NOT NULL,
    agenda_id bigint NOT NULL,
    data DATE NOT NULL,
    horario TIME NOT NULL,
    FOREIGN KEY (funcionario_id) REFERENCES funcionario(rowid) ON DELETE CASCADE,
    FOREIGN KEY (agenda_id) REFERENCES agenda(rowid)
);

INSERT INTO compromisso (funcionario_id, agenda_id, data, horario)
VALUES 
    (1, 1, '2025-09-08', '10:30:00'),
    (1, 2, '2025-09-09', '09:00:00'),
    (2, 3, '2025-09-10', '15:45:00'),
    (2, 4, '2025-09-11', '11:15:00'),
    (3, 1, '2025-09-12', '14:00:00'),
    (4, 3, '2025-09-15', '16:00:00');