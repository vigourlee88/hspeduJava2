-- mysql表 外连接
-- 前面我们学习的查询
-- 是利用where子句对两张表或者多张表，形成的笛卡尔积进行筛选
-- 根据关联条件，显示所有的匹配的记录，
-- 匹配不上的，不显示

-- 比如 列出部门名称和这些部门的员工名称和工作，
--  同时要求 显示出那些没有员工的部门
-- 使用我们学习过的多表查询的sql,看看效果如何
SELECT dname,ename,job
        FROM emp,dept
        WHERE emp.deptno = dept.deptno
        ORDER BY dname  --3个部门
        
SELECT * FROM dept;   --4个部门  
 
-- 外连接
-- 左外连接 (如果左侧的表完全显示 我们就说是左外连接)
-- 右外连接 (如果右侧的表完全显示 我们就说是右外连接)

-- 创建stu
CREATE TABLE stu(
      id INT,
      `name` VARCHAR(32));
INSERT INTO stu VALUES(1,'jack'),
                       (2,'tom'),
                       (3,'kity'),
                       (4,'nono');
SELECT * FROM stu;                       
-- 创建exam
/*
 id grade
 1   56
 2   76
 11   8

*/
CREATE TABLE exam(
   id INT,
   grade INT);
INSERT INTO exam VALUES(1,56),(2,76),(11,8);
SELECT * FROM exam; 

-- 使用左外连接(显示所有人的成绩，如果没有成绩，
-- 也要显示该人的姓名和id号，成绩显示为空)
SELECT `name`,stu.id,grade
       FROM stu,exam
       WHERE stu.id = exam.id;     -- 靠ID关联
-- 上面只显示jack和tom
-- 改成左外连接

-- select .. from 表1 left join 表2 on 条件

SELECT `name`,stu.id,grade
       FROM stu LEFT JOIN exam
       ON stu.id = exam.id;  
-- 上面显示  jack,tom,kity null,nono null       

-- 右连接 (显示所有成绩，如果没有名字匹配，显示空)
-- 即右边的表exam和左表没有匹配的记录，也会把右表的记录显示出来
SELECT `name`,stu.id,grade
       FROM stu RIGHT JOIN exam
       ON stu.id = exam.id; 
        
-- 列出部门名称和这些部门的员工信息 (名字和工作)
-- 同时列出哪些没有员工的部门名
-- 1.使用左连接实现
SELECT dname,ename ,job
     FROM dept LEFT JOIN emp
     ON dept.deptno = emp.deptno

-- 2.使用右连接实现
SELECT dname,ename ,job
     FROM emp RIGHT JOIN dept
     ON emp.deptno = dept.deptno
    