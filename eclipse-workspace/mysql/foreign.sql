-- 外键演示
-- 用于定义主表和从表之间的关系
-- 外键约束要定义在从表上， 
-- 主表则必须具有主键约束 或是 unique约束
-- 当定义外键约束后，要求外键列数据必须
-- 在主表的主键列存在或是为null

-- 创建 主表my_class
CREATE TABLE my_class(
       id INT PRIMARY KEY, -- 班级编号
       `name` VARCHAR(32) NOT NULL DEFAULT '');

-- 创建 从表 my_stu
CREATE TABLE my_stu(
     id INT PRIMARY KEY, -- 学生编号
     `name` VARCHAR(32) NOT NULL DEFAULT '',
     class_id INT, -- 学生所在班级的编号
     -- 下面指定外键关系
     FOREIGN KEY (class_id) REFERENCES my_class(id));
-- 测试数据
INSERT INTO  my_class
       VALUES(100,'java'),(200,'web');    
INSERT INTO  my_class
       VALUES(300,'php');    

SELECT * FROM my_class;
INSERT INTO  my_stu
       VALUES(1,'tom',100);
INSERT INTO  my_stu
       VALUES(2,'jack',200);
      
INSERT INTO  my_stu
       VALUES(3,'hsp',300);
INSERT INTO  my_stu
       VALUES(4,'mary',400); -- 会失败，原因400号班级不存在       
INSERT INTO  my_stu
       VALUES(5,'king',NULL); --  可以，外键没有写not null     
      
SELECT * FROM my_stu;           

-- 外键的细节说明

-- 外键指向的表的字段，
-- 要求是primary key 或者是unique
-- 表的类型是innodb,这样的表才支持外键
-- 外键的字段的类型要和主键字段的类型一致(长度可以不同)
-- 外键字段的值，必须在主键字段中出现过，
-- 或者为null,前提是外键字段允许为null
-- 一旦建立主外键的关系，数据不能随意删除了
DELETE FROM my_class
      WHERE id = 100;-- 有一个外键指向主表id=100 a foreign key constraint fails