#演示字符串类型的使用细节
#char(4)和varchar(4)这个4表示的是字符，
#而不是字节，不区分 字符是汉字还是字母
CREATE TABLE t11(
     `name` CHAR(4));
INSERT INTO t11 VALUES('abcd');
#汉字和字母都一样
INSERT INTO t11 VALUES('韩顺平');
SELECT * FROM t11;

CREATE TABLE t12(
     `name` VARCHAR(4));
#4个字符  ok
INSERT INTO t12 VALUES('韩顺平a');
INSERT INTO t12 VALUES('韩顺平好');
SELECT * FROM t12;
#如果varchar不够用，可以考虑使用mediumtext 或者longtext
CREATE TABLE t13(content TEXT,content2 MEDIUMTEXT,content3 LONGTEXT); 
INSERT INTO t13 VALUES('韩顺平教育','韩顺平教育100','安顺平教育1000~~');
SELECT * FROM t13;
DROP TABLE t13;