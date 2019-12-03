

DROP DATABASE IF EXISTS petShop;
CREATE DATABASE petShop;
USE petShop;
/*创建表*/
CREATE TABLE `petStore`(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	`name` CHAR(10) NULL,
	`password` CHAR(10) NULL,
	`balance` INT(4) NULL
 )ENGINE=INNODB DEFAULT CHARSET=utf8;
 
 CREATE TABLE `petOwner`(
	id INT(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	`name` CHAR(10) NULL,
	`password` CHAR(10) NULL,
	`money` INT(4) NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `pet`(
	id INT(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	`name` CHAR(10) NOT NULL,
	`typeName` CHAR(10) NULL,
	`health` INT(4) NULL,
	`love` INT(4) NULL,
	`birthday` TIMESTAMP NULL,
	`owner_id` INT(4) NULL,
	`store_id` INT(4) NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `account`(
	`id` INT(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	`deal_type` INT(4) NULL,
	`pet_id` INT(4) NULL,
	`seller_id` INT(4) NULL,
	`buyer_id` INT(4) NULL,
	`price` INT(4) NULL,
	`deal_time` TIMESTAMP NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;


/*创建外键*/
ALTER TABLE `account`  ADD  CONSTRAINT fk_account_pet FOREIGN KEY(pet_id) REFERENCES `pet` (`id`);
ALTER TABLE `account`  ADD  CONSTRAINT fk_account_petOwner FOREIGN KEY(seller_id) REFERENCES `petOwner` (`id`);
ALTER TABLE `pet`  ADD  CONSTRAINT fk_pet_petOwner FOREIGN KEY(owner_id) REFERENCES `petOwner` (`id`) ;
ALTER TABLE  `pet`  ADD  CONSTRAINT fk_pet_petStore FOREIGN KEY(store_id) REFERENCES petStore (`id`);


/*插入数据*/
INSERT INTO `petowner` (id, `name`, `passWord`, `money`) VALUES (1, '小明', '123456', 178);
INSERT INTO `petowner` (id, `name`, `passWord`, `money`) VALUES (2, '小强 ', '123456', 498);


INSERT INTO `petstore` (id, `name`, `passWord`,`balance` )VALUES (1, '北京信息中心', '123456    ', 624);
INSERT INTO `petstore` (id, `name`, `passWord`,`balance` ) VALUES (2, '重庆观音桥     ', '123456    ', 800);

INSERT `pet`  (`id`, `name`,`typeName`, `health`, `love`, `birthday`, `owner_id`, `store_id`) VALUES (1, '花花 ', 'dog', 1, 50, '2015-08-20', 1, 1);
INSERT `pet`  (`id`, `name`,`typeName`, `health`, `love`, `birthday`, `owner_id`, `store_id`) VALUES (2, '贝贝', 'penguin', 1, 60, '2015-08-20', NULL, 2);
INSERT `pet`  (`id`, `name`,`typeName`, `health`, `love`, `birthday`, `owner_id`, `store_id`) VALUES (3, '成成','dog', 1, 60,  '2015-09-10', NULL, 1);
INSERT `pet`  (`id`, `name`,`typeName`, `health`, `love`, `birthday`, `owner_id`, `store_id`) VALUES (4, '露露','bird', 1, 70,  '2016-01-10', NULL, 1);
INSERT `pet`  (`id`, `name`,`typeName`, `health`, `love`, `birthday`, `owner_id`, `store_id`) VALUES (5, '老虎','tiger', 1, 2,  '2016-02-10', 2, 1);
INSERT `pet`  (`id`, `name`,`typeName`, `health`, `love`, `birthday`, `owner_id`, `store_id`) VALUES (6, '老虎','tiger', 1, 2,  '2016-3-15', NULL, 1);
INSERT `pet`  (`id`, `name`,`typeName`, `health`, `love`, `birthday`, `owner_id`, `store_id`) VALUES (7, '老虎','tiger', 1, 11,   '2016-2-15', NULL, 1);
INSERT `pet`  (`id`, `name`,`typeName`, `health`, `love`, `birthday`, `owner_id`, `store_id`) VALUES (8, '狮子','lion', 1, 2,   '2016-4-15', NULL, 2);


INSERT `account` (`id`, `deal_type`,`pet_id`, `seller_id`, `buyer_id`, `price`,`deal_time`) VALUES (2, 1, 4, 1, 1, 5, '2016-08-20');
INSERT `account` (`id`, `deal_type`,`pet_id`, `seller_id`, `buyer_id`, `price`,`deal_time`) VALUES (3, 1, 3, 1, 1, 5,'2016-08-20');
INSERT `account` (`id`, `deal_type`,`pet_id`, `seller_id`, `buyer_id`, `price`,`deal_time`) VALUES (4, 1, 3, 1, 1, 5, '2016-09-10');
INSERT `account` (`id`, `deal_type`,`pet_id`, `seller_id`, `buyer_id`, `price`,`deal_time`) VALUES (5, 2, 2, 2, 1, 3,  '2016-09-10');
INSERT `account` (`id`, `deal_type`,`pet_id`, `seller_id`, `buyer_id`, `price`,`deal_time`) VALUES (6, 2, 3, 1, 1, 3, '2016-10-15');

/*创建本地用户epet,密码0000*/
GRANT ALL ON petShop.* TO `epet`@`localhost` IDENTIFIED BY '0000'




