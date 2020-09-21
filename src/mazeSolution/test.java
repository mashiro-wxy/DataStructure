package mazeSolution;

public class test {

	public static void main(String[] args) {
		int[][] map = { 
			     { 1, 0, 0, 1, 1, 1, 0, 1 }, 
			     { 1, 1, 0, 1, 1, 1, 0, 1 },
			     { 1, 1, 1, 1, 1, 0, 1, 1 }, 
			     { 0, 0, 0, 0, 1, 0, 1, 1 },
			     { 1, 1, 1, 0, 1, 1, 0, 1 }, 
			     { 1, 0, 1, 1, 1, 1, 1, 1 },
			     { 1, 0, 0, 0, 1, 0, 0, 1 }, 
			     { 0, 1, 1, 1, 1, 1, 1, 1 }}; 
		int row = map.length;
		int col = map[0].length;
		System.out.println("迷宫");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		Maze m = new Maze(map);
		if(m.findPath()) {
			Point[] points = m.getPath();
			System.out.println("可到达路径");
			for(int i = 0; i < points.length; i++) {
				System.out.print("(" + points[i].x + "," + points[i].y + ")");
			}
		} else
			System.out.println("无出路");
	}
}
