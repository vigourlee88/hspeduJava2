-- 演示mysql的统计函数的使用
-- 统计一个班级共有多少学生 COUNT(*)之间不能有空格
SELECT COUNT(*) FROM student
-- 统计数学成绩大于90的学生有多少个
SELECT COUNT(*) FROM student
       WHERE math > 90;
-- 统计总分大于250的人数有多少
SELECT COUNT(*) FROM student
       WHERE (chinese+english+math) > 250
       
-- count(*)和count(列)的区别
-- 解释 count(*)返回满足条件的记录的行数
-- count(列) 统计满足条件的某列有多少个，但是会排除 为null
CREATE TABLE t15(
     `name` VARCHAR(20));
INSERT INTO t15 VALUES('tom');
INSERT INTO t15 VALUES('jack');
INSERT INTO t15 VALUES('mary');
INSERT INTO t15 VALUES(NULL);
SELECT * FROM t15;
SELECT COUNT(*) FROM t15;-- 4
SELECT COUNT(`name`) FROM t15;-- 返回非空的name有几行 3

-- 演示sum函数的使用
-- 统计一个班级数学总成绩
SELECT SUM(math) FROM student;
-- 统计一个班级语文，英语，数学各科的总成绩
SELECT SUM(math) AS math_total_score,SUM(chinese),SUM(english) FROM student;
-- 统计一个班级语文，英语，数学的成绩总和
SELECT SUM(chinese+math+english) AS total_score FROM student;
-- 统计一个班级语文成绩平均分
SELECT SUM(chinese)/COUNT(*) FROM student;
-- sum 仅对数值起作用
-- 对多列求和，","逗号不能少

-- 演示avg的使用
-- 练习
-- 求一个班级数学平均分
SELECT AVG(math) FROM student;
-- 求一个班级总平均分
SELECT AVG(math+english+chinese)  FROM student ;


-- 演示Max/min的使用
-- max/min函数返回满足where条件的一列的最大/最小值
-- 求班级最高分、最低分(数值范围在统计中特别有用)
SELECT MAX(math+english+chinese),
       MIN(math+english+chinese) FROM student;
-- 求班级数学最高分、最低分      
SELECT MAX(math) AS math_high_score,
       MIN(math) AS math_low_score 
       FROM student;