# 第09章_子查询

#是指一个查询语句嵌套在另一个查询语句内部的查询

#1. 由一个具体的需求，引入子查询

#需求：谁的工资比Abel的高？
#方式1： 查出Abel的工资
SELECT salary
FROM employees
WHERE last_name = 'Abel';#11000

SELECT last_name,salary
FROM employees
WHERE salary > 11000;

#方式2：自连接
SELECT e2.last_name,e2.salary
FROM employees e1,employees e2
WHERE e2.`salary` > e1.`salary` #多表的连接条件
AND e1.last_name = 'Abel';

#方式3：子查询
SELECT last_name,salary
FROM employees
WHERE salary > (
		SELECT salary
		FROM employees
		WHERE last_name = 'Abel'
		);

#2. 称谓的规范：外查询（或主查询）、内查询（或子查询）

/*
- 子查询（内查询）在主查询之前一次执行完成。
- 子查询的结果被主查询（外查询）使用 。
- 注意事项
  - 子查询要包含在括号内()
  - 将子查询放在比较条件的右侧
  - 单行操作符对应单行子查询，多行操作符对应多行子查询

*/

#不推荐：
SELECT last_name,salary
FROM employees
WHERE  (
	SELECT salary
	FROM employees
	WHERE last_name = 'Abel'
		) < salary;
		
/*
3. 子查询的分类
角度1：从内查询返回的结果的条目数
	
	单行子查询  vs  多行子查询

角度2：内查询是否被执行多次
	
	相关子查询  vs  不相关子查询
	
 比如：相关子查询的需求：查询工资大于本部门平均工资的员工信息。
       不相关子查询的需求：查询工资大于本公司平均工资的员工信息。
 
*/

#子查询的编写技巧（或步骤）：① 从里往外写  ② 从外往里写

#4. 单行子查询  内查询只返回一个数据
#4.1 单行操作符： =  !=  >   >=  <  <= 
#题目：查询工资大于149号员工工资的员工的信息

SELECT employee_id,last_name,salary
FROM employees
WHERE salary > (
		SELECT salary
		FROM employees
		WHERE employee_id = 149
		);

#题目：返回job_id与141号员工相同，salary比143号员工多的员工姓名，job_id和工资

DESC employees;
SELECT * FROM employees;

SELECT last_name,job_id,salary
FROM employees
WHERE job_id = (
		SELECT job_id
		FROM employees
		WHERE employee_id = 141 #int类型，不需要使用''
		)
AND salary > (
		SELECT salary
		FROM employees
		WHERE employee_id = 143
		);


#题目：返回公司工资最少的员工的last_name,job_id和salary

SELECT MIN(salary)
FROM employees #2100

SELECT last_name,job_id,salary
FROM employees
WHERE salary = (
		SELECT MIN(salary)
		FROM employees
		);
		

#题目：查询与141号员工的manager_id和department_id相同的其他员工
#的employee_id，manager_id，department_id。
#方式1：
SELECT manager_id
FROM employees
WHERE employee_id = 141

SELECT department_id
FROM employees
WHERE employee_id = 141

SELECT employee_id,manager_id,department_id
FROM employees
WHERE manager_id = ( )

AND department_id = ( );


SELECT employee_id,manager_id,department_id
FROM employees
WHERE manager_id = (
		    SELECT manager_id
		    FROM employees
		    WHERE employee_id = 141
		   )
AND department_id = (
		    SELECT department_id
		    FROM employees
		    WHERE employee_id = 141
		   )
AND employee_id <> 141;#其他的员工，不等于141

#方式2：了解  成对查询
SELECT employee_id,manager_id,department_id
FROM employees
WHERE (manager_id,department_id) = (
				    SELECT manager_id,department_id
			            FROM employees
				    WHERE employee_id = 141
				   )
AND employee_id <> 141; #不等于141

#题目：查询最低工资大于110号部门最低工资的部门id和其最低工资

