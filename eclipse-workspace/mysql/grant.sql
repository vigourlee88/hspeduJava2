-- 演示 用户权限的管理

-- 创建用户 shunpin 密码123,从本地登录
CREATE USER 'shunpin'@'localhost' IDENTIFIED BY '123';

-- 使用root 用户创建testdb,表news
CREATE DATABASE testdb
CREATE TABLE news(
        id INT,
        content VARCHAR(32));

-- 添加一条测试记录
INSERT INTO news VALUES(100,'北京新闻');
SELECT * FROM news;  

-- 给shunpin 分配查看 news表和添加news权限
GRANT SELECT ,INSERT 
      ON testdb.news
      TO 'shunpin'@'localhost'
-- 可以增加权限
GRANT UPDATE
      ON testdb.news
      TO 'shunpin'@'localhost'  
         
-- 修改shunpin的密码为abc
-- set password for 'shunpin'@'localhost' = password('abc'); 不使用
ALTER USER 'shunpin'@'localhost' IDENTIFIED BY 'abc';         

-- 回收 shunpin用户在testdb.news表的所有权限
-- 然后到shunpin数据库下 刷新，就看不到testdb
REVOKE SELECT,UPDATE,INSERT ON testdb.news FROM 'shunpin'@'localhost'

REVOKE ALL ON testdb.news FROM 'shunpin'@'localhost'      

-- 删除 shunpin
DROP USER 'shunpin'@'localhost'