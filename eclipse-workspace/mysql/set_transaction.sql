-- 事务隔离级别介绍
-- 1.多个连接开启各自事务操作数据库中数据时，
-- 数据库系统要负责隔离操作，以保证各个连接在获取数据时的准确性

-- 2.如果不考虑隔离性，可能会引发如下问题
-- 脏读 drity read
-- 当一个事务读取另一个事务尚未提交的修改时，产生脏读
-- 不可重复读 nonrepeatable read
-- 同一查询在同一个事务中多次进行，由于其他提交事务所做的修改或删除，
-- 每次返回不同的结果集，此时发生不可重复读

-- 幻读  phantom read
-- 同一查询在同一事务中多次进行，由于其他提交事务所做的插入操作，
-- 每次返回不同的结果集，此时发生幻读

-- 演示MySQL事务的隔离级别和事务相关 定义了事务与事务之间的隔离程度
-- 1.开了 两个 mysql的控制台
-- 2.查看当前mysql的隔离级别
-- 旧版本mysql用的是tx_isolation
-- 新版mysql使用的是transaction_isolation
SELECT @@transaction_isolation;

-- mysql> select @@transaction_isolation;
-- +-------------------------+
-- | @@transaction_isolation |
-- +-------------------------+
-- | REPEATABLE-READ  可重复读的       |
-- +-------------------------+
-- 3.把其中一个控制台的隔离级别设置 read uncommitted

SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

-- 在mysql命令行中开启事务 start transaction;
-- 使用数据库 use hsp_db02;

-- 4.创建表
CREATE TABLE `account`(
       id INT,
       `name` VARCHAR(32),
       money INT);
SELECT * FROM ACCOUNT;   

-- 1.查看当前会话隔离级别
SELECT @@transaction_isolation;
-- 2.查看系统当前隔离级别
SELECT @@global.transaction_isolation;
-- 3.设置当前会话隔离级别
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
-- 4.设置系统隔离级别
SET GLOBAL TRANSACTION ISOLATION LEVEL (你设置的级别)
-- 5.mysql默认的事务隔离级别是 repeatable read,
-- 一般情况下，没有特殊要求，没有必要修改(因为该级别可以满足绝大部分项目需求)
-- 全局修改，修改mysql.in配置文件，在最后加上
-- #可选参数有: READ-UNCOMMITTED,READ-COMMITED,
-- REPEATABLE-READ,SERIALIZABLE
-- [mysqlid]
-- transaction-isolation = REPEATABLE-READ