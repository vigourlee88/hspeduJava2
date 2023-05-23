-- 演示流程控制语句
-- if(expr1,expr2,expr3) 如果expr1为true,则返回expr2,否则返回expr3
SELECT IF(TRUE,'北京','上海') FROM DUAL;
-- ifnull(expr1,expr2) 如果expr1不为空null,则返回expr1,否则返回expr2
SELECT IFNULL(NULL,'韩顺平教育') FROM DUAL;
SELECT CASE 
    WHEN TRUE THEN 'jack' 
    WHEN FALSE THEN 'tom' 
    ELSE 'mary' END
-- 查询emp表,如果comm是null，则显示0.0
-- 判断是否为空，使用is null,判断不为空is not
SELECT ename,IF(comm IS NULL,0.0,comm)
      FROM emp;
      
SELECT ename,IFNULL(comm,0.0)
      FROM emp;      
-- 如果emp表的job是clerk则显示职员
-- 如果是Manager则显示经理
-- 如果是salasman则显示销售人员，其他正常显示
SELECT ename,job ,(SELECT CASE
            WHEN job ='CLERK' THEN '职员' 
            WHEN job ='MANAGER' THEN '经理' 
            WHEN job ='SALESMAN' THEN '销售职员'
	    ELSE job END) AS 'job',job
       FROM emp ;
SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;	    