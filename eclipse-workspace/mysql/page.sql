-- 分页查询
-- 按照雇员的id号升序取出，每页显示3条记录，请分别显示第1页，第2页。。。
-- 基本语法 select ...limit start,rows
-- 表示从start+1行开始，取出rows行，start从0开始计算

-- 第1页
SELECT * FROM emp
      ORDER BY empno 
      LIMIT 0,3
-- 第2页
SELECT * FROM emp
      ORDER BY empno 
      LIMIT 3,3 
-- 第3页
SELECT * FROM emp
      ORDER BY empno 
      LIMIT 6,3   
-- 推导一个公式
SELECT * FROM emp
	  ORDER BY empno
	  LIMIT  每页显示记录数*(第几页-1),  每页显示记录数          