create table clients (
    id varchar not null primary key,
    nome varchar not null,
    cpf varchar not null unique
);