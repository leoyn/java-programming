package chapter7;

public class GameOfLife {
	
	final static int n = 20;
	final static int lifetime = 10;
	
	public static void main(String[] args) throws InterruptedException {
		
		int tick = 0;
		boolean[][] grid = getRandomGrid(n);
		
		UI ui = new UI(grid);
		
		while(tick < lifetime) {
			
			boolean[][] tickGrid = grid;
			
			for(int y = 0; y < n; y++) {
				for(int x = 0; x < n; x++) {
					int aliveNeighbors = getAliveNeighbors(grid, x, y);
					
					if(grid[y][x]) {
						if(aliveNeighbors < 2 || aliveNeighbors > 3) tickGrid[y][x] = false;
					} else if(aliveNeighbors == 3) tickGrid[y][x] = true;
				}
			}
			
			grid = tickGrid;
			
			Thread.sleep(300);
			
			ui.update(grid, tick+1);
			
			tick++;
		}
	}
	
	public static byte getAliveNeighbors(boolean[][] grid, int x, int y) {
		
		byte aliveNeighbors = 0;
		
		// direct
		if(x > 1 && grid[y][x-1]) aliveNeighbors++;
		if(x < grid[y].length-1 && grid[y][x+1]) aliveNeighbors++;
		if(y > 1 && grid[y-1][x]) aliveNeighbors++;
		if(y < grid.length-1) aliveNeighbors++;
		
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
				else grid[y][x] = false;
			}
		}
		
		return grid;
	}
	
}