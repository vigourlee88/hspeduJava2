-- 事务
-- 事务用于保证数据的一致性，
-- 它由一组相关的dml语句组成，改组的dml语句
-- 要么全部成功，要么全部失败
-- 如转账就要用事务来处理，用以保证数据的一致性

-- 事务和锁
-- 当执行事务操作时(dml语句),mysql会在表上加锁，
-- 防止其他用户改表的数据，这对用户来讲是非常重要的

-- mysql数据库控制台事务的几个重要操作
-- 1.start transaction 开始事务
-- 2.savepoint 保存点名 设置保存点
-- 3.rollback to 保存点名 回退事务
-- 4.rollback 回退全部事务
-- 5.commit 提交事务，所有的操作生效，不能回退

-- 1.创建一张测试表
CREATE TABLE t27(
       id INT,
       `name` VARCHAR(32));
-- 2.开始事务
START TRANSACTION    
-- 3.设置保存点
SAVEPOINT a  
-- 执行dml 操作
INSERT INTO t27 VALUES(100,'tom'); 
SELECT * FROM t27 

SAVEPOINT b
-- 执行dml 操作
INSERT INTO t27 VALUES(200,'jack'); 
SELECT * FROM t27 

-- 回退到b
ROLLBACK TO b
SELECT * FROM t27 
-- 继续回退a
ROLLBACK TO a
SELECT * FROM t27 
-- 如果这样,直接回退到事务开始的状态
ROLLBACK 

-- 回退事务
-- 在介绍回退事务前先介绍一下保存点savepoint
-- 保存点是事务中的点，用于取消部分事务，
-- 当结束事务时(commit),会自动的删除
-- 该事务所定义的所有保存点，
-- 当执行回退事务时，通过指定保存点可以回退到指定的点
-- 提交事务
-- 使用commit语句可以提交事务，当执行了commit语句子后，、
-- 会确认事务的变化，结束事务，删除保存点，释放锁，数据生效。当使用commit语句结束事务子后，
-- 其它会话(连接)将可以查看到事物变化后的新数据(所有数据正式生效)