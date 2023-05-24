-- 子查询
-- 是指嵌入在其他sql语句中的select 语句，也叫嵌套查询

-- 单行子查询
-- 单行查询是指只返回一行数据的子查询语句
-- 如何显示与SMITH同一部门的所有员工
/*
     1.先查询到SMITH的部门号20 得到
     2.把上面的select语句 当做一个子查询来使用
*/
SELECT deptno 
       FROM emp
       WHERE ename = 'SMITH'
-- 下面是答案       
SELECT *
      FROM emp
      WHERE deptno = (
	       SELECT deptno 
	       FROM emp
	       WHERE ename = 'SMITH'
      )
-- 多行子查询
-- 多行子查询指返回多行数据的子查询 使用关键字in
-- 如何查询和部门10的工作
-- 和相同的雇员的名字，岗位，工资，部门号，但是不含10自己的雇员
/*
    1.查询到10号部门有哪些岗位
    2.把上面查询的结果当做子查询使用


*/

SELECT DISTINCT job  -- 需要去重
       FROM emp
       WHERE deptno = 10
-- 下面语句是完整的
      
SELECT ename,job,sal,deptno
     FROM emp
     WHERE job IN (
       SELECT DISTINCT job  -- 需要去重
       FROM emp
       WHERE deptno = 10
     )AND deptno != 10   -- != 或 <>

-- 子查询 当做临时表使用
-- 查询ecshop中各个类别中，价格最高的商品
-- 可以将子查询当做一张临时表使用

-- 查询 商品表  需要切换到ecshop 数据库
-- 得到 各个类别中，价格最高的商品 max + group by cat_id  当做临时表
SELECT cat_id,MAX(shop_price)
         FROM ecs_goods
         GROUP BY cat_id

-- Column 'cat_id' in field list is ambiguous         
SELECT goods_id,ecs_goods.cat_id,goods_name,shop_price
        FROM (
		 SELECT cat_id, MAX(shop_price) AS max_price
		 FROM ecs_goods
		 GROUP BY cat_id

	) temp, ecs_goods  
	WHERE temp.cat_id = ecs_goods.cat_id  
	AND  temp.max_price = ecs_goods.shop_price  
 
         
SELECT goods_id,cat_id,goods_name,shop_price
         FROM ecs_goods