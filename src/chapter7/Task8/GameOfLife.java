package chapter7.Task8;

public class GameOfLife {
	
	final static int N = 20;
	final static int LIFETIME = 50;
	
	public static void main(String[] args) throws InterruptedException {
		
		int tick = 0;
		boolean[][] grid = getRandomGrid(N);
		
		UI ui = new UI(grid, LIFETIME);
		
		while(tick < LIFETIME) {
			
			boolean[][] tickGrid = grid.clone();
			
			for(int y = 0; y < grid.length; y++) {
				for(int x = 0; x < grid[y].length; x++) {
					int aliveNeighbors = getAliveNeighbors(grid, x, y);
					
					if(grid[y][x]) {
						if(aliveNeighbors < 2 || aliveNeighbors > 3) tickGrid[y][x] = false;
					} else if(aliveNeighbors == 3) tickGrid[y][x] = true;
				}
			}
						
			grid = tickGrid;
						
			ui.addGrid(grid, ++tick);
		}
		
		//ui.loop();
	}
	
	public static byte getAliveNeighbors(boolean[][] grid, int x, int y) {
		
		byte aliveNeighbors = 0;
		
		int right = 0;
		int left = grid.length - 1;
		int top = grid.length - 1;
		int bottom = 0;
		
		if(x < grid.length - 1) left = x + 1;
		if(x > 0) left = x - 1;
		if(y > 0) top = y - 1;
		if(y < grid.length - 1) bottom = y + 1;
		
		// direct
		if(grid[y][left]) aliveNeighbors++;
		if(grid[y][right]) aliveNeighbors++;
		if(grid[top][x]) aliveNeighbors++;
		if(grid[bottom][x]) aliveNeighbors++;
		
		// diagonal
		if(grid[top][left]) aliveNeighbors++;
		if(grid[bottom][right]) aliveNeighbors++;
		if(grid[top][right]) aliveNeighbors++;
		if(grid[bottom][left]) aliveNeighbors++; 
		
		return aliveNeighbors;
	}
	
	public static boolean[][] getRandomGrid(int n) {
		
		boolean[][] grid = new boolean[n][n];
		
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				if(Math.random() > 0.5) grid[y][x] = true;
			}
		}
		
		return grid;
	}
	
}