


create database bank;
use bank;

create table bank.ACCOUNTS(
num varchar(12),
name varchar(1000),
balance double,
acc_type varchar(25)
);

insert into bank.ACCOUNTS values(1,'Nag',1000.00,'SAVING');
insert into bank.ACCOUNTS values(2,'Ria',1000.00,'SAVING');


select * from bank.accounts;