
DROP TABLE IF EXISTS user;

create table `user` (
	`id` bigint auto_increment primary key,
    `name` varchar(50) not null
);
