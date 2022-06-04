Create table  `user`(
                           `id` int  not null primary key auto_increment,
                           `username` varchar(50),
                           `password` varchar(100)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;