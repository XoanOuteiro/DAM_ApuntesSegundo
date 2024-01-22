drop database if exists LibrosAutoresHibernate;
create database LibrosAutoresHibernate;
use LibrosAutoresHibernate;

create table Autores (
	DniAutor char(9) primary key,
    Nombre varchar(25) not null,
    Nacionalidad varchar(25) not null,
    telefono char(9) null
) engine=Innodb ;

create table Libros (
	IdLibro int primary key auto_increment,
    Titulo varchar(25) not null,
    Precio float not null,
    Autor char(9) not null,
    FOREIGN KEY (Autor) REFERENCES Autores (DniAutor) ON DELETE restrict ON UPDATE cascade
) engine=Innodb ;