CREATE TABLE users(
id int primary key auto_increment,
username varchar(75) unique not null,
email varchar(150) unique not null,
password varchar(150) not null,
firstname varchar(75) not null,
lastname varchar(75) not null,
is_active boolean,
created_at date,
updated_at date);