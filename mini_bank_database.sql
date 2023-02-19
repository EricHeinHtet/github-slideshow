create database mini_bank_db_v1;
use mini_bank_db_v1;
drop table tbl_customer;
create table tbl_customer(
	cust_id int not null primary key auto_increment,
	cust_name varchar(45),
	cust_nrc varchar(45),
	cust_dob date,
	cust_father_name varchar(45),
	cust_phone varchar(20),
	cust_uname varchar(30) unique,
	cust_pass varchar(150)
);
create table tbl_account(
	acc_no int primary key auto_increment,
	acc_type enum('Saving','Current','Call'),
	acc_open_date date,
	acc_status enum('active','closed'),
	acc_balance bigint,
	cust_id int,
	foreign key(cust_id) 
	references tbl_customer(cust_id)
);

#one customer has many accounts
#one account has owned by one customer
insert into tbl_account values
(null,'Saving','2000-11-25','active',5000000,1),
(null,'Call','2022-05-12','active',1000000,1),
(null,'Saving','1999-08-12','active',3000000,2),
(null,'Current','2000-01-23','active',2000000,2),
(null,'Call','2022-01-12','active',50000,2);

insert into tbl_customer values
(1,'U Ba Win','12/XXXXXX(N)111111','1999-10-25','U Win','xxxxxx',
'BAWIN1999',md5('12345')),
(2,'Su Su Hlaing','12/XXXXXX(N)111111','2000-04-12','U Hlaing','xxxxxx',
'SUSU1999',md5('12345'));


















