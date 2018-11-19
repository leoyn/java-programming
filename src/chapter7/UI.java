package chapter7;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI {
	private static final int CELL_SIZE = 10;
	
	private JLabel tickLabel;
	private JButton nextBtn;
	private JButton prevBtn;
	private Canvas canvas;
	private boolean[][][] history;
	private int historyIndex = 0;
	
	public UI(boolean[][] grid, int lifetime) {
		history = new boolean[lifetime + 1][grid.length][grid.length];
		addGrid(grid, 0);
		
		nextBtn = new JButton("Next Tick");
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				historyIndex++;
				update();
			}
		});
		
		prevBtn = new JButton("Previous Tick");
		prevBtn.setEnabled(false);
		prevBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				historyIndex--;
				update();
			}
		});
		
		tickLabel = new JLabel("Startseed");
		
		canvas = new Canvas(history[0], CELL_SIZE);
		canvas.setPreferredSize(new Dimension(grid.length * CELL_SIZE, grid.length * CELL_SIZE));
		
		JPanel panel = new JPanel();
		panel.add(canvas);
		panel.add(tickLabel);
		panel.add(nextBtn);
		panel.add(prevBtn);
		
		JFrame frame = new JFrame("Game of Life");
		frame.setContentPane(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void addGrid(boolean[][] grid, int tick) {
		if(tick > -1 && tick < history.length) {
			for(int y = 0; y < grid.length; y++) {
				for(int x = 0; x < grid[y].length; x++) {
					history[tick][y][x] = grid[y][x];
				}
			}
		}
	}
	
	private void update() {
		if(historyIndex > 0) tickLabel.setText("Tick:" + historyIndex);
		else tickLabel.setText("Startseed");
		
		prevBtn.setEnabled(historyIndex > 0);
		nextBtn.setEnabled(historyIndex < history.length - 1);
		
		canvas.setGrid(history[historyIndex]);
		canvas.repaint();
	}
}