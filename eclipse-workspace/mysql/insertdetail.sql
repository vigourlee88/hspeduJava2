#说明insert语句的细节
-- 1.插入的数据应与字段的数据类型相同
--    比如把'abc'添加到int类型会错误
#添加不成功
INSERT INTO `goods` (id,goods_name,price)
       VALUES('abc','小米手机',2000);
#添加成功  mysql底层将 '30'转换成 int整型
INSERT INTO `goods` (id,goods_name,price)
       VALUES('30','小米手机',2000);
-- 2.数据的长度应在列的规定范围内，例如 
-- 不能将一个长度为80的字符串加入到长度为40的列中
INSERT INTO `goods` (id,goods_name,price)
       VALUES(40,'vivo手机vivo手机vivo手机vivo手机vivo手机',3000);
-- 3.在values中列出的数据位置必须与被加入的列的排列位置相对应
#以下添加不成功
INSERT INTO `goods` (id,goods_name,price)
       VALUES('vivo手机',30,2000);
#添加可以  列一般按照顺序写
INSERT INTO `goods` (goods_name,id,price)
       VALUES('vivo手机',30,2000);
-- 4.字符 和 日期型 数据应包含在单引号''中

-- 5.列可以插入空值(前提是该字段price列没有写not null 就允许为空)
INSERT INTO `goods` (id,goods_name,price)
       VALUES(40,'vivo手机',NULL);
-- 6.insert into tab_name(列名..) values (),(),()形式添加多条记录
INSERT INTO `goods` (id,goods_name,price)
       VALUES(50,'三星手机',2300),(60,'海尔手机',1800);
-- 7.如果是给表中的所有字段添加数据，可以不写前面的字段(列名)名称(id,goods_name,price)省略
INSERT INTO `goods` 
       VALUES(70,'IBM手机',5000);

-- 8.默认值的使用，当不给某个字段值时，如果有默认值就会添加，否则报错
    -- 如果某个列，没有指定not null，那么当添加数据时，没有给定值，则会默认给null
    -- 如果我们希望指定某个列的默认值，可以在创建表时指定    
INSERT INTO `goods` (id,goods_name)
       VALUES(80,'格力手机');

SELECT * FROM goods
DELETE FROM goods WHERE id = 50
-- 按照指定默认值添加
INSERT INTO `goods2` (id,goods_name)
       VALUES(10,'顺平手机');
       
SELECT * FROM goods2