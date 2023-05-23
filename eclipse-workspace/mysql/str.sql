#演示字符串相关函数的使用，使用emp来演示
-- charset(str) 返回字符串字符集
SELECT CHARSET(ename) FROM emp;
-- concat (string2 [,...])连接字串,将多个列拼接成一列
SELECT CONCAT(ename,' job is ',job) FROM emp;
-- instr (String,substring) 返回substring在string中出现的位置，没有返回0
-- dual 亚元表 系统表 可以作为测试表使用
SELECT INSTR('hanshunping','ping') FROM DUAL;
-- ucase(string2) 转换成大写
SELECT UCASE(ename) FROM emp;
-- lcase(string2) 换换成小写
SELECT LCASE(ename) FROM emp;
-- left(string2,length) 从string2中的左边起取length个字符
SELECT LEFT(ename,2) FROM emp;
SELECT RIGHT(ename,2) FROM emp;
-- length(string)  string长度(按照字节)
SELECT LENGTH(ename) FROM emp;
SELECT LENGTH('韩顺平') FROM emp;-- 按照字节 3+6
SELECT LENGTH('hsp') FROM emp;  -- 3
-- replace(str,search_str,replace_str) 
-- 在str中用replace_str替换search_str
SELECT ename,REPLACE(job,'manager','经理') FROM emp;
-- strcmp(string1,string2) 
-- 逐字符比较两字串大小
SELECT STRCMP('hsp','jsp') FROM DUAL;-- 本表不区分大小写
-- substring (str,position[,length])
-- 从str的position开始 (从1开始计算)，取length个字符
-- 从ename列的第一个位置开始取出2个字符
SELECT SUBSTRING(ename,1,2) FROM emp;
-- ltrim(string2) rtrim(string2) trim(string)
-- 去除前端或者后端的空格
SELECT LTRIM(' 韩顺平教育') FROM DUAL;
SELECT RTRIM('韩顺平教育 ') FROM DUAL;
SELECT TRIM('  韩顺平教育 ') FROM DUAL;

-- 练习 以首字母小写的方式显示所有员工emp表的姓名
-- 方法1
-- 思路先取出ename的第一个字符，转成小写
-- 把它和后面的字符串进行拼接输出即可

SELECT CONCAT(LCASE(SUBSTRING(ename,1,1)),
             SUBSTRING(ename,2)) AS new_name
             FROM emp;
SELECT CONCAT(LCASE(LEFT(ename,1)),
             SUBSTRING(ename,2)) AS new_name
             FROM emp;


-- 方法2