drop table if exists `test`;

create table `test` (
    `id` bigint not null  comment 'id',
    `name` varchar(50) comment '名称',
    `password` varchar (50) comment '密码',
    primary key (`id`)
)engine=innodb default charset=utf8mb4 comment '测试';

create table `animal` (
                        `id` bigint not null  comment 'id',
                        `animal-name` varchar(50) comment '动物名',
                        `type` varchar (10) comment '动物种类',
                        `age` bigint comment '动物年龄',
                        primary key (`id`)
)engine=innodb default charset=utf8mb4 comment '测试2';

create table `demo` (
                        `id` bigint not null  comment 'id',
                        `name` varchar(50) comment '名称',
                        primary key (`id`)
)engine=innodb default charset=utf8mb4 comment '测试';