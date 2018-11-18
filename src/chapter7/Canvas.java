package chapter7;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

@SuppressWarnings("serial")
public class Canvas extends JPanel {

	private boolean[][] grid;
	private int cellSize;
	
	public Canvas(boolean[][] grid, int cellSize) {
		this.setGrid(grid);
		this.cellSize = cellSize;
	}
	
	public void setGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.clearRect(0, 0, grid.length * cellSize, grid.length * cellSize);
        
        for(int y = 0; y < grid.length; y++) {
        	for(int x = 0; x < grid.length; x++) {
        		if(grid[y][x]) g.setColor(Color.BLACK);
        		else g.setColor(Color.WHITE);
        		g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
        	}
        }
    }
}
