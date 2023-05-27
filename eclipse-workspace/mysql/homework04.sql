-- 7.根据emp员工表，dept部门表，工资=薪金+佣金
-- 1.列出至少有一个员工的所有部门
/*
     分析
     1.先查出各个部门有多少人
     使用having 子句过滤
     

*/
SELECT * FROM emp
SELECT * FROM dept
SELECT COUNT(*) AS c, deptno
       FROM emp
       GROUP BY deptno 
       HAVING c > 1
        
-- 2.列出薪金比"SMITH"多的所有员工
/*
     分析
     1.SMITH的薪金是多少  =>作为子查询结果
     2.然后其他员工sal > smith的即可

*/
SELECT sal
        FROM emp
        WHERE ename = 'SMITH'
SELECT *
        FROM emp
        WHERE  sal > (
                SELECT sal
		FROM emp
		WHERE ename = 'SMITH'
        )       

-- 3.列出受雇日期晚于其直接上级的所有员工
/*
   分析
   1.先把emp表当成两张表 worker,leader
   2.条件     1.worker.hiredate > leader.hiredate
     连接条件 2.worker.mgr (上级编号)= leader.empno(雇员编号)         

*/
SELECT worker.ename AS '员工名',
       worker.hiredate AS '员工入职时间',
       leader.ename AS '上级名',
       leader.hiredate AS '上级入职时间'
         FROM emp worker,emp leader
         WHERE worker.hiredate > leader.hiredate
         AND worker.mgr = leader.empno

-- 4.列出部门名称和这些部门的员工信息
-- 同时列出那些没有员工的部门
/*
    分析
    1.这里需要显示所有部门，因此考虑使用 外连接 
    左外连接  左边的表的所有列  被罗列出来
    
*/
SELECT dname,emp.*
         FROM dept 
         LEFT JOIN emp ON dept.deptno = emp.deptno
         
-- 5.列出所有"CLERK"办事员 的姓名及其部门名称
-- (多表查询，需要关联条件)
SELECT ename,dname,job
         FROM emp,dept
         WHERE job = 'CLERK' 
         AND emp.deptno = dept.deptno

-- 7.列出最低薪金大于1500的各种工作
/*

      分析
      1.查询各个部门的最低薪金 - 部门分组查询
      2.使用having子句进行过滤 

*/
SELECT MIN(sal) AS min_sal,job
          FROM emp
          GROUP BY job
          HAVING min_sal > 1500
-- 7.列出在部门"SALES"销售部 工作的员工的姓名
SELECT * FROM emp
SELECT * FROM dept
SELECT ename,dname
          FROM emp,dept
          WHERE  emp.deptno = dept.deptno
          AND dname = 'SALES'
-- 8.列出薪金高于公司平均薪金的所有员工
/*
    分析
    1.求出公司的平均薪水
    

*/
SELECT AVG(sal) AS avg_sal
          FROM emp
SELECT * 
           FROM emp
           WHERE  sal > (
                  SELECT AVG(sal) AS avg_sal
                  FROM emp
                  )

-- 9.列出与'SCOTT'从事相同工作的所有员工
SELECT * FROM emp
/*  
     分析
     1.'SCOTT'从事的工作 => 作为子查询

*/
SELECT job
           FROM emp
           WHERE ename = 'SCOTT'
SELECT  ename
        FROM emp
        WHERE job = (
           SELECT job
		   FROM emp
		   WHERE ename = 'SCOTT'
        ) AND ename != 'SCOTT'
         
-- 10.列出薪金高于所在部门30的工作的所有员工的薪金的员工姓名和薪金
-- 先查询出30部门的最高工资
SELECT MAX(sal)
         FROM emp
         WHERE deptno = 30
SELECT ename,sal
         FROM emp
         WHERE sal > (
	   SELECT MAX(sal)
		 FROM emp
		 WHERE deptno = 30
         )
-- 11.列出在每个部门工作的员工数量，平均工资和平均服务期限
SELECT * FROM emp
SELECT COUNT(*) AS '部门的员工数量',deptno ,
       AVG(sal) AS '部门的平均工资',
       FORMAT(AVG(DATEDIFF(NOW(),hiredate)/365),2) AS ' 平均的服务期限(年)'
	     FROM emp  
	     GROUP BY deptno
 
-- 12.列出所有员工的姓名，部门名称和工资
SELECT ename,dname,sal
         FROM emp,dept
         WHERE emp.deptno = dept.deptno
         
-- 13.列出所有部门的详细信息和部门人数
-- 13.1先得到每个部门的人数，
-- 把下面的结果看成临时表和dept表 联合查询
SELECT COUNT(*) AS c,deptno
        FROM emp
        GROUP BY deptno
-- 13.2        
SELECT dept.*,tmp.c AS '部门人数'
        FROM dept,(
                SELECT COUNT(*) AS c,deptno
		FROM emp
		GROUP BY deptno 
		) tmp
        WHERE dept.deptno = tmp.deptno

-- 14.列出各种工作的最低工资
SELECT MIN(sal),job
     FROM emp
     GROUP BY job
-- 15.列出MANAGER经理的最低薪金
SELECT MIN(sal),job
       FROM emp
       WHERE job = 'MANAGER'
       

-- 16.列出所有员工的年工资，按年薪从低到高排序                         
SELECT ename,(sal + IFNULL(comm,0))*12 AS year_sal
         FROM emp
         ORDER BY year_sal 