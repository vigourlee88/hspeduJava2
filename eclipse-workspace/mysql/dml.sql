-- 通过jdbc对表actor进行添加，删除和修改操作
USE hsp_db02;
CREATE TABLE actor(  -- 演员表
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(32) NOT NULL DEFAULT '',
    sex CHAR(1) NOT NULL DEFAULT '女',
    borndate DATETIME,
    phone VARCHAR(12));
    
SELECT * FROM actor;
DELETE FROM actor WHERE id = 1
-- 添加两条记录 用于测试ResultSet
INSERT INTO actor 
     VALUES(NULL,'刘德华','男','1970-12-12','110');
INSERT INTO actor 
     VALUES(NULL,'jack','男','1990-12-12','112');  
     
SELECT * FROM actor
CREATE TABLE account01(
      id INT PRIMARY KEY AUTO_INCREMENT,
      NAME VARCHAR(32) NOT NULL DEFAULT '',
      balance DOUBLE NOT NULL DEFAULT 0)
      CHARACTER SET utf8;
INSERT INTO account01 VALUES(NULL,'马云',3000);
INSERT INTO account01 VALUES(NULL,'马化腾',10000);              
SELECT * FROM account01;
UPDATE actor SET id = 4 WHERE phone = 110;
UPDATE actor SET id = 6 WHERE phone = 116;
