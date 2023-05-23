-- 演示加密函数和系统函数

-- uesr() 查询用户
-- 可以查看登录到mysql的有哪些用户，以及登录的IP
SELECT USER() FROM DUAL; -- 用户@IP地址
-- database()  查询当前使用数据库名称
SELECT DATABASE() FROM DUAL;
-- md5(str)  为字符串算出一个md5 32的字符串，常用(用户密码)密码
-- 加密md5 在数据库中存放的是加密后的密码
SELECT MD5('123456') FROM DUAL;
SELECT LENGTH(MD5('123456')) FROM DUAL;
-- 演示用户表 存放密码时，是md5
CREATE TABLE Hsp_user(
       id INT,
       `name` VARCHAR(32) NOT NULL DEFAULT '',
       pwd CHAR(32) NOT NULL DEFAULT '');
INSERT INTO hsp_user VALUES(100,'韩顺平',MD5('123456'));
SELECT * FROM hsp_user; --csdn

SELECT * FROM hsp_user -- sql注入问题
         WHERE `name`='韩顺平' AND pwd= MD5('123456')

-- password(str) -- 加密函数
SELECT PASSWORD('123456') FROM DUAL;

-- select * from mysql.user \G 从原文密码str 
-- 计算并返回密码字符串，通常用于对mysql
-- mysql.user 表示 数据库，表
SELECT * FROM mysql.user  