#结论1：SELECT中出现的非组函数的字段 必须声明在GROUP BY 中。
#      反之，GROUP BY中声明的字段可以 不出现在SELECT中。

SELECT salary 
FROM employees
WHERE department_id = 110 #8200

SELECT department_id ,MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (); #过滤

#正确
SELECT department_id,MIN(salary)
FROM employees
WHERE department_id IS NOT NULL #不为空，老板为空
GROUP BY department_id
HAVING MIN(salary) > (
			SELECT MIN(salary)
			FROM employees
			WHERE department_id = 110
		     );

#题目：显式员工的employee_id,last_name和location
#其中，若员工department_id与location_id为1800的department_id相同，
#则location为’Canada’，其余则为’USA’。

SELECT * FROM employees
SELECT * FROM departments


SELECT employee_id,last_name,CASE department_id WHEN 20 THEN 'Canada'
                                                 ELSE 'USA' END "location"
FROM employees

#查询得到 #20
SELECT department_id
FROM departments
WHERE location_id = 1800 

#正确
SELECT employee_id,last_name,CASE department_id WHEN (SELECT department_id FROM departments WHERE location_id = 1800) THEN 'Canada'
						ELSE 'USA' END "location"
FROM employees;

#4.2 子查询中的空值问题
SELECT last_name, job_id
FROM   employees
WHERE  job_id =
                (SELECT job_id
                 FROM   employees
                 WHERE  last_name = 'Haas');
                 
#4.3 非法使用子查询
#错误：Subquery returns more than 1 row
SELECT employee_id, last_name
FROM   employees
WHERE  salary =                         # = 是单行查询操作符
                (SELECT   MIN(salary)
                 FROM     employees
                 GROUP BY department_id); #子查询返回多行操作应使用 IN        

#5.多行子查询
#5.1 多行子查询的操作符： IN  ANY ALL SOME(同ANY)

#5.2举例：
# IN: 等于列表中的任意一个
SELECT employee_id, last_name
FROM   employees
WHERE  salary IN
                (SELECT   MIN(salary)
                 FROM     employees
                 GROUP BY department_id); 
                 
# ANY / ALL: 需要和单行比较操作符一起使用，和子查询返回的 某个/所有 值比较
#SOME 是 ALL的别名，作用相同，一般常用ALL

#题目：返回其它job_id中比job_id为‘IT_PROG’部门任一工资低的员工的员工号、
#姓名、job_id 以及salary

SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE job_id <> 'IT_PROG'
AND salary < ANY (
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		);

#题目：返回其它job_id中比job_id为‘IT_PROG’部门所有工资低的员工的员工号、
#姓名、job_id 以及salary

SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE job_id <> 'IT_PROG'
AND salary < ALL (
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		);
		
#题目：查询平均工资最低的部门id

#MySQL中聚合函数是不能嵌套使用的。
#方式1：
SELECT department_id,AVG(salary) avg_sal
FROM employees
GROUP BY department_id

#min(avg(salary)) 错误，MySQL中聚合函数是不能嵌套使用的

SELECT MIN(avg_sal) # avg_sal作为字段求最小值
FROM (
         SELECT AVG(salary) avg_sal
         FROM employees
         GROUP BY department_id
 
      ) t_dept_avg_sal #每个表需要有 表名
      
#正确      
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) = (
			SELECT MIN(avg_sal)
			FROM(
				SELECT AVG(salary) avg_sal
				FROM employees
				GROUP BY department_id
				) t_dept_avg_sal
			);

#方式2：简化
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) <= ALL(	
			SELECT AVG(salary) avg_sal
			FROM employees
			GROUP BY department_id
			) #子查询没有必要写表名

#5.3 空值问题
SELECT last_name
FROM employees
#WHERE employee_id NOT IN (
#			SELECT manager_id #有null
#			FROM employees
#			)
WHERE employee_id NOT IN (
			SELECT manager_id
			FROM employees
			WHERE manager_id IS NOT NULL
			);			
