
#第09章_子查询课后练习题1

#1.查询和Zlotkey相同部门的员工姓名和工资
SELECT last_name,salary
FROM employees 
WHERE department_id IN (
                       SELECT department_id
                       FROM employees 
                       WHERE last_name = 'ZlotKey' #有可能有多个人叫这个名字
  
                       );

#2.查询工资比公司平均工资高的员工的员工号，姓名和工资。
SELECT employee_id,last_name,salary
FROM employees
WHERE salary > (
                SELECT AVG(salary)
                FROM employees

                );

#3.选择工资大于所有JOB_ID = 'SA_MAN'的员工的工资的员工的last_name, job_id, salary

SELECT last_name,job_id,salary
FROM employees 
WHERE salary > ALL(
               SELECT salary
               FROM employees 
               WHERE job_id = 'SA_MAN'    #多条数据,大于所有的
                
                );



#4.查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
SELECT employee_id,last_name
FROM employees
WHERE department_id IN (
         
         SELECT DISTINCT department_id  #需要去重
         FROM employees
         WHERE last_name LIKE '%u%' #多条数据
         
         );

#5.查询在部门的location_id为1700的部门工作的员工的员工号
SELECT * FROM employees
SELECT * FROM locations
SELECT * FROM departments


SELECT employee_id
FROM employees e,departments d
WHERE e.department_id = d.department_id
AND location_id = 1700


SELECT employee_id
FROM employees
WHERE department_id IN (
              SELECT department_id
              FROM departments
              WHERE location_id = 1700
           );

#6.查询管理者是King的员工姓名和工资
SELECT last_name,salary,manager_id
FROM employees
WHERE manager_id  IN (                   #manager_id =100,156
                       SELECT employee_id
                       FROM employees
                       WHERE last_name = 'King' #King的employee_id 100,156
  
                        );

#7.查询工资最低的员工信息: last_name, salary
SELECT last_name,salary
FROM employees
WHERE salary = (
	    SELECT MIN(salary)
	    FROM employees
                   );

#8.查询平均工资最低的部门信息
#子查询 复杂 从里往外写

#查询各个部门的平均工资 要分组
SELECT AVG(salary) avg_sal
FROM employees
GROUP BY department_id #看成一个新表 t_dept_avg_sal 放入到from中当成一个字段

#最少平均工资
SELECT MIN(avg_sal)
FROM (
        SELECT AVG(salary) avg_sal #起别名 固定下来
	FROM employees
	GROUP BY department_id 

      ) t_dept_avg_sal #起表名 固定下来

#哪个部门的平均工资等于最少平均工资 
SELECT department_id  #50
FROM employees
GROUP BY department
HAVING AVG(salary) = (#上面的最少平均工资)

SELECT *
FROM departments
WHERE department_id = (#上面department_id = 50)



#方式1
SELECT *
FROM departments
WHERE department_id = (
			     SELECT department_id
			     FROM employees
			     GROUP BY department_id
			     HAVING AVG(salary) =(
						   SELECT MIN(avg_sal)
						   FROM (
							 SELECT AVG(salary) avg_sal
							 FROM employees
							 GROUP BY department_id
							 
							 ) t_dept_avg_sal
						   
		                                )
     
                       );
                       
 #方式2
 SELECT * 
 FROM departments
 WHERE department_id = (
                        SELECT department_id
                        FROM employees
                        GROUP BY department_id
                        HAVING AVG(salary) <= ALL(
                                              SELECT AVG(salary)
                                              FROM employees
                                              GROUP BY department_id
                                             )
 
                        ); 
                        
#方式3 limit

SELECT AVG(salary) avg_sal
FROM employees
GROUP BY department_id
ORDER BY avg_sal ASC
LIMIT 0,1

SELECT * 
FROM departments
WHERE department_id = (
		SELECT department_id
		FROM employees
		GROUP BY department_id
		HAVING AVG(salary) = ();
		
#正确
SELECT *
FROM departments
WHERE department_id = (
		SELECT department_id
		FROM employees
		GROUP BY department_id
		HAVING AVG(salary) = (
		
				SELECT AVG(salary) avg_sal
				FROM employees
				GROUP BY department_id
				ORDER BY avg_sal ASC
				LIMIT 0,1
				      )
		
		 );
				

#方式4
SELECT department_id,AVG(salary) avg_sal
FROM employees
GROUP BY department_id
ORDER BY avg_sal ASC
LIMIT 0,1

SELECT d.* 
FROM departments d,(
                SELECT department_id,AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id
		ORDER BY avg_sal ASC
		LIMIT 0,1
                  ) t_dept_avg_sal
WHERE d.department_id = t_dept_avg_sal.department_id
                                             

#9.查询平均工资最低的部门信息和该部门的平均工资（相关子查询）

#方式1
SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.department_id) avg_sal
FROM departments d
WHERE department_id = (
			     SELECT department_id
			     FROM employees
			     GROUP BY department_id
			     HAVING AVG(salary) =(
						   SELECT MIN(avg_sal)
						   FROM (
							 SELECT AVG(salary) avg_sal
							 FROM employees
							 GROUP BY department_id
							 
							 ) t_dept_avg_sal
						   
		                                )
     
                       );
 
                       
 #方式2
 SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.department_id) avg_sal
 FROM departments d
 WHERE department_id = (
                        SELECT department_id
                        FROM employees
                        GROUP BY department_id
                        HAVING AVG(salary) <= ALL(
                                              SELECT AVG(salary)
                                              FROM employees
                                              GROUP BY department_id
                                             )
 
                        ); 
                        
#方式3 limit

SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.department_id) avg_sal
FROM departments d
WHERE department_id = (
		SELECT department_id
		FROM employees
		GROUP BY department_id
		HAVING AVG(salary) = (
		
				SELECT AVG(salary) avg_sal
				FROM employees
				GROUP BY department_id
				ORDER BY avg_sal ASC
				LIMIT 0,1
				      )
		
		 );
				

