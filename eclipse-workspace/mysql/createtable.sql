#创建表的练习
-- 字段 属性
-- id   整型
-- name 字符型
-- sex 字符型
-- birthday  日期型date
-- entry_date 日期型date
-- job 字符型
-- salary 小数型
-- resume 文本型
CREATE TABLE `emp`(
   id INT ,
   `name` VARCHAR(32),
   sex CHAR(1),
   birthday DATE,
   entry_date DATETIME,
   job VARCHAR(32),
   salary DOUBLE,
   `resume` TEXT) CHARSET utf8 COLLATE utf8_bin ENGINE INNODB;
INSERT INTO `emp` 
     VALUES(100,'小妖怪','男','2000-11-1',
     '2010-11-10 11:11:11','巡山的',3000,'大王叫我来巡山');
SELECT * FROM `emp`
DROP TABLE `emp`