#6. 相关子查询
#回顾：查询员工中工资大于公司平均工资的员工的last_name,salary和其department_id
#6.1 
SELECT last_name,salary,department_id
FROM employees
WHERE salary > (
		SELECT AVG(salary)
		FROM employees
		);
		
#题目：查询员工中工资大于本部门平均工资的员工的last_name,salary和其department_id
#方式1：使用相关子查询
SELECT last_name,salary,department_id
FROM employees e1
WHERE salary > (
		SELECT AVG(salary)
		FROM employees e2
		WHERE department_id = e1.`department_id`
		);

#方式2：在FROM中声明子查询
#如果有个表，各个部门对应的平均工资，然后找对应部门的平均工资满足大于的关系
SELECT department_id,AVG(salary)
FROM employees
GROUP BY department_id #将结果放入到from中

		
SELECT e.last_name,e.salary,e.department_id
FROM employees e,(
		SELECT department_id,AVG(salary) avg_sal #充当表具体字段出现，需要写别名，这里不是函数功能
		FROM employees
		GROUP BY department_id) t_dept_avg_sal
		
WHERE e.department_id = t_dept_avg_sal.department_id #两张表有连接条件
AND e.salary > t_dept_avg_sal.avg_sal


#题目：查询员工的id,salary,按照department_name 排序 (Order by中使用子查询)
#结合employees表找到每个员工在 departments中的对应的department_id,从而找到department_name,最后排序
SELECT department_name
FROM departments d
WHERE e.department_id = d.department_id 

#正确
SELECT employee_id,salary
FROM employees e
ORDER BY (
	 SELECT department_name
	 FROM departments d
	 WHERE e.`department_id` = d.`department_id`
	) ASC;

#结论：在SELECT中，除了GROUP BY 和 LIMIT之外，其他位置都可以声明子查询！

/*
SELECT ....,....,....(存在聚合函数)
FROM ... (LEFT / RIGHT)JOIN ....ON 多表的连接条件 
(LEFT / RIGHT)JOIN ... ON ....
WHERE 不包含聚合函数的过滤条件
GROUP BY ...,....
HAVING 包含聚合函数的过滤条件
ORDER BY ....,...(ASC / DESC )
LIMIT ...,....
*/

#题目：若employees表中employee_id与job_history表中employee_id相同的数目不小于2，
#输出这些相同id的员工的employee_id,last_name和其job_id

SELECT *
FROM job_history;

SELECT employee_id,last_name,job_id
FROM employees e
WHERE 2 <= (
	    SELECT COUNT(*)
	    FROM job_history j
	    WHERE e.`employee_id` = j.`employee_id`
		)

#6.2 EXISTS 与 NOT EXISTS关键字

#题目：查询公司管理者的employee_id，last_name，job_id，department_id信息
#方式1：自连接
SELECT DISTINCT mgr.employee_id,mgr.last_name,mgr.job_id,mgr.department_id
FROM employees emp JOIN employees mgr
ON emp.manager_id = mgr.employee_id;

#方式2：子查询

SELECT employee_id,last_name,job_id,department_id
FROM employees
WHERE employee_id IN (
			SELECT DISTINCT manager_id
			FROM employees
			);

#方式3：使用EXISTS
# 如果在子查询中不存在满足条件的行，条件返回false,继续在子查询中查找
# 如果在子查询中存在满足条件的行，不在子查询中继续查找，条件返回true
SELECT employee_id,last_name,job_id,department_id
FROM employees e1
WHERE EXISTS (
	       SELECT *
	       FROM employees e2
	       WHERE e1.`employee_id` = e2.`manager_id`
	     );

#题目：查询departments表中，不存在于employees表中的部门的department_id和department_name

#方式1：
SELECT d.department_id,d.department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.`department_id` IS NULL;

#方式2：
SELECT department_id,department_name
FROM departments d
WHERE NOT EXISTS (
		SELECT *
		FROM employees e
		WHERE d.`department_id` = e.`department_id`
		);

SELECT COUNT(*)
FROM departments;