#方式4

SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.department_id) avg_sal 
FROM departments d,(
                SELECT department_id,AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id
		ORDER BY avg_sal ASC
		LIMIT 0,1
                  ) t_dept_avg_sal
WHERE d.department_id = t_dept_avg_sal.department_id                      

#10.查询平均工资最高的 job 信息
#1.平均工资
SELECT AVG(salary) avg_sal
FROM employees
GROUP BY job_id
#2.放入到from中
FROM (
	SELECT AVG(salary) avg_sal
	FROM employees
	GROUP BY job_id
     )t_dept_avg_sal
#3.查询字段avg_sal    
SELECT avg_sal
FROM (
	SELECT AVG(salary) avg_sal
	FROM employees
	GROUP BY job_id
     )t_job_avg_sal
     
#4.查询最高平均工资
SELECT MAX(avg_sal) #24000   
FROM (
	SELECT AVG(salary) avg_sal
	FROM employees
	GROUP BY job_id
     )t_job_avg_sal 
     
#5.哪一个job_id  
SELECT job_id
FROM employees
GROUP BY job_id
HAVING   AVG(salary) = (#24000)

SELECT job_id
FROM employees
GROUP BY job_id
HAVING   AVG(salary) = (
                        SELECT MAX(avg_sal) #24000   
			FROM (
				SELECT AVG(salary) avg_sal
				FROM employees
				GROUP BY job_id
			     )t_job_avg_sal 

                         )
#方式1
SELECT *
FROM jobs
WHERE job_id =   (

		SELECT job_id
		FROM employees
		GROUP BY job_id
		HAVING   AVG(salary) = (
					SELECT MAX(avg_sal) #24000   
					FROM (
						SELECT AVG(salary) avg_sal
						FROM employees
						GROUP BY job_id
					     )t_job_avg_sal 

                                       )
                 );
                 
#方式2
SELECT *
FROM jobs
WHERE job_id =   (

		SELECT job_id
		FROM employees
		GROUP BY job_id
		HAVING   AVG(salary) >= ALL(
						SELECT AVG(salary) 
						FROM employees
						GROUP BY job_id

                                           )
                 );   
#方式3
SELECT *
FROM jobs
WHERE job_id =   (

		SELECT job_id
		FROM employees
		GROUP BY job_id
		HAVING   AVG(salary) = (
					SELECT AVG(salary) avg_sal
					FROM employees
					GROUP BY job_id
					ORDER BY avg_sal
					LIMIT 0,1

                                           )
                 );  
                  
#方式4                                                        
SELECT j.*
FROM jobs j,(
		SELECT job_id, AVG(salary) avg_sal
		FROM employees
		GROUP BY job_id
		ORDER BY avg_sal DESC
		LIMIT 0,1
					
            )t_job_avg_sal
WHERE j.job_id = t_job_avg_sal.job_id
                       
                                                                                                                  
                         
#11.查询平均工资高于公司平均工资的部门有哪些?
#公司平均工资
SELECT AVG(salary)
FROM employees

#按部门分组
SELECT department_id
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
HAVING AVG(salary) > (
                       SELECT AVG(salary)
                       FROM employees
                      );
                      

#12.查询出公司中所有 manager 的详细信息
SELECT *
FROM employees

#方式1：自连接  xxx worked for xxx
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

#13.各个部门中 最高工资中最低的那个部门的 最低工资是多少?
#最高工资按部门分组
SELECT MAX(salary)
FROM employees
GROUP BY department_id

#这里面找最低的工资
SELECT MIN(max_sal)
FROM (
	SELECT MAX(salary) max_sal
	FROM employees
	GROUP BY department_id
      ) t_emp_max_sal

#方式1
SELECT department_id
FROM employees
GROUP BY department_id
HAVING MAX(salary) = (
							
			SELECT MIN(max_sal)
			FROM (
				SELECT MAX(salary) max_sal
				FROM employees
				GROUP BY department_id
			      ) t_emp_max_sal
                 
                       )
 #查询10部门的最低工资
 SELECT MIN(salary) 
 FROM employees
 WHERE department_id = (
                        SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING MAX(salary) = (
										
						SELECT MIN(max_sal)
						FROM (
							SELECT MAX(salary) max_sal
							FROM employees
							GROUP BY department_id
						      ) t_emp_max_sal
				 
                                             )
                        
                        )               

#方式2
SELECT MIN(salary) 
FROM employees
WHERE department_id = (
                        SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING MAX(salary) <= ALL(
						SELECT MAX(salary) 
						FROM employees
						GROUP BY department_id
 
                                                 )
                        
                        )               

#方式3
SELECT MIN(salary) 
FROM employees
WHERE department_id = (
                        SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING MAX(salary) = (
						SELECT MAX(salary) max_sal
						FROM employees
						GROUP BY department_id
						ORDER BY max_sal ASC
						LIMIT 0,1
 
                                                 )
                        
                        )               

#方式4
SELECT MIN(salary)
FROM employees e,(
                   SELECT department_id,MAX(salary) max_sal
                   FROM employees
                   GROUP BY department_id
                   ORDER BY max_sal ASC
                   LIMIT 0,1
                  ) t_dept_max_sal
WHERE e.department_id = t_dept_max_sal.department_id   #两个表需要连接条件


#14.查询平均工资最高的部门的 manager 的详细信息: last_name, department_id, email, salary
#平均工资按部门
FROM (
	SELECT AVG(salary) avg_sal
	FROM employees
	GROUP BY department_id
     ) t_dept_avg_sal
     
#SELECT avg_sal
SELECT MAX(avg_sal)
FROM (
	SELECT AVG(salary) avg_sal
	FROM employees
	GROUP BY department_id
     ) t_dept_avg_sal     

#平均工资最高 的部门
SELECT department_id
FROM employees 
GROUP BY department_id
HAVING AVG(salary) = (
                      SELECT MAX(avg_sal)
                      FROM (
			    SELECT AVG(salary) avg_sal
			    FROM employees
			    GROUP BY department_id
			     ) t_dept_avg_sal
                        )
#部门10的manager_id  
SELECT DISTINCT manager_id
FROM employees
WHERE department_id = (

                        SELECT department_id
			FROM employees 
			GROUP BY department_id
			HAVING AVG(salary) = (
					      SELECT MAX(avg_sal)
					      FROM (
						    SELECT AVG(salary) avg_sal
						    FROM employees
						    GROUP BY department_id
						     ) t_dept_avg_sal
						)
                       )                      
 #方式1
 SELECT last_name,department_id,email,salary
 FROM employees
 WHERE employee_id IN (  #多条记录，应该使用in,= ANY
 
                        SELECT DISTINCT manager_id
			FROM employees
			WHERE department_id = (

						SELECT department_id
						FROM employees 
						GROUP BY department_id
						HAVING AVG(salary) = (
								      SELECT MAX(avg_sal)
								      FROM (
									    SELECT AVG(salary) avg_sal
									    FROM employees
									    GROUP BY department_id
									     ) t_dept_avg_sal
									)
					       )       		 
 
                      )
#方式2                    
 SELECT last_name,department_id,email,salary
 FROM employees
 WHERE employee_id IN (  #多条记录，应该使用in,= ANY
 
                        SELECT DISTINCT manager_id
			FROM employees
			WHERE department_id = (

						SELECT department_id
						FROM employees 
						GROUP BY department_id
						HAVING AVG(salary) >= ALL(

									    SELECT AVG(salary) 
									    FROM employees
									    GROUP BY department_id
									     
									)
					       )       		 
 
                      )  
                      
#方式3
SELECT department_id ,AVG(salary) avg_sal
FROM employees
GROUP BY department_id
ORDER BY avg_sal DESC
LIMIT 0,1

SELECT DISTINCT manager_id
FROM employees e,(
		SELECT department_id ,AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id
		ORDER BY avg_sal DESC
		LIMIT 0,1
		) t_dept_avg_sal
WHERE e.department_id = t_dept_avg_sal.department_id #找部门90的

#正确
SELECT last_name,department_id,email,salary
FROM employees
WHERE employee_id IN (
			SELECT DISTINCT manager_id
			FROM employees e,(
					SELECT department_id ,AVG(salary) avg_sal
					FROM employees
					GROUP BY department_id
					ORDER BY avg_sal DESC
					LIMIT 0,1
					) t_dept_avg_sal
			WHERE e.department_id = t_dept_avg_sal.department_id #找部门90的
                        )
					      
							  
#15. 查询部门的部门号，其中不包括job_id是"ST_CLERK"的部门号

#方式1
SELECT DISTINCT department_id #50
FROM employees
WHERE job_id = 'ST_CLERK'

SELECT department_id
FROM departments
WHERE department_id NOT IN (
				SELECT DISTINCT department_id #50
				FROM employees
				WHERE job_id = 'ST_CLERK' 
							
                            )


#方式2
SELECT department_id
FROM departments d
WHERE NOT EXISTS (
              SELECT *
              FROM employees e
              WHERE d.department_id = e.department_id
              AND e.job_id = 'ST_CLERK' 
              ) 


#16. 选择所有没有管理者的员工的last_name
#有管理者的员工的last_name
SELECT last_name
FROM employees emp
WHERE NOT EXISTS (
               SELECT *
               FROM employees mgr
               WHERE emp.manager_id = mgr.employee_id
              )
              

#17．查询员工号、姓名、雇用时间、工资，其中员工的管理者为 'De Haan'

#方式1
SELECT employee_id,last_name,hire_date,salary
FROM employees 
WHERE manager_id IN (
                     SELECT employee_id
                     FROM employees 
                     WHERE last_name = 'De Haan'
                     
                     )
                     
#方式2
SELECT employee_id,last_name,hire_date,salary
FROM employees e1
WHERE EXISTS  (
                     SELECT *
                     FROM employees e2
                     WHERE e2.last_name = 'De Haan'
                     AND e1.manager_id = e2.employee_id
                     )
                     

#18.查询各部门中工资比本部门平均工资高的员工的员工号, 姓名和工资（相关子查询）

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


#19.查询每个部门下的部门人数大于 5 的部门名称（相关子查询）

SELECT department_name
FROM departments d
WHERE 5 < (
            SELECT COUNT(*)
            FROM employees e
            WHERE d.department_id = e.department_id
           )



#20.查询每个国家下的部门个数大于 2 的国家编号（相关子查询）

SELECT * FROM locations

SELECT country_id
FROM locations l
WHERE 2 < (
            SELECT COUNT(*)
            FROM departments d
            WHERE l.location_id = d.location_id  #传入country_id,找到location_id
           )


/* 
子查询的编写技巧（或步骤）：① 从里往外写  ② 从外往里写

如何选择？
① 如果子查询相对较简单，建议从外往里写。
一旦子查询结构较复杂，则建议从里往外写

② 如果是相关子查询(即用到外面的表)的话，通常都是从外往里写。

*/           
           