-- 在from子句中使用子查询
-- 查找每个部门工资高于本部门平均工资的人的资料
-- 这里要用到数据查询的小技巧，把一个子查询当做一个临时表使用
-- 1.先得到每个部门的 部门号 和对应的 平均工资
SELECT deptno,AVG(sal) AS avg_sal
       FROM emp
       GROUP BY deptno
-- 2. 把上面的结果当做子查询  和emp 进行多表查询    
-- 
SELECT ename,sal,temp.avg_sal, emp.deptno
     FROM emp ,(
       SELECT deptno,AVG(sal) AS avg_sal
       FROM emp
       GROUP BY deptno 
     
     )AS temp
     WHERE emp.deptno = temp.deptno
     AND emp.sal > temp.avg_sal
     
-- 查找每个部门工资最高的人的详细资料
     
SELECT ename,sal,temp.max_sal, emp.deptno
     FROM emp ,(
       SELECT deptno,MAX(sal) AS max_sal
       FROM emp
       GROUP BY deptno 
     
     )temp
     WHERE emp.deptno = temp.deptno
     AND emp.sal = temp.max_sal
     
-- 查询每个部门的信息(包括部门名，编号，地址)和 人员数量     

-- 1.部门名，编号，地址 来自 dept 表
-- 2.各个部门的人员数量-构建一个临时表
SELECT COUNT(*),deptno 
           FROM emp
           GROUP BY deptno
           
SELECT dname,dept.deptno,loc,tmp.per_num AS '人数'
       FROM dept,(
           SELECT COUNT(*) AS per_num,deptno 
           FROM emp
           GROUP BY deptno
            
          )tmp  
          WHERE  tmp.deptno = dept.deptno 
          
-- 还有一种写法  temp.*表示将该表的所有列都显示出来
-- 可以简化sql语句
-- 如果在多表查询中，当多个表的列不重复时，才可以直接写列名dname,loc
SELECT tmp.*,dname,loc
       FROM dept,(
           SELECT COUNT(*) AS per_num,deptno 
           FROM emp
           GROUP BY deptno
            
          )tmp  
          WHERE  tmp.deptno = dept.deptno 
                   