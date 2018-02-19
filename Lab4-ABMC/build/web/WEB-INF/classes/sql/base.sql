DROP DATABASE IF EXISTS j2eeWeb;
CREATE DATABASE j2eeWeb;
USE j2eeWeb;
CREATE TABLE alumnos(
    alumno_id int(10) unsigned auto_increment primary key,
    nombre varchar(45) not null default "",
    apellido varchar(45) not null default ""
);

select * from alumnos;