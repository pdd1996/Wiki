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

drop table if exists `ebook`;

create table `ebook`(
    `id` bigint not null  comment 'id',
    `book_name` varchar(50) comment '书名',
    `category_1` bigint comment '分类1',
    `category_2` bigint comment '分类2',
    `book_desc` varchar(50) comment '书的描述',
    `book_cover` varchar(50) comment '书的封面',
    `doc_count` bigint comment '文档数',
    `view_count` bigint comment '访问人数',
    `like_count` bigint comment '点赞数',
    primary key(`id`)
)engine=innodb default charset=utf8mb4 comment 'EBook';

insert into `ebook`(id, book_name, book_desc) values (1, 'JavaScript高级程序设计', 'js必备');

insert into `ebook`(id, book_name, book_desc) values (2, 'Java高级程序设计', 'java必备');