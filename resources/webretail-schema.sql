--drop schema webretail;
create schema webretail;

use webretail;

--drop table party;
create table party
(
party_id bigint auto_increment,
first_name varchar(30),
middle_name varchar(30),
last_name varchar(30),
email varchar(50) not null,
phone varchar(15),
address_id bigint,
created_by bigint not null,
created_date timestamp not null,
updated_by bigint not null,
updated_date timestamp not null,
record_version_no int not null,
deleted_yn tinyint not null,
primary key(party_id)

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
primary key(user_id)
);
--select * from user


