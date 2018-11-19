package chapter7;

public class GameOfLife {
	
	final static int N = 20;
	final static int LIFETIME = 10;
	
	public static void main(String[] args) throws InterruptedException {
		
		int tick = 0;
		boolean[][] grid = getRandomGrid(N);
		
		UI ui = new UI(grid, LIFETIME);
		
		while(tick < LIFETIME) {
			
			boolean[][] tickGrid = grid;
			
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
	}
	
	public static byte getAliveNeighbors(boolean[][] grid, int x, int y) {
		
		byte aliveNeighbors = 0;
		
		// direct
		if(x > 1 && grid[y][x-1]) aliveNeighbors++;
		if(x < grid[y].length-1 && grid[y][x+1]) aliveNeighbors++;
		if(y > 1 && grid[y-1][x]) aliveNeighbors++;
		if(y < grid.length-1 && grid[y+1][x]) aliveNeighbors++;
		
		// diagonal
		if(y > 1 && x > 1 && grid[y-1][x-1]) aliveNeighbors++;
		if(y < grid.length-1 && x < grid[y].length-1 && grid[y+1][x+1]) aliveNeighbors++;
		if(y > 1 && x < grid[y].length-1 && grid[y-1][x+1]) aliveNeighbors++;
		if(y < grid.length-1 && x > 1 && grid[y+1][x-1]) aliveNeighbors++; 
		
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