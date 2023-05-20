-- select语句
-- 查询姓名为赵云的学生成绩
SELECT * FROM student 
     WHERE `name` = '赵云';
-- 查询英语成绩大于90分的同学
SELECT * FROM student 
    WHERE english > 90;
-- 查询总分大于200分的所有同学
SELECT * FROM student
   WHERE (chinese+english+math)>200 
   
-- 查询math大于60并且(AND)id 大于4的学生成绩
SELECT * FROM student
    WHERE math > 60 AND id > 4
-- 查询英语成绩大于语文成绩的同学
SELECT * FROM student
    WHERE english > chinese
-- 查询总分大于200分 并且 数学成绩小于语文成绩，
-- 的姓赵的学生,LIKE 是模糊查询,'韩%'表示名字以 赵 开头的就可以。
SELECT * FROM student
    WHERE (chinese+english+math) > 200 AND
     math < chinese AND `name` LIKE '赵%'
-- 查询英语分数在80-90之间的同学
SELECT * FROM student
   WHERE english >=80 AND english <= 90
-- BETWEEN .. AND  ..是 闭区间 
SELECT * FROM student
   WHERE english BETWEEN 80 AND 90   
-- 查询数学分数为89,90,91的同学
SELECT * FROM student
   WHERE math = 89 OR math = 90 OR math = 91 
SELECT * FROM student
   WHERE math IN(89,90,91)   
-- 查询所有姓韩的学生成绩
SELECT * FROM student
   WHERE `name` LIKE '韩%'
-- 查询数学分>80,语文分>80的同学 
SELECT * FROM student
   WHERE math > 80 AND chinese >80   
   
-- 查询语文分数在70-80之间的同学
SELECT * FROM student
   WHERE chinese BETWEEN 70 AND 80
-- 查询总分为189,190,191的同学
SELECT * FROM student
   WHERE chinese+english+math IN (189,190,191)

-- 查询所有姓李或者 姓宋额学生成绩
SELECT * FROM student
   WHERE `name` LIKE '李%' OR  `name` LIKE '宋%'
-- 查询数学比语文多2分的同学    
SELECT * FROM student
   WHERE math -chinese = 2