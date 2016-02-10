--drop schema webretail;
create schema webretail;

use webretail;

--drop table address;
create table address
(
address_id bigint auto_increment,
address_line1 varchar(30),
address_line2 varchar(30),
landmark varchar(30),
city varchar(30),
zip_code varchar(6),
state varchar(30),
country varchar(30),
created_by bigint not null,
created_date timestamp not null,
updated_by bigint not null,
updated_date timestamp not null,
record_version_no int not null,
deleted_yn tinyint not null,
primary key(address_id)
);

--drop table party;
create table party
(
party_id bigint auto_increment,
first_name varchar(30),
middle_name varchar(30),
last_name varchar(30),
email varchar(50),
home_phone_number varchar(15),
business_phone_number varchar(15),
cell_phone_number varchar(15),
address_id bigint,
gender varchar(1),
date_of_birth Date,
created_by bigint not null,
created_date timestamp not null,
updated_by bigint not null,
updated_date timestamp not null,
record_version_no int not null,
deleted_yn tinyint not null,
primary key(party_id),
index party_address_id_idx (address_id),
foreign key (address_id) 
  references address(address_id)
  on delete cascade
);
--select * from party

--drop table user;
create table user
(
user_id bigint auto_increment,
party_id bigint not null,
status varchar(10) not null,
locale_code varchar(5) not null,
reward_points int,
subscribed_for_news_letter_yn tinyint,
created_by bigint not null,
created_date timestamp not null,
updated_by bigint not null,
updated_date timestamp not null,
record_version_no int not null,
deleted_yn tinyint not null,
primary key(user_id),
index user_party_id_idx (party_id),
foreign key (party_id) 
  references party(party_id)
  on delete cascade
);
--select * from user


