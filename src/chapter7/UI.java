package chapter7;

import javax.swing.JFrame;

public class UI {
	private JFrame frame;
	private Canvas canvas;
	private int cellSize = 20;
	
	public UI(boolean[][] grid) {
		frame = new JFrame("Game of Life - Startseed");
		
		canvas = new Canvas(grid, cellSize);
		
		frame.setContentPane(canvas);
		
		frame.setSize(grid.length * cellSize, grid.length * cellSize);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void update(boolean[][] grid, int tick) {
		
		frame.setTitle("Game of Life – Tick: " + tick);
		
		// Update grid
		canvas.setGrid(grid);
		
		// Repaint canvas
		frame.repaint();
	}
}