package chapter28;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessBoard {
	
	//定义属性
	private static int X = 6;//表示 col
	private static int Y = 6;//表示 row
	
	private static int[][] chessBoard = new int [Y][X];//棋盘
	private static boolean[] visited = new boolean[X*Y];//记录某个位置是否走过
	private static boolean finished = false;//记录马儿是否遍历完棋盘
	
	
	public static void main(String[] args) {
		
		int row = 2;
		int col = 2;
		
		//测试一把
		long start = System.currentTimeMillis();
		traversalChessBoard(chessBoard,row -1 ,col -1 , 1);
		long end = System.currentTimeMillis();
		
		System.out.println("遍历耗时=" + (end - start));
		
		//输出当前棋盘的情况
		for(int[] rows: chessBoard) {
			for(int step : rows) {//表示 该位置是马儿应该走的第几步
				System.out.print(step + "\t");
			}
			System.out.println();
		}
	}
	
	//写一个方法，对ps的各个位置，
    //可以走的下一个位置的次数进行排序，把可能走的下一个位置从小到大排序
	public static void sort(ArrayList<Point> ps) {
		ps.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return next(o1).size() - next(o2).size();
			}
		});
		
	}
	
	//编写最核心的算法，遍历棋盘，如果遍历成功，就把finished设置为 ture;
	//并且将马儿走的每一步，记录到chessBoard
	public static void traversalChessBoard(int[][] chessBoard,int row, int col, int step ) {
		
		//先把step 记录到chessBoard中
		chessBoard[row][col] = step;
		//把这个位置，设置为已经访问
		visited[row * X + col]= true;
		//获取当前位置 可以走的下一个位置 有哪些
		ArrayList<Point> ps = next(new Point(col,row));//col-x,row-y
		sort(ps);//排序
		//遍历
		while(!ps.isEmpty()) {
			//取出当前这个ps 一个位置点
			Point p = ps.remove(0);
			//判断该位置是否走过，如果没有走过，我们就递归遍历
			if(!visited[p.y*X + p.x]) {
				//递归遍历
				traversalChessBoard(chessBoard,p.y,p.x,step + 1);
				
			}	
		}
		
		//当退出while,看看是否遍历成功  
		//如果没有成功，就重置相应的值,然后进行回溯
		if(step < X*Y && !finished) {
			//重置
			chessBoard[row][col] = 0;
			visited[row*X+col] = false;
		}else {
			finished = true;
		}
		
	}
	
	
	//编写方法，可以获取当前位置，可以走的下一步的所有位置(java.aws.Point  point代表一个位置 (x,y))

	public static ArrayList<Point> next(Point curPoint ) {
		//创建一个ArrayList
		ArrayList<Point> ps = new ArrayList<>();
		
		//创建一个Point对象(),准备放入到 ps
		Point p1 = new Point();
		
		//判断是否可以走5的位置
		if((p1.x = curPoint.x-2) >= 0 && (p1.y = curPoint.y-1)>= 0) {
			ps.add(new Point(p1));//这里一定要new Point
		}
		//判断是否可以走6的位置
		if((p1.x = curPoint.x-1) >= 0 && (p1.y = curPoint.y-2)>= 0) {
			ps.add(new Point(p1));//这里一定要new Point
		}
		//判断是否可以走7的位置
		if((p1.x = curPoint.x+1) < X && (p1.y = curPoint.y-2)>= 0) {
			ps.add(new Point(p1));//这里一定要new Point
		}
		//判断是否可以走0的位置
		if((p1.x = curPoint.x+2) < X && (p1.y = curPoint.y-1)>= 0) {
			ps.add(new Point(p1));//这里一定要new Point
		}
		//判断是否可以走1的位置
		if((p1.x = curPoint.x+2) < X && (p1.y = curPoint.y+1) < Y) {
			ps.add(new Point(p1));//这里一定要new Point
		}
		//判断是否可以走2的位置
		if((p1.x = curPoint.x+1) < X && (p1.y = curPoint.y+2) < Y) {
			ps.add(new Point(p1));//这里一定要new Point
		}
		//判断是否可以走3的位置
		if((p1.x = curPoint.x-1) >= 0 && (p1.y = curPoint.y+2) < Y) {
			ps.add(new Point(p1));//这里一定要new Point
		}
		//判断是否可以走4的位置
		if((p1.x = curPoint.x-2) >= 0 && (p1.y = curPoint.y+1) < Y) {
			ps.add(new Point(p1));//这里一定要new Point
		}
		return ps;
	}

}
