-- 多列子查序 
-- 是指查询返回多个列数据的子查询语句
-- 如何查询与smith的部门和岗位完全相同的所有雇员
-- 并且不含smith本人

-- 分析1.得到ALLEN的部门和岗位
SELECT deptno,job
       FROM emp
       WHERE ename = 'ALLEN'
-- 分析2.把上面的查询当做子查询来使用，
-- 并且使用多列子查询的语法进行匹配   
SELECT * 
         FROM emp
         WHERE (deptno,job ) = (
                  SELECT deptno,job
		  FROM emp
		  WHERE ename = 'ALLEN'
         )AND ename != 'ALLEN'
-- 查询和宋江数学，英语，语文，成绩 完全相同的学生         
SELECT * FROM student 
-- 宋江的成绩为
SELECT  chinese,english,math
         FROM student
         WHERE `name` = '宋江'
SELECT * 
     FROM student 
     WHERE (chinese,english,math) = (
         SELECT  chinese,english,math
         FROM student
         WHERE `name` = '宋江'
         )