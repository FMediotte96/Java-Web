drop database if exists JavaWeb;

create database JavaWeb;

use JavaWeb;

create table users(
	id int identity(1,1) primary key,
	username varchar(20) not null,
	email varchar(30) not null,
	password varchar(70) not null
);