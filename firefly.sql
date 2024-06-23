create database if not exists firefly;
use firefly;

drop table if exists `user`;

create table `user` (
    id int unsigned primary key auto_increment comment "ID",
    username varchar(20) not null unique comment "username",
    `password` varchar(32) comment "password",
    nickname varchar(10) default "" comment "nickname",
    email varchar(128) default "" comment "email",
    phone varchar(20) default "" comment "phone",
    user_pic varchar(128) default "" comment "user picture",
    create_time datetime not null comment "creation time",
    update_time datetime not null comment "updated time"
) comment "user_table";
