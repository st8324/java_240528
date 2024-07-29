
DROP DATABASE IF EXISTS SHOPPINGMALL;

CREATE DATABASE SHOPPINGMALL;

USE SHOPPINGMALL;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca_num`	int primary key auto_increment	NOT NULL,
	`ca_name`	varchar(10)	NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pr_code`	varchar(10) primary key	NOT NULL,
	`pr_name`	varchar(50)	NULL,
	`pr_content`	longtext	NULL,
	`pr_price`	int	NULL,
	`pr_ca_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `product_image`;

CREATE TABLE `product_image` (
	`pi_num`	int primary key auto_increment	NOT NULL,
	`pi_name`	varchar(150)	NULL,
	`pi_pr_code`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13)  primary key	NOT NULL,
	`me_pw`	varchar(20)	NULL,
	`me_email`	varchar(50)	NULL,
	`me_phone`	varchar(15)	NULL,
	`me_authority`	varchar(5)	NULL,
	`me_fail`	int	NULL
);

DROP TABLE IF EXISTS `code`;

CREATE TABLE `code` (
	`co_me_id`	varchar(13) primary key	NOT NULL,
	`co_code`	char(6)	NULL,
	`co_limit`	datetime	NULL
);

DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`ba_num`	int primary key auto_increment	NOT NULL,
	`ba_pr_code`	varchar(10)	NOT NULL,
	`ba_me_id`	varchar(13)	NOT NULL,
	`ba_amount`	int	NULL
);

DROP TABLE IF EXISTS `buy`;

CREATE TABLE `buy` (
	`bu_num`	int primary key auto_increment	NOT NULL,
	`bu_pr_code`	varchar(10)	NOT NULL,
	`bu_me_id`	varchar(13)	NOT NULL,
	`bu_amount`	int	NULL,
	`bu_state`	varchar(10)	NULL,
	`bu_date`	datetime	NULL
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`pr_ca_num`
)
REFERENCES `category` (
	`ca_num`
);

ALTER TABLE `product_image` ADD CONSTRAINT `FK_product_TO_product_image_1` FOREIGN KEY (
	`pi_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `code` ADD CONSTRAINT `FK_member_TO_code_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_product_TO_basket_1` FOREIGN KEY (
	`ba_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_member_TO_basket_1` FOREIGN KEY (
	`ba_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_product_TO_buy_1` FOREIGN KEY (
	`bu_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `buy` ADD CONSTRAINT `FK_member_TO_buy_1` FOREIGN KEY (
	`bu_me_id`
)
REFERENCES `member` (
	`me_id`
);

