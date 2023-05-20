-- 演示order by 使用  子句排序查询结果
-- 1.order by 指定排序的列，排序的列既可以是表中的列名，
-- 也可以是select语句指定的列名
-- Asc升序[默认],Desc降序
-- order by 子句应位于select 语句的


-- 对数学成绩排序后输出(升序)
SELECT * FROM student
         ORDER BY math;
--  对总分按从高到低的顺序输出(降序) --使用别名排序
SELECT  `name`,(chinese+english+math) AS total_score FROM student
         ORDER BY total_score DESC;
-- 对姓韩的学生成绩排序输出(升序) where + order by
SELECT `name`, (chinese+english+math) AS total_score FROM student 
         WHERE `name` LIKE '韩%'
         ORDER BY total_score;