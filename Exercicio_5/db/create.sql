drop database if exists ListaTelefonica;

create database ListaTelefonica;

use ListaTelefonica;

create table Pessoa(id bigint not null auto_increment, nome varchar(256) not null, telefone varchar(15) not null, estado varchar(2) not null, cidade varchar(50) not null, ocupacao varchar(50) not null, primary key (id));


insert into Pessoa(nome, telefone, estado, cidade, ocupacao) values  ('Gabriel', '(11) 91111-2222', 'SP', 'São Carlos', 'Desempregado');
insert into Pessoa(nome, telefone, estado, cidade, ocupacao) values  ('Lucas', '(15) 93333-4444', 'PR', 'Curitiba', 'Soldador');
insert into Pessoa(nome, telefone, estado, cidade, ocupacao) values  ('Roselina', '(19) 95555-6666', 'MA', 'São Luis', 'Floricultora');