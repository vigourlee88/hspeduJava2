#第18章_MySQL8.0的其他新特性

CREATE DATABASE dbtest18;

USE dbtest18;


#1.窗口函数
CREATE TABLE sales(
id INT PRIMARY KEY AUTO_INCREMENT,
city VARCHAR(15),
county VARCHAR(15),
sales_value DECIMAL
);


INSERT INTO sales(city,county,sales_value)
VALUES
('北京','海淀',10.00),
('北京','朝阳',20.00),
('上海','黄埔',30.00),
('上海','长宁',10.00);

SELECT * FROM sales;

#需求：现在计算这个网站在每个城市的销售总额、在全国的销售总额、
#每个区的销售额占所在城市销售额中的比率，以及占总销售额中的比率。
#如果用分组和聚合函数，就需要分好几步来计算。
第一步，计算总销售金额，并存入临时表 a：
查看一下临时表 a ：
第二步，计算每个城市的销售总额并存入临时表 b：

#方式1

CREATE TEMPORARY TABLE a -- 创建临时表
SELECT SUM(sales_value) AS sales_value -- 计算总计金额
FROM sales;

SELECT * FROM a;

CREATE TEMPORARY TABLE b -- 创建临时表
SELECT city,SUM(sales_value) AS sales_value -- 计算城市销售合计
FROM sales
GROUP BY city

SELECT * FROM b;

SELECT s.city AS 城市,s.county AS 区,s.sales_value AS 区销售额,
b.sales_value AS 市销售额,s.sales_value/b.sales_value AS 市比率,
a.sales_value AS 总销售额,s.sales_value/a.sales_value AS 总比率
FROM sales s JOIN b 
ON (s.city=b.city) -- 连接市统计结果临时表 
JOIN a -- 连接总计金额临时表
ORDER BY s.city,s.county;


#方式2 窗口函数
SELECT city AS 城市,county AS 区,sales_value AS 区销售额,
SUM(sales_value) OVER(PARTITION BY city) AS 市销售额, -- 计算市销售额
sales_value/SUM(sales_value) OVER(PARTITION BY city) AS 市比率,
SUM(sales_value) OVER() AS 总销售额, -- 计算总销售额
sales_value/SUM(sales_value) OVER() AS 总比率
FROM sales
ORDER BY city,county;

#2.介绍窗口函数 将结果置于每一条数据记录中

CREATE TABLE employees
AS 
SELECT * FROM atguigudb.employees;

SELECT * FROM employees;

#准备工作

CREATE TABLE goods(
id INT PRIMARY KEY AUTO_INCREMENT,
category_id INT,
category VARCHAR(15),
NAME VARCHAR(30),
price DECIMAL(10,2),
stock INT,
upper_time DATETIME
);

INSERT INTO goods(category_id,category,NAME,price,stock,upper_time)
VALUES
(1, '女装/女士精品', 'T恤', 39.90, 1000, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '连衣裙', 79.90, 2500, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '卫衣', 89.90, 1500, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '牛仔裤', 89.90, 3500, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '百褶裙', 29.90, 500, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '呢绒外套', 399.90, 1200, '2020-11-10 00:00:00'),
(2, '户外运动', '自行车', 399.90, 1000, '2020-11-10 00:00:00'),
(2, '户外运动', '山地自行车', 1399.90, 2500, '2020-11-10 00:00:00'),
(2, '户外运动', '登山杖', 59.90, 1500, '2020-11-10 00:00:00'),
(2, '户外运动', '骑行装备', 399.90, 3500, '2020-11-10 00:00:00'),
(2, '户外运动', '运动外套', 799.90, 500, '2020-11-10 00:00:00'),
(2, '户外运动', '滑板', 499.90, 1200, '2020-11-10 00:00:00');

SELECT * FROM goods;
#1. 序号函数

#1.1ROW_NUMBER()函数
#举例：查询 goods 数据表中每个商品分类下价格降序排列的各个商品信息。
SELECT ROW_NUMBER() OVER(PARTITION BY category_id ORDER BY price DESC) 
AS row_num,
id, category_id, category, NAME, price, stock
FROM goods;

#举例：查询 goods 数据表中每个商品分类下价格最高的3种商品信息。
SELECT *
FROM (
SELECT ROW_NUMBER() OVER(PARTITION BY category_id ORDER BY price DESC) AS
row_num,
id, category_id, category, NAME, price, stock
FROM goods) t
WHERE row_num <= 3;

#1.2 RANK()函数
#使用RANK()函数能够对序号进行并列排序，并且会跳过重复的序号，比如序号为1、1、3。
#举例：使用RANK()函数获取 goods 数据表中各类别的价格从高到低排序的各商品信息。
SELECT RANK() OVER(PARTITION BY category_id ORDER BY price DESC)
AS row_num,
id, category_id, category, NAME, price, stock
FROM goods;

#1.3 DENSE_RANK()函数
#DENSE_RANK()函数对序号进行并列排序，并且不会跳过重复的序号，比如序号为1、1、2。
#举例：使用DENSE_RANK()函数获取 goods 数据表中各类别的价格从高到低排序的各商品信息。
SELECT DENSE_RANK() OVER(PARTITION BY category_id ORDER BY price DESC) AS
row_num,
id, category_id, category, NAME, price, stock
FROM goods;


#2. 分布函数
#2.1 PERCENT_RANK()函数
#PERCENT_RANK()函数是等级值百分比函数。按照如下方式进行计算。

