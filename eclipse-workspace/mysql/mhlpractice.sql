-- 创建满汉楼的数据库
CREATE DATABASE mhl;
-- 创建表 employee表(主键id,empId,name,pwd,job等)
CREATE TABLE employee (
	id INT PRIMARY KEY AUTO_INCREMENT, #自增
	empId VARCHAR(50) UNIQUE NOT NULL DEFAULT '',#员工号
	pwd CHAR(32) NOT NULL DEFAULT '',#密码md5
	NAME VARCHAR(50) NOT NULL DEFAULT '',#姓名
	job VARCHAR(50) NOT NULL DEFAULT '' #岗位
)CHARSET=utf8; 


# 添加测试数据
INSERT INTO employee VALUES(NULL, '6668612', MD5('123456'), '张三丰', '经理');
INSERT INTO employee VALUES(NULL, '6668622', MD5('123456'),'小龙女', '服务员');
INSERT INTO employee VALUES(NULL, '6668633', MD5('123456'), '张无忌', '收银员');
INSERT INTO employee VALUES(NULL, '666666', MD5('123456'), '老韩', '经理');

SELECT * FROM employee;
#餐桌表
CREATE TABLE diningTable (
	id INT PRIMARY KEY AUTO_INCREMENT, #自增, 表示餐桌编号
	state VARCHAR(20) NOT NULL DEFAULT '',#餐桌的状态
	orderName VARCHAR(50) NOT NULL DEFAULT '',#预订人的名字
	orderTel VARCHAR(20) NOT NULL DEFAULT ''
)CHARSET=utf8; 
INSERT INTO diningTable VALUES(NULL, '空','','');
INSERT INTO diningTable VALUES(NULL, '空','','');
INSERT INTO diningTable VALUES(NULL, '空','','');
SELECT * FROM diningTable

UPDATE diningTable SET state = '已经预定',orderName='jack',orderTel='110' WHERE id = 1
UPDATE diningTable SET state = '空',orderName='',orderTel='' WHERE id=1
#菜谱
CREATE TABLE menu (
	id INT PRIMARY KEY AUTO_INCREMENT, #自增主键，作为菜谱编号(唯一)
	NAME VARCHAR(50) NOT NULL DEFAULT '',#菜品名称
	TYPE VARCHAR(50) NOT NULL DEFAULT '', #菜品种类
	price DOUBLE NOT NULL DEFAULT 0#价格
)CHARSET=utf8; 

#测试数据
INSERT INTO menu VALUES(NULL, '八宝饭', '主食类', 10);
INSERT INTO menu VALUES(NULL, '叉烧包', '主食类', 20);
INSERT INTO menu VALUES(NULL, '宫保鸡丁', '热菜类', 30);
INSERT INTO menu VALUES(NULL, '山药拨鱼', '凉菜类', 14);
INSERT INTO menu VALUES(NULL, '银丝卷', '甜食类', 9);
INSERT INTO menu VALUES(NULL, '水煮鱼', '热菜类', 26);
INSERT INTO menu VALUES(NULL, '甲鱼汤', '汤类', 100);
INSERT INTO menu VALUES(NULL, '鸡蛋汤', '汤类', 16);

SELECT * FROM menu



#账单流水, 考虑可以分开结账, 并考虑将来分别统计各个不同菜品的销售情况
CREATE TABLE bill (
	id INT PRIMARY KEY AUTO_INCREMENT, #自增主键
	billId VARCHAR(50) NOT NULL DEFAULT '',#账单号可以按照自己规则生成 UUID
	menuId INT NOT NULL DEFAULT 0,#菜品的编号, 也可以使用外键
	nums SMALLINT NOT NULL DEFAULT 0,#份数
	money DOUBLE NOT NULL DEFAULT 0, #金额
	diningTableId INT NOT NULL DEFAULT 0, #餐桌
	billDate DATETIME NOT NULL ,#订单日期
	state VARCHAR(50) NOT NULL DEFAULT '' # 状态 '未结账' , '已经结账', '挂单'
)CHARSET=utf8;

SELECT * FROM bill;

INSERT INTO menu VALUES(NULL,?,?,?,0,?,NOW(),'未结账')
UPDATE diningTable SET state= '空' WHERE id=1
SELECT * FROM diningTable

-- 写出sql语句 可以返回菜品名和账单信息
SELECT bill.*,NAME AS name2
        FROM bill,menu
        WHERE bill.menuId = menu.id


-- 查看某个餐桌是否有未结账的账单
SELECT * FROM bill WHERE diningTableId = 1 AND state ='未结账' LIMIT 0,1;

SELECT * FROM menu
