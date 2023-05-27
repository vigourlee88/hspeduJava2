-- 说明用户管理的细节

-- 1.创建用户的时候，如果不指定host,
-- 则为%，%表示所有ip都有连接权限
-- create user xxx;
CREATE USER jack
SELECT `host`,`user` FROM mysql.user
-- 2.你也可以这样指定
-- create user 'xxx'@'192.168.1.%'
-- 表示xxx用户在192.168.1.*的ip段的范围内可以登录mysql
CREATE USER 'smith'@'192.168.1.%'
-- 3.在删除用户的时候，如果host不是%,
-- 需要明确指定'用户'@'host值'
DROP USER jack -- 默认就是drop user 'jack'@'%'

DROP USER smith -- 报错Operation DROP USER failed for 'smith'@'%'
-- 必须写清楚
DROP USER 'smith'@'192.168.1.%'
