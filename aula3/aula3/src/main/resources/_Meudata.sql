create table usuario(
   id int primary key auto_increment,
   nome varchar(100) not null,
   email varchar(100) not null,
   senha varchar(100) not null
);
insert into usuario(nome,email,senha) values('Admin','admin@admin.com','123321');