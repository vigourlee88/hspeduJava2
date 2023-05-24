-- 主键 使用

-- id name email
CREATE TABLE t17(
     id INT PRIMARY KEY, -- 表id列是主键，往id里添加值，不能重复
     `name` VARCHAR(32),
     email VARCHAR(32));
-- 主键列的值是不可以重复的
INSERT INTO t17 
       VALUES(1,'jack','jack@sohu.com');
INSERT INTO t17 
       VALUES(2,'tom','tom@sohu.com');
-- 下面执行失败 再加入id=1,失败
-- Duplicate entry '1' for key 't17.PRIMARY'       
INSERT INTO t17 
       VALUES(1,'hsp','hsp@sohu.com');
SELECT * FROM t17; 

-- 主键使用细节讨论
-- primary key 主键不能重复 而且不能为null
INSERT INTO t17 VALUES (NULL,'hsp','hsp@sohu.com');
-- 一张表最多只能有一个主键，但可以是复合主键
CREATE TABLE t18(
     id INT PRIMARY KEY, 
     `name` VARCHAR(32)PRIMARY KEY,-- 错误
     email VARCHAR(32));
     
-- 演示复合主键(id 和 name 做成一个复合主键)
 CREATE TABLE t18(
     id INT , 
     `name` VARCHAR(32),
     email VARCHAR(32),
     PRIMARY KEY(id,`name`)); -- 这里是复合主键
INSERT INTO t18 
       VALUES(1,'tom','tom@sohu.com'); 
SELECT * FROM t18;    
INSERT INTO t18 
       VALUES(1,'jack','jack@sohu.com');  -- 可以添加成功   
INSERT INTO t18 
       VALUES(1,'tom','xx@sohu.com'); -- 违反了复合主键，不能添加成功      
-- 主键的指定方式 有2种
-- 1.直接在字段名后指定 :字段名 primary key
-- 2.在表定义最后写 primary key(列名);
CREATE TABLE t19(
     id INT , 
     `name` VARCHAR(32) PRIMARY KEY,
     email VARCHAR(32));
CREATE TABLE t20(
     id INT , 
     `name` VARCHAR(32), 
     email VARCHAR(32),
     PRIMARY KEY(`name`));   -- 表的定义最后写primary key(列名) 
   
-- 使用desc 表名，可以看到primary key的情况 
DESC t20  -- 查看t20表的结果，显示约束的情况
DESC t18
-- 在实际开发中，每个表往往都会设计一个主键，
-- 用于唯一的标示表行的数据，当定义主键约束后，该列不能重复