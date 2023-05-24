-- 多表查询
/*
    默认情况下，当两个表查询时，规则
    1.从第一张表中，取出一行和第二张表的每一行进行组合
    返回结果 含有两张表的所有列
    2.一共返回的记录数 第一张表行数*第二张表的行数
    3.这样多表查询默认处理返回的结果，称为笛卡尔集
    4.解决这个多表的关键就是要写出正确的过滤条件where,需要程序员进行分析
    小技巧 多表查询的条件至少要几个，不能少于 表的个数-1，否则会出现笛卡尔集
*/
-- 显示雇员名，雇员工资及所在部门的名字(笛卡尔集)
/*
   分析
   1.雇员名，雇员工资 来自emp表
   2.部门的名字 来自dept表
   3.需求对 emp 和 dept 查询 ename,sal,dname,deptno
   4.当我们需要指定显示某个表的列时，需要 表名.列表
*/
SELECT * 
     FROM emp,dept
     WHERE emp.deptno = dept.deptno
           
SELECT ename,sal,dname,emp.deptno
           FROM emp,dept
           WHERE emp.deptno = dept.deptno           
           
SELECT * FROM emp;
SELECT * FROM dept;  
SELECT * FROM salgrade;         
-- 小技巧 多表查询的条件不能小于 表的个数-1，否则会出现笛卡尔集
-- 如何显示部门号为10的部门名，员工名和工资
SELECT ename,sal,dname,emp.deptno
           FROM emp,dept
           WHERE emp.deptno = dept.deptno 
           AND emp.deptno = 10          
           
-- 显示各个员工的姓名，工资，及其工资的级别
-- 思路  姓名和工资 来自  emp 13
--       工资级别   来自  salgrade 5
-- 写sql  先写一个简单的  然后加入过来过滤条件
SELECT ename,sal,grade 
     FROM emp,salgrade
     WHERE sal BETWEEN losal AND hisal   
     
-- 显示雇员名，雇员工资及所在部门的名字，并按部门排序 降序
SELECT ename,sal,dname
     FROM emp, dept
     ORDER BY dname DESC
         