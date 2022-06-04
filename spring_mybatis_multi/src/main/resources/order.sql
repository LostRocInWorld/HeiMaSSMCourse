-- 創建orders表
CREATE TABLE `orders` (
                            `id` int NOT NULL ,
                            `ordertime` varchar(255) DEFAULT NULL,
                            `total` double DEFAULT 0,
                            `uid` int,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 插入测试用的数据
insert into `orders` values(null,'2015-06-05 12:00:21','2000',1);
insert into `orders` values(null,'2018-08-02 22:00:21','3000',1);
insert into `orders` values(null,'2019-03-04 10:00:34','1000',2);
insert into `orders` values(null,'2020-07-09 12:00:21','50000',3);
insert into `orders` values(null,'2021-09-01 12:00:21','60000',3);
insert into `orders` values(null,'2021-05-03 12:00:21','200',3);
insert into `orders` values(null,'2019-03-03 12:00:21','3765',6);