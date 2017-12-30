create database redesocial;

use redesocial;

create table posts(
    id int auto_increment primary key,
    descricao text not null,
    autor varchar(100)
)