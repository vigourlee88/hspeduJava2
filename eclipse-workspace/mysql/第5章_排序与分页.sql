#第5章_排序与分页

#1.排序

#如果没有使用排序操作，默认情况下查询返回的数据是按照添加数据的顺序显示的
SELECT * FROM employees;

#1.1基本使用
#练习 按照salary 从高到低的顺序显示员工信息
#使用order by 对查询到的数据进行排序操作
# 升序 ASC  ascend
# 降序  DESC  descend
SELECT employee_id,last_name,salary
FROM employees
ORDER BY salary ASC;

# 如果在order by后没有显式指名排序的方式的话，则默认按照升序排列
SELECT employee_id,last_name,salary
FROM employees
ORDER BY salary ;

# 2.我们可以使用  列的别名，进行排序
SELECT employee_id,salary,salary * 12 annual_sal
FROM employees
ORDER BY annual_sal ;

#列的别名 只能在 order by 中使用，不能在 where 中使用
SELECT employee_id,salary,salary * 12 annual_sal
FROM employees
WHERE annual_sal > 81600 ;

#先从from ,where ,select,order by 顺序查询
#3.强调格式 where 需要声明在from 后，order by之前
SELECT employee_id,salary
FROM employees
WHERE department_id IN (50,60,70)
ORDER BY department_id DESC;、


#4.二级排序
#练习 显示员工信息，按照department_id的降序排序，salary的升序排列
SELECT employee_id,salary,department_id
FROM employees
ORDER BY department_id DESC,salary ASC;

#2.分页
#2.1 mysql 使用limit实现数据的分页显示

# 需求 每页显示20条记录，此时显示第1页
SELECT employee_id,last_name
FROM employees
LIMIT 40,20;

#需求 每页显示pageSize条记录，此时显示第pageNo页
#公式 limit ( pageNo-1)*pageSize ,pageSize;
#limit 位置偏移量，条目数 LIMIT 0,10等价于 limit 10
#2.2 where ...order by ...limit 声明顺序如下
SELECT employee_id,last_name,salary
FROM employees
WHERE salary > 6000
ORDER BY salary DESC
LIMIT 0,10;
#显示第32,33条数据
SELECT employee_id,last_name
FROM employees
LIMIT 31,2;

#2.3 mysql 8.0新特性 limit .条数..offset..偏移量.
SELECT employee_id,last_name
FROM employees
LIMIT 2 OFFSET 31;

#练习 查询员工表中工资最高的员工信息
SELECT employee_id,last_name
FROM employees
ORDER BY salary DESC
#LIMIT 0,1;
LIMIT 1;

#2.4 LIMIT 可以使用在MySQL、PGSQL、MariaDB、SQLite 等数据库中使用，表示分页。
# 不能使用在SQL Server、DB2、Oracle！

