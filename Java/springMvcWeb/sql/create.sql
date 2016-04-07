#http://dev.mysql.com/doc/refman/5.7/en/sql-syntax.html
CREATE DATABASE IF NOT EXISTS springMvcWeb DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
CREATE TABLE IF NOT EXISTS `springMvcWeb`.`cat` (
 `id` BIGINT NOT NULL,
 `name` VARCHAR(45),
 `birthday` TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
