-- 多行子查询中使用all操作符
-- 如何显示工资比部门30的所有员工的工资高的
-- 员工姓名，工资和部门号
SELECT ename,sal ,deptno
     FROM emp
     WHERE sal > ALL(
	     SELECT sal 
		     FROM emp 
		     WHERE deptno = 30
	     )
-- 可以这样写
SELECT ename,sal ,deptno
     FROM emp
     WHERE sal > (
	     SELECT MAX(sal) 
		     FROM emp 
		     WHERE deptno = 30
	     )
-- 请思考 如何显示工资比部门30的
-- 其中的一个员工的工资高的员工的姓名，工资和部门号
SELECT ename,sal ,deptno
     FROM emp
     WHERE sal > ANY(
	     SELECT sal 
		     FROM emp 
		     WHERE deptno = 30
	     )
-- 也可以这样写	     	
SELECT ename,sal ,deptno
     FROM emp
     WHERE sal > (
	     SELECT MIN(sal) 
		     FROM emp 
		     WHERE deptno = 30
	     )	          