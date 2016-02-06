--drop schema webretail;
create schema webretail;

use webretail;

create table party
(
party_id bigint,
first_name varchar(30),
middle_name varchar(30),
last_name varchar(30),
email varchar(50),
phone varchar(15),
address_id bigint,
created_by bigint,
created_date timestamp,
updated_by bigint,
updated_date timestamp,
record_version_no int,
deleted_yn tinyint,

);

create table user
(
user_id bigint not null auto_increment,
party_id bigint not null,
status varchar(10),
locale_code varchar(5),
reward_points int,
subscribed_for_news_letter_yn tinyint,
created_by bigint,
created_date timestamp,
updated_by bigint,
updated_date timestamp,
record_version_no int,
deleted_yn tinyint,
primary key(user_id)
);
--select * from user
--drop table user;

