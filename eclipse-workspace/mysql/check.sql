-- 用于强制 行数据必须满足的条件
-- 假定在sal列上定义了check约束
-- 并要求sal列值在1000~2000之间
-- 如果不再1000~2000之间就会提示出错
-- oracle 和sql server均支持check,但是mysql5.7目前还不支持check,只做语法校验，但不会生效
-- 测试
CREATE TABLE t23(
    id INT PRIMARY KEY,
    `name` VARCHAR(32),
    sex VARCHAR(6) CHECK (sex IN('man','woman')),
    sal DOUBLE CHECK (sal > 1000 AND sal < 2000));

-- 添加数据
INSERT INTO t23
      VALUES(1,'jack','mid',1);
-- 在mysql中实现check的功能，一般是在程序中控制，
-- 或者通过触发器完成