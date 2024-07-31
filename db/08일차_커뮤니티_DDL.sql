DROP DATABASE IF EXISTS COMMUNITY;

CREATE DATABASE COMMUNITY;

USE COMMUNITY;


DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13)  primary key	NOT NULL,
	`me_pw`	varchar(255)			NOT NULL,
	`me_email`	varchar(50) unique	NOT NULL,
	`me_authority`	varchar(5)		NOT NULL DEFAULT 'USER',
	`me_fail`	int					NOT NULL DEFAULT 0,
	`me_cookie`	varchar(255)		NULL,
	`me_limit`	datetime			NULL,
	`me_report`	int					NOT NULL DEFAULT 0,
	`me_ms_name`	varchar(10)		NOT NULL,
	`me_stop`	datetime			NULL
);

DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
	`co_num`	int primary key auto_increment	NOT NULL,
	`co_name`	varchar(50) unique	NULL
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
	`po_num`	int primary key auto_increment	NOT NULL,
	`po_title`	varchar(50)		NOT NULL,
	`po_content`	longtext	NOT NULL,
	`po_me_id`	varchar(13)		NOT NULL,
	`po_co_num`	int				NOT NULL,
	`po_date`	datetime		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`po_view`	int				NOT NULL DEFAULT 0,
	`po_report`	int				NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int primary key auto_increment	NOT NULL,
	`fi_ori_name`	varchar(255)NOT NULL,
	`fi_name`	varchar(255)	NOT NULL,
	`fi_po_num`	int				NOT NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`cm_num`	int  primary key	NOT NULL,
	`cm_content`varchar(200)		NOT NULL,
	`cm_po_num`	int					NOT NULL,
	`cm_ori_num`int					NOT NULL,
	`cm_date`	datetime			NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`cm_me_id`	varchar(13)			NOT NULL,
	`cm_report`	int					NOT NULL DEFAULT 0,
	`cm_state`	int					NOT NULL DEFAULT 0 # 0:삭제 안됨, 1:작성자가 삭제,2:관리자에 의해 삭제
);

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
	`re_num`	int primary key auto_increment	NOT NULL,
	`re_state`	int								NOT NULL,
	`re_po_num`	int								NOT NULL,
	`re_me_id`	varchar(13)						NOT NULL
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
	`rp_num`	int primary key auto_increment	NOT NULL,
	`rp_me_id`	varchar(13)						NOT NULL,
	`rp_table`	varchar(10)						NOT NULL,
	`rp_target`	int								NOT NULL,
	`rp_rt_name`	varchar(15)						NOT NULL
);

DROP TABLE IF EXISTS `reprot_type`;

CREATE TABLE `reprot_type` (
	`rt_name`	varchar(15)  primary key	NOT NULL
);

DROP TABLE IF EXISTS `member_state`;

CREATE TABLE `member_state` (
	`ms_name`	varchar(10) primary key	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (
	`me_ms_name`
)
REFERENCES `member_state` (
	`ms_name`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_community_TO_post_1` FOREIGN KEY (
	`po_co_num`
)
REFERENCES `community` (
	`co_num`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_post_TO_file_1` FOREIGN KEY (
	`fi_po_num`
)
REFERENCES `post` (
	`po_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_post_TO_comment_1` FOREIGN KEY (
	`cm_po_num`
)
REFERENCES `post` (
	`po_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`cm_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_post_TO_recommend_1` FOREIGN KEY (
	`re_po_num`
)
REFERENCES `post` (
	`po_num`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_member_TO_recommend_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (
	`rp_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_reprot_type_TO_report_1` FOREIGN KEY (
	`rp_rt_name`
)
REFERENCES `reprot_type` (
	`rt_name`
);

ALTER TABLE `community`.`post` DROP FOREIGN KEY `FK_community_TO_post_1`;
ALTER TABLE `community`.`post` 
ADD CONSTRAINT `FK_community_TO_post_1`
  FOREIGN KEY (`po_co_num`)
  REFERENCES `community`.`community` (`co_num`)
  ON DELETE CASCADE
  ON UPDATE RESTRICT;

ALTER TABLE `community`.`recommend` 
DROP FOREIGN KEY `FK_post_TO_recommend_1`;
ALTER TABLE `community`.`recommend` 
ADD CONSTRAINT `FK_post_TO_recommend_1`
  FOREIGN KEY (`re_po_num`)
  REFERENCES `community`.`post` (`po_num`)
  ON DELETE CASCADE;

ALTER TABLE `community`.`file` 
DROP FOREIGN KEY `FK_post_TO_file_1`;
ALTER TABLE `community`.`file` 
ADD CONSTRAINT `FK_post_TO_file_1`
  FOREIGN KEY (`fi_po_num`)
  REFERENCES `community`.`post` (`po_num`)
  ON DELETE CASCADE;
  
ALTER TABLE `community`.`comment` 
DROP FOREIGN KEY `FK_post_TO_comment_1`;
ALTER TABLE `community`.`comment` 
ADD CONSTRAINT `FK_post_TO_comment_1`
  FOREIGN KEY (`cm_po_num`)
  REFERENCES `community`.`post` (`po_num`)
  ON DELETE CASCADE;
