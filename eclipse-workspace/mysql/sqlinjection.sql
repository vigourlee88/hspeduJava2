-- 演示sql注入
CREATE TABLE `admin`( -- 管理员表
       `name` VARCHAR(32) NOT NULL UNIQUE,
       pwd VARCHAR(32) NOT NULL DEFAULT '')
       CHARACTER SET utf8;

-- 添加数据
INSERT INTO `admin` VALUES('tom','123');
-- 查找某个管理是否存在
SELECT * 
       FROM ADMIN
       WHERE NAME = 'tom' AND pwd = '123' 
-- sql
-- 输入用户名 为 1' or
-- 输万能密码 为 or '1'= '1  
SELECT * FROM ADMIN     

-- 创建测试表
CREATE TABLE admin2(
   id INT PRIMARY KEY AUTO_INCREMENT,
   username VARCHAR(32) NOT NULL,  
   PASSWORD VARCHAR(32) NOT NULL ); 
   
SELECT COUNT(*) FROM admin2  
SELECT * FROM admin2
DROP TABLE admin2; 