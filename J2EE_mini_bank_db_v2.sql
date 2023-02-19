create database mini_bank_db_v2;
use mini_bank_db_v2;
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
insert into tbl_customer values
(1,'U Ba Win','12/XXXXXX(N)111111','1999-10-25','U Win','xxxxxx',
'BAWIN1999','12345'),
(2,'Su Su Hlaing','12/XXXXXX(N)111111','2000-04-12','U Hlaing','xxxxxx',
'SUSU1999','12345');

create table tbl_account_type(
	type_id int primary key auto_increment,
    type_name varchar(10));
insert into tbl_account_type values(1,'Saving'),(2,'Current'),(3,'Call');

create table tbl_account(
	acc_no varchar(10) primary key,
    cust_id int,
	type_id int,    
	acc_open_date date,
	acc_status tinyint(1),
	acc_balance bigint,	
	foreign key(cust_id) references tbl_customer(cust_id),
    foreign key(type_id) references tbl_account_type(type_id)
);
#one customer has many accounts
#one account has owned by one customer
insert into tbl_account values
('0000000001',1,1,'2000-11-25',1,5000000),
('0000000002',1,3,'2022-05-12',1,1000000),
('0000000003',2,1,'1999-08-12',1,3000000),
('0000000004',2,2,'2000-01-23',1,2000000),
('0000000005',2,3,'2022-01-12',1,50000);

create table tbl_transaction(
	tran_id int primary key auto_increment,
    tran_acc_no varchar(10),
    tran_amount bigint,
    tran_type enum('withdraw','deposit'),
    tran_date datetime default now(),
    foreign key(tran_acc_no) references tbl_account(acc_no)
);

insert into tbl_transaction
values(null,'0000000001',30000,'withdraw','2022-06-13 10:00:00'),
(null,'0000000002',30000,'deposit','2022-06-13 10:00:00');