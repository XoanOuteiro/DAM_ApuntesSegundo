drop database if exists LibrosAutoresHibernate;
create database LibrosAutoresHibernate;
use LibrosAutoresHibernate;

create table Autores (
	DniAutor char(9) primary key,
    Nombre varchar(25) not null,
    Nacionalidad varchar(25) not null
) engine=Innodb ;

create table Libros (
	IdLibro int primary key auto_increment,
    Titulo varchar(25) not null,
    Precio float not null,
    Autor char(9) not null,
    FOREIGN KEY (Autor) REFERENCES Autores (DniAutor) ON DELETE restrict ON UPDATE cascade
) engine=Innodb ;

create table Telefonos (
	DniAutor char(9),
    telefono char(9),
    foreign key (DniAutor) references autores(DniAutor)
    on delete cascade on update cascade,
	primary key (DniAutor, telefono)
)engine = Innodb;