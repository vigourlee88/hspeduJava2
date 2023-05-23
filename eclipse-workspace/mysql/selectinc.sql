-- 查询加强
-- 使用where 子句
-- 如何查找1992.1.1后入职的员工
-- 说明 在mysql中，日期类型可以直接比较,需要注意 格式
SELECT * FROM emp
         WHERE hiredate > '1992-01-01';
-- 如何使用like操作符
-- %表示0到多个字符   _表示单个任意字符
-- 如何显示首字母为s的员工姓名和工资
SELECT ename,sal FROM emp
       WHERE ename LIKE 'S%'
             
-- 如何显示第三个字符为大写o所有员工的姓名和工资
SELECT ename,sal FROM emp
       WHERE ename LIKE '__O%'-- _两个下划线
             
-- 如何显示没有上级的雇员的情况
-- 如果判断某一列的值是否为空，要使用is
SELECT  * FROM emp
       WHERE mgr IS NULL;
       
-- 查询表的结构
DESC emp 

-- 使用order by 子句
-- 如何按照工资的从低到高的顺序，显示雇员的信息
SELECT * FROM emp
       ORDER BY sal ASC
-- 按照部门号升序而雇员的工资降序排列，显示雇员信息
SELECT * FROM emp
       ORDER BY deptno , sal DESC     