-- 演示数学相关函数

-- abs(num) 绝对值
SELECT ABS(-10) FROM DUAL;

-- bin (demical_number) 十进制转二进制
SELECT 10 FROM DUAL;
SELECT BIN(10) FROM DUAL;

-- ceiling (number2) 向上取整，得到比num2大的最小整数
SELECT CEILING(1.1) FROM DUAL;
SELECT CEILING(-1.1) FROM DUAL;

-- conv(number2,from_base,to_base) 进制转换
-- 下面的含义是 8是十进制的8，转成2进制输出
SELECT CONV(8,10,2) FROM DUAL;
SELECT CONV(16,16,10) FROM DUAL;-- 6+1*16=6+16=22

-- floor(number2) 向下取整，得到比num2小的最大整数
SELECT FLOOR(1.1) FROM DUAL;-- 1

-- format (number,demical_places) 保留小数位数(四舍五入)
SELECT 78.123458 FROM DUAL;
SELECT FORMAT(78.125458,2) FROM DUAL;
-- hex (decimalNumber) 转十六进制
SELECT HEX(5) FROM DUAL;
-- least (number,number2,[,...]) 求最小值
SELECT LEAST(0,1,-10,4) FROM DUAL;
-- mod (numerator,denominator) 求余
SELECT MOD(10,3) FROM DUAL;
-- rand ()  rand([seed]) 返回随机数 其范围为0<= v<= 1.0
-- 说明1.如果使用rand()每次返回不同的随机数 
--     2.如果使用rand(seed)返回随机数 ,如果seed不变，该随机数也不变了
SELECT RAND() FROM DUAL;
SELECT RAND(5) FROM DUAL;ed