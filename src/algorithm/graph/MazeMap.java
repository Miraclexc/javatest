package algorithm.graph;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

public class MazeMap {
	public static final Point[] RMDIRECTION = new Point[] {Point.valueOf(2, 0), Point.valueOf(0, 2), Point.valueOf(-2, 0), Point.valueOf(0, -2)};
	public static final Point[] STEPDIRECTION = new Point[] {Point.valueOf(1, 0), Point.valueOf(0, 1), Point.valueOf(-1, 0), Point.valueOf(0, -1)};
	
	private Map<Point, Integer> points;
	private short width;
	private short height;
	
	public MazeMap(short width, short height) {
		this.width = width;
		this.height = height;
		
		this.points = new HashMap<>();
	}
	
	/**
	 * 初始化迷宫并将各个点初始化
	 */
	public void init(int value) {
		for(short i=0;i<this.width;i++) {
			for(short j=0;j<this.height;j++) {
				this.points.put(Point.valueOf(i, j), value);
			}
		}
	}
	
	public Map<Point, Integer> getPoints() {
		return this.points;
	}

	public short getWidth() {
		return this.width;
	}

	public short getHeight() {
		return this.height;
	}

	/**
	 * 深度优先算法随机生成迷宫
	 */
	public static MazeMap randomMaze(short width, short height) {
		MazeMap maze = new MazeMap(width, height);
		maze.init(1);
		//起始点
		Point start = Point.valueOf(1, 1);
		//Point end = Point.valueOf(width - 2, height - 2);
		
		//初始化状态表
		Map<Point, Boolean> state = new HashMap<>();
		//初始化要遍历的点
		List<Point> unvisit = new LinkedList<>();
		maze.getPoints().entrySet().forEach(i -> {
			if(i.getKey().getX() % 2 == 1 && i.getKey().getY() % 2 == 1) {
				unvisit.add(i.getKey());
				state.put(i.getKey(), false);
			}
		});
		
		//初始化将要访问的点的列表和访问过的点的列表
		LinkedList<Point> willvisit = new LinkedList<>();
		
		//初始化随机器
		Random random = new Random();
		
		//标记起始点
		Point point = start;
		state.put(point, true);
		maze.getPoints().put(point, 0);
		
		//遍历开始
		while(!unvisit.isEmpty()) {
			
			Point point_ = point;
			Point[] un = Arrays.stream(RMDIRECTION).filter(i -> {
				Point newPoint = point_.add(i);
				Boolean b = state.get(newPoint);
				if(b != null && b == false) {
					return true;
				}
				return false;
			}).toArray(Point[]::new);
			if(un.length > 0) {
				Point randomPoint = un[(int) Math.round(random.nextDouble() * (un.length - 1))];
				Point newPoint = point.add(randomPoint);
				willvisit.add((int) (random.nextDouble() * willvisit.size()), newPoint);
				unvisit.remove(newPoint);

				Point wall = point.add((short) (randomPoint.getX() / 2), (short) (randomPoint.getY() / 2));
				maze.getPoints().put(wall, 0);
				
				maze.getPoints().put(newPoint, 0);
				state.put(newPoint, true);
				point = newPoint;
			} else if(!willvisit.isEmpty()) {
				point = willvisit.removeFirst();
			} else {
				break;
			}
		}
		
		return maze;
	}
	
	/**
	 * 打印迷宫
	 */
	public static void print(MazeMap maze, Function<Integer, ? extends String> decodeState) {
		for(int i=0;i<maze.width;i++) {
			StringBuffer sb = new StringBuffer();
			for(int j=0;j<maze.height;j++) {
				sb.append(decodeState.apply(maze.getPoints().get(Point.valueOf(i, j))));
			}
			System.out.println(sb.toString());
		}
	}
	
	/**
	 * 绘制迷宫
	 */
	public static void draw(MazeMap maze, Function<Integer, ? extends String> decodeState) {
		new Shower(maze.getWidth() * 14, maze.getHeight() * 14, new Canvas() {
			private static final long serialVersionUID = 1L;

			public void paint(Graphics graphics) {
				for(int i=0;i<maze.width;i++) {
					for(int j=0;j<maze.height;j++) {
						graphics.drawString(decodeState.apply(maze.getPoints().get(Point.valueOf(i, j))), (i + 1) * 12, (j + 1) * 12);
					}
				}
			}
		});
	}
	
	/**
	 * 广度优先算法寻找最短路径
	 * 
	 * @param pass 可通过的数字
	 * @param sign 寻到路后的标记
	 */
	public static void searchWay(MazeMap maze, int pass, int sign, Point start, Point end, int startSign, int endSign) {
		if(start == null) {
			start = Point.valueOf(1, 1);
		}
		if(end == null) {
			end = Point.valueOf(maze.width - 2, maze.height - 2);
		}
		
		//点是否已经被访问过
		Map<Point, Boolean> state = new HashMap<>();
		maze.getPoints().entrySet().forEach(i -> {
			if(i.getKey().getX() > 0 && i.getKey().getY() > 0 && i.getKey().getX() < maze.width - 1 && i.getKey().getY() < maze.height - 1) {
				state.put(i.getKey(), false);
			}
		});
		
		//点的关系表
		Map<Point, Point> parents = new HashMap<>();
		
		LinkedList<Point> willvisit = new LinkedList<>();
		willvisit.add(start);
		
		while(!willvisit.isEmpty()) {
			Point point = willvisit.removeFirst();
			for(Point direction : STEPDIRECTION) {
				Point newPoint = point.add(direction);
				if(state.containsKey(newPoint) && maze.getPoints().get(newPoint) == pass) {
					if(!state.get(newPoint)) {
						parents.put(newPoint, point);
						willvisit.addLast(newPoint);
					}
				}
			}
			state.put(point, true);
			if(end.equals(point)) {
				Point tempPoint = end;
				while(tempPoint != null) {
					maze.getPoints().put(tempPoint, sign);
					tempPoint = parents.get(tempPoint);
				}
				maze.getPoints().put(start, startSign);
				maze.getPoints().put(end, endSign);
				break;
			}
		}
	}
}
