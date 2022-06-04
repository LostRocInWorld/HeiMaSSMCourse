CREATE TABLE `role` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `roleName` varchar(50) DEFAULT NULL,
                            `roleDesc` varchar(50) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
insert  into `role`(`id`,`roleName`,`roleDesc`) values (1,'院长','负责全面工作'),(2,'研究员','课程研发工作'),(3,'讲师','授课工作'),(4,'助教','协助解决学生的问题');

CREATE TABLE `user_role` (
                                 `userId` bigint(20) NOT NULL,
                                 `roleId` bigint(20) NOT NULL,
                                 PRIMARY KEY (`userId`,`roleId`)
                                --外鍵衝突沒有添加
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `user_role`(`userId`,`roleId`) values (1,1),(1,2),(2,2),(2,3);