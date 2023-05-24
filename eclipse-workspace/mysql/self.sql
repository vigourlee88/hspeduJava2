-- 多表查询的 自连接
-- 是指在同一张表的连接查询
-- 显示公司员工名字和他上级的名字
-- 分析  员工名字在emp 上级的名字 也在emp
-- 员工和上级是通过 emp 表的 mgr 列关联
-- Not unique table/alias: 'emp'  -- 169行13*13
-- 特点1.把同一张表看做两张表使用
--     2.需要给表取别名   表名 表别名
--     3.列名不明确，可以指定列的别名  列名 as 列的别名

SELECT worker.ename AS '职员名',boss.ename AS '上级名'
       FROM emp worker,emp boss -- 169行13*13
       WHERE worker.mgr = boss.empno;


      