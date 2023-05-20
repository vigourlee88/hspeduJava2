#delete语句演示
-- 删除表中的名称为'老妖怪'的记录
DELETE FROM employee 
    WHERE user_name = '老妖怪'
SELECT * FROM employee

-- 删除表中   所有记录，一定要小心
DELETE FROM employee;
-- 使用细节
-- 1.如果不使用where子句，将删除表中所有数据
-- 2.delete 语句不能删除某一列的值，(可使用update设置为null或者'')
UPDATE employee SET job = '' WHERE user_name = '老妖怪';
-- 3.使用delete语句仅删除记录，不删除表本身。
--   如果删除表，使用drop table语句。drop table 表名; 