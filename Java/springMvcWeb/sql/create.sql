#http://dev.mysql.com/doc/refman/5.7/en/sql-syntax.html
#create db
CREATE DATABASE IF NOT EXISTS springMvcWeb DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

#drop tables, reverse order to create
DROP TABLE `springMvcWeb`.`labarContract`;
DROP TABLE `springMvcWeb`.`pay`;
DROP TABLE `springMvcWeb`.`employee`;
DROP TABLE `springMvcWeb`.`position`;
DROP TABLE `springMvcWeb`.`department`;

#create tables
CREATE TABLE IF NOT EXISTS `springMvcWeb`.`department` (
 `id` INT NOT NULL UNIQUE,
 `name` VARCHAR(30) NOT NULL,
 `pId` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`pId`) REFERENCES `springMvcWeb`.`department`(`id`)
      ON DELETE RESTRICT
      ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `springMvcWeb`.`position` (
 `id` INT NOT NULL UNIQUE,
 `title` VARCHAR(10) NOT NULL,
 `level` INT NOT NULL,
 `departId` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`departId`) REFERENCES `springMvcWeb`.`department`(`id`)
      ON DELETE SET NULL
      ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `springMvcWeb`.`employee` (
 `id` VARCHAR(40) NOT NULL UNIQUE,
 `name` VARCHAR(10) NOT NULL,
 `pw` VARCHAR(20) NOT NULL,
 `gender` int NOT NULL,
 `birthday` BIGINT,
 `idcard` VARCHAR(30) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `springMvcWeb`.`pay` (
 `id` BIGINT NOT NULL UNIQUE,
 `type` INT NOT NULL,
 `unit` INT,
 `amount` INT,
 `account` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `springMvcWeb`.`labarContract` (
 `id` BIGINT NOT NULL UNIQUE,
 `eid` VARCHAR(40) NOT NULL,
 `bossId` VARCHAR(40),
 `position` INT,
 `create` BIGINT NOT NULL,
 `from` BIGINT NOT NULL,
 `end` BIGINT NOT NULL,
 `payId` BIGINT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`eid`) REFERENCES `springMvcWeb`.`employee`(`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  FOREIGN KEY (`payId`) REFERENCES `springMvcWeb`.`pay`(`id`)
      ON DELETE SET NULL
      ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
