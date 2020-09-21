package mazeSolution;

public class Maze {
	int [][] maze;
	int row,col;
	LinkedStack<Point> sta;
	//SeqStack<Point> sta;
	Point[] move = { new Point(0,1),
					 new Point(1,0),
					 new Point(0,-1),
					 new Point(-1,0) };
	public Maze(int[][] map) {
		row = map.length + 2;
		col = map[0].length + 2;
		sta = new LinkedStack<Point>();
		//sta = new SeqStack<Point>(row * col);
		maze = new int[row][col];
		for(int i = 1; i < row - 1; i++)
			for(int j = 1; j < col - 1; j++)
				maze[i][j] = map[i-1][j-1];
	}
	
	public boolean findPath() {
		Point temp = null;
		int x,y,d,i,j;
		temp = new Point(1,1,-1);
		sta.push(temp);
		while(!sta.isEmpty()) {
			temp = sta.pop();
			x = temp.x;
			y = temp.y;
			d = temp.d+1;
			while(d<4) {
				i = x + move[d].x;
				j = y + move[d].y;
				if(maze[i][j] == 1) {
					temp = new Point(x,y,d);
					sta.push(temp);
					//System.out.print("(" + x + "," + y + ") ");
					x = i;
					y = j;
					maze[x][y]=-1;
					if(x == row - 2 && y == col - 2) {
						temp = new Point(x,y,-1);
						sta.push(temp);
						return true;
					}
					else
						d=0;
				}
				else
					d++;
			}
		}
		return false;
	}
	public Point[] getPath() {
		Point[] points = new Point[sta.list.size()];
		for(int i=points.length-1; i >= 0;i--) {
			points[i] = sta.pop();
			//System.out.println(points[i]);
		}
		return points;
	}
}
