--unique的使用
CREATE TABLE t21(
     id INT UNIQUE, -- 表示id列不能重复的，唯一
     `name` VARCHAR(32), 
     email VARCHAR(32)
     );
INSERT INTO t21
        VALUES(1,'jack','jack@sohu.com');     
INSERT INTO t21
        VALUES(1,'tom','tom@sohu.com');             

-- unique使用细节
-- 1.如果没有指定not null,则unique字段可以有多个null        
-- 如果一个列(字段),
-- 是unique not null 使用效果类似 primary key
INSERT INTO t21
        VALUES(NULL,'tom','tom@sohu.com');             
SELECT * FROM t21;
-- 2.一张表可以有多个unique字段
CREATE TABLE t22(
     id INT UNIQUE, -- 表示id列不能重复的，唯一
     `name` VARCHAR(32) UNIQUE , -- name 不能重复
     email VARCHAR(32)
     );
DESC t22     