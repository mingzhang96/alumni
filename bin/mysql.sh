create database alumni CHARACTER SET utf8 COLLATE utf8_general_ci;

use alumni;

create table t_user
(
   id int auto_increment PRIMARY KEY,
   password varchar(100),
   name varchar(50),
   qq varchar(100),
   phone varchar(100),
   wechat varchar(100),
   mail varchar(100),
   address varchar(100),
   motto varchar(100),
   xm varchar(100),
   create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   finish_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   is_deleted int default 0
);


CREATE TABLE t_school
(
   id int auto_increment PRIMARY KEY,
   city varchar(50),
   name varchar(100),
   create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   finish_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   is_deleted int default 0
);


CREATE TABLE t_grade
(
   id int auto_increment PRIMARY KEY,
   school_id int,
   in_year int,
   class_number int,
   manager_id int,
   notice varchar(2000),
   create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   finish_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   is_deleted int default 0
);


CREATE TABLE t_relation
(
   id int auto_increment PRIMARY KEY,
   user_id int,
   school_id int,
   grade_id int,
   create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   finish_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   is_deleted int default 0
);


insert into t_user(name, password, qq, phone, wechat, mail, address, motto) values("sihong", "123456", "1110101101", "13800138000", "wangsihong.wechat", "wangsihong@qq.com", "wangsihongjia", "sb");
insert into t_user(name, password, qq, phone, wechat, mail, address, motto) values("sihong2", "123456", "1110101101", "13800138000", "wangsihong.wechat", "wangsihong@qq.com", "wangsihongjia", "sb");
insert into t_user(name, password, qq, phone, wechat, mail, address, motto) values("sihong3", "123456", "1110101101", "13800138000", "wangsihong.wechat", "wangsihong@qq.com", "wangsihongjia", "sb");
insert into t_user(name, password, qq, phone, wechat, mail, address, motto) values("sihong4", "123456", "1110101101", "13800138000", "wangsihong.wechat", "wangsihong@qq.com", "wangsihongjia", "sb");
insert into t_user(name, password, qq, phone, wechat, mail, address, motto) values("sihong5", "123456", "1110101101", "13800138000", "wangsihong.wechat", "wangsihong@qq.com", "wangsihongjia", "sb");

insert into t_school(city, name) values("深圳", "深圳大学");
insert into t_school(city, name) values("广州", "广州大学");
insert into t_school(city, name) values("北京", "北京大学");
insert into t_school(city, name) values("广州", "中山大学");
insert into t_school(city, name) values("广州", "南方医科大学");

insert into t_grade(school_id, in_year, class_number) values(1, 2014, 1);
insert into t_grade(school_id, in_year, class_number) values(1, 2014, 2);
insert into t_grade(school_id, in_year, class_number) values(1, 2014, 3);
insert into t_grade(school_id, in_year, class_number) values(2, 2012, 1);
insert into t_grade(school_id, in_year, class_number) values(3, 2013, 1);

insert into t_relation(user_id, school_id, grade_id) values(1, 1, 1);
insert into t_relation(user_id, school_id, grade_id) values(1, 1, 2);
insert into t_relation(user_id, school_id, grade_id) values(1, 1, 3);
insert into t_relation(user_id, school_id, grade_id) values(2, 1, 1);
insert into t_relation(user_id, school_id, grade_id) values(3, 1, 1);
insert into t_relation(user_id, school_id, grade_id) values(4, 2, 4);
insert into t_relation(user_id, school_id, grade_id) values(5, 3, 5);


CREATE TABLE t_message
(
   id int auto_increment PRIMARY KEY,
   user_id int,
   grade_id int,
   message varchar(2000),
   create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   finish_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   is_deleted int default 0
);



