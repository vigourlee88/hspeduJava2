-- 表的复制
-- 为了对某个sql语句进行速度效率测试，
-- 我们需要海量数据时，
-- 可以使用此法为表 创建海量数据
CREATE TABLE my_tab01
        (id INT ,
        `name` VARCHAR(32),
        sal DOUBLE,
        job VARCHAR(32),
        deptno INT);
DESC my_tab01;
SELECT * FROM my_tab01;
-- 如何自我复制   
-- 1.先把emp表的记录复制到my_tab01中
INSERT INTO my_tab01  
   (id,`name`,sal,job,deptno) 
   SELECT empno,ename,sal,job,deptno 
	  FROM  emp;
-- 2.自我复制
INSERT INTO my_tab01
      SELECT * FROM my_tab01;	 
SELECT COUNT(*) FROM my_tab01; 
 
-- 如何去掉一张表中的重复记录 
-- 1.先创建一张表my_tab02
-- 2.让my_tab02有重复的记录
-- 这个语句 把emp 表的结构(列),复制到my_tab02
CREATE TABLE my_tab02 LIKE emp;
DESC my_tab02;
INSERT INTO my_tab02
       SELECT * FROM emp;
SELECT * FROM my_tab02;       
-- 3.考虑去重没my_tab02
/*
     思路
     1.先创建一张临时表my_tmp,该表的结构和my_tab02一致
     2.把my_tmp 的记录 通过distinct关键字处理后，
     把记录复制到my_tmp表
     3.清除掉my_tab02记录
     4.把my_tmp表的记录复制到my_tab02
     5.drop调 临时表my_tmp
*/   
CREATE TABLE my_tmp LIKE my_tab02; 
DESC my_tmp;
INSERT INTO my_tmp
        SELECT DISTINCT * FROM  my_tab02;  
DELETE FROM my_tab02;
INSERT INTO my_tab02
         SELECT * FROM my_tmp; 
DROP TABLE my_tmp; 
SELECT * FROM my_tab02;              
         