#举例：计算 goods 数据表中名称为“女装/女士精品”的类别下的商品的PERCENT_RANK值。

#写法一：
SELECT RANK() OVER (PARTITION BY category_id ORDER BY price DESC) AS r,
PERCENT_RANK() OVER (PARTITION BY category_id ORDER BY price DESC) AS pr,
id, category_id, category, NAME, price, stock
FROM goods
WHERE category_id = 1;

#写法二：
SELECT RANK() OVER w AS r,
PERCENT_RANK() OVER w AS pr,
id, category_id, category, NAME, price, stock
FROM goods
WHERE category_id = 1 WINDOW w AS (PARTITION BY category_id ORDER BY price
DESC);

#2.2 CUME_DIST()函数
#CUME_DIST()函数主要用于查询小于或等于某个值的比例。
#举例：查询goods数据表中小于或等于当前价格的比例。
SELECT CUME_DIST() OVER(PARTITION BY category_id ORDER BY price ASC) AS cd,
id, category, NAME, price
FROM goods;

#3. 前后函数
#3.1 LAG(expr,n)函数
#LAG(expr,n)函数返回当前行的前n行的expr的值。
#举例：查询goods数据表中前一个商品价格与当前商品价格的差值。

SELECT id, category, NAME, price, pre_price, price - pre_price AS diff_price
FROM (
SELECT id, category, NAME, price,LAG(price,1) OVER w AS pre_price
FROM goods
WINDOW w AS (PARTITION BY category_id ORDER BY price)) t;

#3.2LEAD(expr,n)函数
#LEAD(expr,n)函数返回当前行的后n行的expr的值。
#举例：查询goods数据表中后一个商品价格与当前商品价格的差值。

SELECT id, category, NAME, behind_price, price,behind_price - price AS
diff_price
FROM(
SELECT id, category, NAME, price,LEAD(price, 1) OVER w AS behind_price
FROM goods WINDOW w AS (PARTITION BY category_id ORDER BY price)) t;

#4. 首尾函数
#4.1 FIRST_VALUE(expr)函数
#FIRST_VALUE(expr)函数返回第一个expr的值。
#举例：按照价格排序，查询第1个商品的价格信息。

SELECT id, category, NAME, price, stock,FIRST_VALUE(price) OVER w AS
first_price
FROM goods WINDOW w AS (PARTITION BY category_id ORDER BY price);

#4.2 LAST_VALUE(expr)函数
#LAST_VALUE(expr)函数返回最后一个expr的值。
#举例：按照价格排序，查询最后一个商品的价格信息。

SELECT id, category, NAME, price, stock,LAST_VALUE(price) OVER w AS last_price
FROM goods WINDOW w AS (PARTITION BY category_id ORDER BY price);

#5. 其他函数
#5.1 NTH_VALUE(expr,n)函数
#NTH_VALUE(expr,n)函数返回第n个expr的值。
#举例：查询goods数据表中排名第2和第3的价格信息。

SELECT id, category, NAME, price,NTH_VALUE(price,2) OVER w AS second_price,
NTH_VALUE(price,3) OVER w AS third_price
FROM goods WINDOW w AS (PARTITION BY category_id ORDER BY price);

#5.2 NTILE(n)函数
#NTILE(n)函数将分区中的有序数据分为n个桶，记录桶编号。
#举例：将goods表中的商品按照价格分为3组。
SELECT NTILE(3) OVER w AS nt,id, category, NAME, price
-> FROM goods WINDOW w AS (PARTITION BY category_id ORDER BY price);

#小结
#窗口函数的特点是可以分组，而且可以在分组内排序。另外，窗口函数不会因为分组而减少原表中的行
#数，这对我们在原表数据的基础上进行统计和排序非常有用。

#公用表表达式
#CTE是一个命名的临时结果集，作用范围是当前语句。CTE可以理解成一个可以复用的子查询，当然跟子查询还是有点区别的，
#CTE可以引用其他CTE，但子查询不能引用其他子查询。所以，可以考虑代替子查询。

#普通公用表表达式的语法结构是：
#普通公用表表达式类似于子查询，不过，跟子查询不同的是，它可以被多次引用，
#而且可以被其他的普通公用表表达式所引用。
#举例：查询员工所在的部门的详细信息。

WITH CTE名称
AS （子查询）
SELECT|DELETE|UPDATE 语句;


SELECT * FROM departments
WHERE department_id IN (
SELECT DISTINCT department_id
FROM employees
);


WITH emp_dept_id
AS (SELECT DISTINCT department_id FROM employees)
SELECT *
FROM departments d JOIN emp_dept_id e
ON d.department_id = e.department_id;

#递归公用表表达式也是一种公用表表达式，只不过，除了普通公用表表达式的特点以外，它还有自己的
#特点，就是可以调用自己。它的语法结构是：

WITH RECURSIVE
CTE名称 AS （子查询）
SELECT|DELETE|UPDATE 语句;


WITH RECURSIVE cte
AS
(
SELECT employee_id,last_name,manager_id,1 AS n FROM employees WHERE employee_id = 100
-- 种子查询，找到第一代领导
UNION ALL
SELECT a.employee_id,a.last_name,a.manager_id,n+1 FROM employees AS a JOIN cte
ON (a.manager_id = cte.employee_id) -- 递归查询，找出以递归公用表表达式的人为领导的人
)
SELECT employee_id,last_name FROM cte WHERE n >= 3;