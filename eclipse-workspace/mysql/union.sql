-- 合并查询

-- 在实际应用中，为了合并多个select语句的结果，
-- 可以使用集合操作符号union,union all
-- union all 就是将两个结果合并，不会去重
-- 该操作符用于取得两个结果集的并集，
-- 当使用该操作符时，不会取消重复行
SELECT ename,sal,job
      FROM emp
      WHERE sal > 2500 
UNION ALL
SELECT ename,sal,job
      FROM emp
      WHERE job = 'MANAGER';      
-- union 将两个查询结果合并，会去重
SELECT ename,sal,job
      FROM emp
      WHERE sal > 2500 
UNION 
SELECT ename,sal,job
      FROM emp
      WHERE job = 'MANAGER';          