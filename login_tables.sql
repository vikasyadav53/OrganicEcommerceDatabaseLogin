create table user_type (
role_id int identity(1,1) primary key,
user_role varchar(50) not null unique,
user_action varchar(400) not null
);

create table user_table (
id int identity(1,1) primary key, 
user_role varchar(50),
user_email varchar(50) not null unique, 
user_pwd varchar(50) not null,
creation_date date,
updation_date date,
is_active bit default 1,
is_lock bit default 0,
constraint fk_user_type 
foreign key (user_role) references user_type(user_role)
);

create table address_table (
address_id int identity(1,1) primary key,
address1 varchar (100),
address2 varchar(100),
city varchar (20),
state varchar(20),
zip_code varchar (15),
country varchar (20)
);

create table contact_table(
contact_id int identity(1,1) primary key, 
email_id varchar(25) not null,
phone_no varchar(15) not null,
);

create table contact_TO_Add(
id int identity(1,1),
contact_id int not null unique,
address_id int not null,
primary key (contact_id, address_id)
);

alter table user_table add contact_id int foreign key references contact_table(contact_id);