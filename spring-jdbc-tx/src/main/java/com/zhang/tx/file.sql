create table t_book
(
    'book_id'   INT(11) not null auto_increment COMMENT 'master key',
    'book_name' VARCHAR(20)      default null comment 'book name',
    'price'     int(11)          default null comment 'price',
    `stock`     int(10) unsigned default null comment 'stock',
    primary key (book_id)
) engine = innodb auto_increment = 3  default charset = utf8;

create table `t_user`(
        `user_id` int not null  auto_increment comment 'primary key',
        `username` varchar(20) default null comment 'user_name',
        `balance` int unsigned default  null comment 'money',
        primary key (user_id)
) engine = innodb auto_increment=2 default charset = utf8;

insert into t_book values (1,'java teac',20,100),(2,'c++ teac',25,200);

