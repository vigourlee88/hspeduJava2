-- 表类型和存储引擎

-- 1.MySQL的表的类型由存储引擎(Storage engines)
-- 决定，主要包括mylsam,innodb,memory等
-- 2.mysql数据表主要支持六种类型，
-- 分别是CSV,memory,archive,mrg_myisam,myisam,innobdb.
-- 3.这六种又分为两类，一类是'事务安全性'transaction-safe
-- 比如 innodb:其余都属于第二类，称为非事务安全型
-- non-transaction-safe mysiam和memory

-- 显示当前数据库支持的存储引擎
SHOW ENGINES;
-- innodb存储引擎，前面是用过，
-- 1.支持事务，2.支持外键，3.支持行级锁

-- myisam 存储引擎
CREATE TABLE t28(
      id INT,
      `name` VARCHAR(32)) ENGINE MYISAM
-- 1.添加速度快 2.不支持外键和事务 3.支持表级锁      

START TRANSACTION;
SAVEPOINT t1;
INSERT INTO t28 VALUES(1,'jack');
SELECT * FROM t28;
ROLLBACK TO t1;

-- memory 存储引擎
-- 1.数据存储在内存中,关闭了mysql服务，数据丢失，但是表的结构还在
-- 2.执行速度很快(没有io读写)3.默认支持索引(hash表)

CREATE TABLE t29(
      id INT ,
      `name` VARCHAR(32)) ENGINE MEMORY
DESC t29;      
INSERT INTO t29 
    VALUES(1,'tom'),(2,'jack'),(3,'hsp');      
SELECT * FROM t29; 

-- 如何选择表的存储引擎
-- 1.如果你的应用不需要事务，处理的只是基本的CRUD操作，
-- 那么myisam是不二选择，速度快
-- 2.如果需要支持事务，选择innodb
-- 3.memory存储引擎就是将数据存储在内存中，由于没有磁盘io的等待
-- 速度极快，但由于是内存存储引擎，所做的任何修改在服务器重启后都将消失，
-- 经典用法，用户的在线状态   

-- 指令修改存储引擎
ALTER TABLE '表名' ENGINE = 储存引擎;