use JavaWeb;

create table alumnos(
	alumno_id int identity(1,1) primary key,
	nombre varchar(45) not null,
	apellido varchar(45) not null 
)

select * from alumnos;