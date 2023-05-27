-- MySQL用户的管理
-- 原因，当我们做项目开发时，可以根据不同的开发人员，
-- 赋给他相应的mysql操作权限
-- 所以，mysql数据库管理人员(root),根据需要创建不同的用户，
-- 赋给相应的权限，供开发人员使用

-- 1.创建新的用户
-- 解读 (1) 用户名'hsp_edu'@登录的ip地址'localhost'表示用户的完整信息
-- (2) 123456 密码，但是注意 存放到mysql.user表时，是password('123456')加密后的密码
CREATE USER 'hsp_edu'@'localhost' IDENTIFIED BY '1234567';
SELECT PASSWORD('1234567')
SELECT `host`,`user`,authentication_string
      FROM mysql.user;
      
-- 2.删除用户
DROP USER 'hsp_edu'@'localhost' 
-- 3.登录

-- root用户修改 hsp_edu@localhost密码
-- 是可以成功
-- 新版本8.0以上不支持以下使用

SET PASSWORD FOR 'hsp_edu'@'localhost' = PASSWORD('12345')
-- 解决方法username=hsp_edu hostname=localhost
ALTER USER 'hsp_edu'@'localhost' IDENTIFIED BY '1234'
