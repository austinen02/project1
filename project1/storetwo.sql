use austinen02;

 drop table if exists project;
 
create table project (
 projId int unsigned not null auto_increment,
 buildingType varchar(35) not null,
 priceEst decimal(8,2) not null,
 dateStarted varchar(255)  not null,
 dateCompleted varchar(255) null,
 custId int unsigned not null,
 primary key (projId));
 
drop table if exists tasks;
 
create table tasks (
 taskId int unsigned not null auto_increment,
 contractorId int unsigned not null,
 projId int unsigned not null,
 price decimal(8,2) not null, 
primary key (taskId));
 
drop table if exists contractor;
 
create table contractor (
 contractorId int unsigned not null auto_increment,
 name varchar(255) not null,
 conPhone varchar(20) not null,
 primary key (contractorId));
 
drop table if exists customer;
 
create table customer (
 custId int unsigned not null auto_increment,
 firstName varchar(30) not null,
 lastName varchar(30) not null,
 phone varchar(20) null,
 primary key (custId));
 
insert into customer values ( 1, 'Jane', 'Doe', '570-662-1111' );
 insert into customer values ( 2, 'John', 'Smith', '570-662-2222' );
 insert into contractor values (1, 'Bill', '570-222-2222');
 insert into contractor values (2, 'Rob', '570-111-1111');
 insert into contractor values (3, 'Joe', '570-333-3333');
 insert into project values (1, 'House', 300000.00, '2012-07-25 14:52:41', '09/10/12', 1);
 insert into tasks values (1, 1, 1, 50000.00);
 insert into project values (2, 'Garage', 50000.00,'2012-11-08 12:45:00', 'null',  2);
 insert into tasks values (2, 2, 2, 5000.00);
 insert into project values (3, 'House', 275000.00, '2012-10-22 10:32:42', 'null', 2);
 insert into tasks values (3, 3, 3, 15000.00);
