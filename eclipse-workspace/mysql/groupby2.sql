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