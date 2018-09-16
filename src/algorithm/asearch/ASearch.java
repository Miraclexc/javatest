package algorithm.asearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ASearch {
	public final static int[] dx = { 0, -1, 0, 1, -1, -1, 1, 1 };
	public final static int[] dy = { -1, 0, 1, 0, 1, -1, -1, 1 };
	
	/*final static public int[][] map = {
		{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
	 	{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
	 	{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
	 	{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
	 	{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		{ 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
	 	{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
	 	{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
		{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
	 	{ 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
	 	{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
	 	{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
	 	{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };*/
	final static public int[][] map = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		 	{ 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		 	{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		 	{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
		 	{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
		 	{ 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
		 	{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1 },
		 	{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1 },
		 	{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1 },
		 	{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
		 	{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	 
	 public static void main(String[] args) {
	 	Point start = new Point(1, 1);
	 	Point end = new Point(10, 13);
	 	Stack<Point> stack = printPath(start, end);
	 	if(null==stack) {
	 		System.out.println("不可达");
	 	}else {
	 		while(!stack.isEmpty()) {
	 			System.out.print(stack.pop()+" -> ");
	 		}
	 		System.out.println();
	 	}
	 }
	 
	 public static Stack<Point> printPath(Point start, Point end) {
	 	ArrayList<Point> openTable = new ArrayList<Point>();
		ArrayList<Point> closeTable = new ArrayList<Point>();
		openTable .clear();
	 	closeTable.clear();
	 	Stack<Point> pathStack = new Stack<Point>();
	 	start.parent = null;
	 	Point currentPoint = new Point(start.x, start.y);
	 	boolean flag = true;
	    while(flag) {
	    	for (int i = 0; i < 8; i++) {
	    		int fx = currentPoint.x + dx[i];
	    		int fy = currentPoint.y + dy[i];
	    		Point tempPoint = new Point(fx,fy);
	    		if (map[fx][fy] == 1) {
	    			continue;
	    		} else {
	    		if(end.equals(tempPoint)) {
	    			flag = false;
	    			end.parent = currentPoint;
	    			break;
	    		}
	    		
	    		if(i<4) {
	    			tempPoint.G = currentPoint.G + 10;
	    		}else {
	    			tempPoint.G = currentPoint.G + 14;
	    		}
	    		
	    		tempPoint.H = Point.getDis(tempPoint,end);
	    		tempPoint.F = tempPoint.G + tempPoint.H;
	    		if(openTable.contains(tempPoint)) {
	    			int pos = openTable.indexOf(tempPoint );
	    			Point temp = openTable.get(pos);
	    			if(temp.F > tempPoint.F) {
	    				openTable.remove(pos);
	    				openTable.add(tempPoint);
	    				tempPoint.parent = currentPoint;
	    			}
	    		}else if(closeTable.contains(tempPoint)){
	    			int pos = closeTable.indexOf(tempPoint );
	    			Point temp = closeTable.get(pos);
	    			if(temp.F > tempPoint.F) {
	    				closeTable.remove(pos);
	    				openTable.add(tempPoint);
	    				tempPoint.parent = currentPoint;
	    			}
	    		}else {
	    			openTable.add(tempPoint);
	    			tempPoint.parent = currentPoint;
	    		}
	    		}
	    	}
	    	if(openTable.isEmpty()) {
	    		return null;
	    	}//无路径
	    	if(false==flag) {
	    		break;
	    	}//找到路径
	    	openTable.remove(currentPoint);
	    	closeTable.add(currentPoint);
	    	Collections.sort(openTable);
	    	currentPoint = openTable.get(0);
	    }//end while
	    Point node = end;
	    while(node.parent!=null) {
	    	pathStack.push(node);
	    	node = node.parent;
	    }    
	    return pathStack;
	}
}
