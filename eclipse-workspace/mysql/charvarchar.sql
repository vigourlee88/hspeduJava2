#演示字符串类型使用char varchar
#注释的快捷键 shift+ctrl+c  取消 shift+ctrl+r 编辑-高级-取消注释
-- char(size)
-- 固定长度字符串 最大255字符
-- varchar(size) 0-65535
-- 可变长度字符串 最大65532字节 
-- utf8编码最大 21844 字符 预留1-3个字节用于记录大小
-- 如果表的编码是utf8 varchar(size)=(65532-3)/3=21844
-- 如果表的编码是gbk varchar(size)=(65532-3)/2=32766

CREATE TABLE t09(
    `name` CHAR(255));
DROP TABLE t10;   
CREATE TABLE t10(
    `name` VARCHAR(32766)) CHARSET gbk;