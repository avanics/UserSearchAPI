create table users_api.users
(
id INT(11) UNSIGNED AUTO_INCREMENT,
user_name VARCHAR(200) , 
date_joined DATE,
PRIMARY KEY(id)
);
drop table users_api.users;
truncate table users;
insert into users (user_name , date_joined )values ('Avani' , '2010-09-12');
insert into users (user_name , date_joined )values ('Priya' , '2015-01-13');
insert into users (user_name , date_joined )values ('Chirag' , '2014-06-05');
insert into users (user_name , date_joined )values ('Shivani' , '2009-08-07');
insert into users (user_name , date_joined )values ('Dhruvi' , '2011-07-04');
commit;


GRANT ALL PRIVILEGES ON *.* TO 'root@localhost' IDENTIFIED BY 'avani123' WITH GRANT OPTION;

 FLUSH PRIVILEGES;


