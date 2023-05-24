-- 演示mysql的索引的使用
-- 创建索引

-- 查询表是否有索引 
SHOW INDEXES FROM t25; 
-- 添加索引
-- 添加唯一索引
CREATE UNIQUE INDEX id_index ON t25 (id); 
-- 添加普通索引 方式1    
CREATE INDEX id_index ON t25(id);
-- 如何选择
-- 1.如果某列的值，是不会重复的，则优先考虑unique索引
-- 添加普通索引 方式2
ALTER TABLE t25 ADD INDEX id_index (id);

-- 添加主键索引
CREATE TABLE t26(
        id INT,
        `name` VARCHAR(32));
ALTER TABLE t26 ADD PRIMARY KEY (id);        
SHOW INDEX FROM t26;

--  删除索引
DROP INDEX id_index ON t25; 
SHOW INDEX FROM t25;
--  删除主键索引
ALTER TABLE t26 DROP PRIMARY KEY; 

-- 修改索引，先删除，在添加新的索引
-- 查询索引
-- 1.方式
SHOW INDEX FROM t25;
-- 2.方式
SHOW INDEXES FROM t25;
-- 3.方式
SHOW KEYS FROM t25;

-- 4.方式
DESC t25;

-- 小结
-- 在哪些列上适合使用索引
-- 1.较频繁的作为查询条件字段应该创建索引
-- select * from emp where empno = 1
-- 2.唯一性太差的字段不适合单独创建索引，即使频繁作为查询条件
-- select * from emp where sex = '男'
-- 3.更新非常频繁的字段不适合创建索引
-- select * from emp where logincount = 1
-- 4.不会出现在WHERE子句中字段不该创建索引