-- 这里在默认情况下，shunpin用户只能看到一个默认的系统数据库
-- 刷新后看到表testdb ,在testdb数据库
SELECT * FROM news
INSERT INTO news VALUES(200,'上海新闻');

-- 能否修改，删除
UPDATE news SET content = '成都新闻'
            WHERE id = 100;
            
