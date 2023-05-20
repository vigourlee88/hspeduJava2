--  演示upedate语句
-- 要求 在上面创建的employee表中修改表中的记录
-- 1.将所有员工薪水修改为5000,
-- 如果没有带where 条件 会修改所有的记录，因此要小心
UPDATE employee SET salary = 5000;
-- 2.将姓名 小妖怪的员工的薪水修改为3000
UPDATE employee 
     SET salary = 3000
     WHERE user_name = '小妖怪';
-- 3.将老妖怪的薪水在原有的基础上增加1000
INSERT INTO employee 
     VALUES (200,'老妖怪','1990-11-11',
     '2000-11-11 10:10:10','捶背的',5000,
     '给大王捶背','d:\\a.jpg');
INSERT INTO employee
     VALUES(100,'小妖怪','2000-11-1',
     '2010-11-10 11:11:11','巡山的',3000,
     '大王叫我来巡山','');
-- 表名改为employee
RENAME TABLE emp TO employee
DESC employee

UPDATE employee 
     SET salary = salary +1000
     WHERE user_name = '老妖怪';
     
--可以修改多个列
UPDATE employee 
     SET salary = salary +1000,job = '出主意的'
     WHERE user_name = '老妖怪';
--  使用细节
-- 1.update语法可以用新值更新原有表行中的各列
-- 2.set子句指示要修改哪些列和要给予哪些值
-- 3.where子句指定应更新哪些行，
-- 如没有where子句，则更新所有的行(记录)，因此要小心
-- 4.如果需要修改多个字段 列，可以通过set 字段1 = 值1,字段2 = 值2....
SELECT * FROM employee;