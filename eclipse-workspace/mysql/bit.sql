#演示bit类型使用
#说明
#1.bit(m)m 在1-64
#2.添加数据 范围
#3.显示按照bit 位的方式显示
CREATE TABLE t05 (num BIT(8));
INSERT INTO t05 VALUES(1);
INSERT INTO t05 VALUES(3);
INSERT INTO t05 VALUES(255);
SELECT * FROM t05;