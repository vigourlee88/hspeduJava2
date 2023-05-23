-- 日期时间相关函数

-- current_date()  当前日期
SELECT CURRENT_DATE() FROM DUAL;
-- current_time() 当前时间
SELECT CURRENT_TIME() FROM DUAL;
-- CURRENT_timestamp()  当前时间戳
SELECT CURRENT_TIMESTAMP() FROM DUAL;

-- 创建测试表  信息表
CREATE TABLE mes(
     id INT,
     content VARCHAR(30),
     send_time DATETIME);

-- 添加一条记录
INSERT INTO mes
        VALUES(1,'北京新闻',CURRENT_TIMESTAMP());
INSERT INTO mes
        VALUES(2,'上海新闻',NOW());
INSERT INTO mes
        VALUES(3,'广州新闻',NOW());

SELECT * FROM mes;
SELECT NOW() FROM DUAL;

-- 应用实例
-- 显示所有新闻信息，发布日期只显示，不用显示时间
SELECT id,content,DATE(send_time) 
        FROM mes;
-- 请查询在10分钟内发布的帖子
SELECT * FROM mes
        WHERE DATE_ADD(send_time,INTERVAL 10 MINUTE) >= NOW()

SELECT * FROM mes
        WHERE send_time >= DATE_SUB(NOW(),INTERVAL 10 MINUTE)
-- 请在mysql的SQL语句中求出2011-11-11和1990-1-1相差多少天
SELECT DATEDIFF('2011-11-11','1990-01-01') FROM DUAL;
-- 请用mysql的SQL语句求出你活了多少天
SELECT DATEDIFF(NOW(),'1986-11-11') FROM DUAL;
-- 如果你能活80岁，求出你还能活多久1986-11-11
-- 先求出活80岁，是什么日期x
-- 然后在使用datediff(x,now())
-- INTERVAL 80 YEAR,YEAR可以是 年月日时分秒
-- '1986-11-11' 可以是 date ，datetime，timestamp
SELECT DATEDIFF(DATE_ADD('1986-11-11',INTERVAL 80 YEAR),NOW()) 
            FROM DUAL;
SELECT TIMEDIFF('10:11:11','06:10:10') FROM DUAL;

-- year/month/day/ date (datetime)
SELECT YEAR(NOW()) FROM DUAL;
SELECT MONTH(NOW()) FROM DUAL;
SELECT DAY(NOW()) FROM DUAL;
SELECT YEAR('2013-10-10') FROM DUAL;
-- unix_timestamp()返回1970-01-01到现在的秒数
SELECT UNIX_TIMESTAMP() FROM DUAL;
-- from_unixtime(秒数) 可以把一个unix_timestamp()秒数，转成指定格式的日期
-- '%y-%m-%d'格式是规定好的，表示年月日
-- 意义 在开发中，经常使用int来保存一个unix时间戳，
-- 可以存放一个整数，然后表示时间，通过FROM_UNIXTIME转换
SELECT FROM_UNIXTIME(1684649578,'%y-%m-%d') FROM DUAL;