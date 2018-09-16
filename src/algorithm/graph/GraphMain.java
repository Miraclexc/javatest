package algorithm.graph;

import java.util.function.Function;

public class GraphMain {
	public static void main(String[] args) {
		MazeMap maze = MazeMap.randomMaze((short) 63, (short) 63);
		//MazeMap.print(maze, i -> i.toString());
		MazeMap.searchWay(maze, 0, 2, null, null , 3, 4);
		MazeMap.draw(maze, decodeState());
	}
	
	public static Function<Integer, ? extends String> decodeState() {
		return  i -> {
			if(i == 0) {
				return " ";
			} else if(i == 2) {
				return "﹟";
			} else if(i == 3) {
				return "→";
			} else if(i == 4) {
				return "@";
			} else {
				return "▇";
			}
		};
	}
}
