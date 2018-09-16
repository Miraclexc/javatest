package algorithm.graph;

public class Point {
	private static Point[][] CACHE;
	
	protected short x;
	protected short y;
	
	public Point(short x, short y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("(%d,%d)", this.x, this.y);
	}
	
	@Override
	public boolean equals(Object object) {
		if(this == object) {
			return true;
		}
		if(object instanceof Point) {
			Point point = (Point) object;
			return this.compare(point.getX(), point.getY());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.x << 16 | this.y;
	}
	
	public boolean compare(short x, short y) {
		return this.getX() == x && this.getY() == y;
	}
	
	public Point add(Point point) {
		return this.add(point.getX(), point.getY());
	}
	
	public Point add(short x, short y) {
		return Point.valueOf(this.getX() + x, this.getY() + y);
	}

	public short getX() {
		return this.x;
	}

	public short getY() {
		return this.y;
	}
	
	public static Point valueOf(short x, short y) {
		/*if(x < CACHE.length) {
			Point[] cy = CACHE[x];
			if(y < cy.length) {
				return cy[y];
			}
		}*/
		
		return new Point(x, y);
	}
	
	public static Point valueOf(int x, int y) {
		return valueOf((short) x, (short) y);
	}
	
	static {
		int cacheX = 32;
		int cacheY = 32;
		
		CACHE = new Point[cacheX][];
		for(int i=0;i<cacheX;i++) {
			CACHE[i] = new Point[cacheY];
			for(int j=0;j<cacheY;j++) {
				CACHE[i][j] = Point.valueOf(i, j);
			}
		}
	}
}
