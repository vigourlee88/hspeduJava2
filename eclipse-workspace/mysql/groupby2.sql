-- 增强 group by 的使用
-- 1.显示每种岗位的雇员总数，平均工资
SELECT COUNT(*) ,AVG(sal),job 
      FROM emp
      GROUP BY job
-- 2.显示雇员总数，以及获得补助的雇员数
-- 获得补助的雇员数即 comm 为非null
-- 如果count(列),如果该列的值为null,是不会统计
SELECT COUNT(*),COUNT(comm)
      FROM emp
-- 扩展统计没有获得补助的雇员数
SELECT COUNT(*),COUNT(IF(comm IS NULL,1,NULL))
      FROM emp  
      
SELECT COUNT(*),COUNT(*)-COUNT(comm)
      FROM emp        
-- 3.显示管理者的总人数

SELECT COUNT(mgr)
     FROM emp
SELECT COUNT(DISTINCT mgr)-- 去重DISTINCT
     FROM emp     
        
-- 4.显示雇员工资的最大差额
SELECT MAX(sal)-MIN(sal)
      FROM emp;
      
SELECT * FROM emp    

-- 多子句查询

-- 统计各个部门group by 的平均工资avg(sal)，并且是 大于1000的having，
-- 并且按照平均工资从高到低排序 order by
-- 取出前两行数据 limit 0，2
SELECT deptno,AVG(sal) AS avg_sal
   FROM emp
   GROUP BY deptno
   HAVING avg_sal > 1000
   ORDER BY avg_sal DESC -- 降序
   LIMIT 0,2;