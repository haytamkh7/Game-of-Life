import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class LifePanel extends JPanel implements ActionListener {
	int size = 2; // size of the square
	int xPanel = 2000, yPanel = 2000;
	Life life = new Life(xPanel / size, yPanel / size);

	public LifePanel() {
		setSize(xPanel, yPanel);
		setLayout(null);
		new Timer(90, this).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		life.calculateNextGeneration();
		repaint();
	}

	private void display(Graphics g) {
		g.setColor(Color.decode("#143d59"));
		for (int x = 0; x < life.rows; x++) {
			for (int y = 0; y < life.cols; y++) {
				if (life.getBoard().get(x, y) == 1) {
					g.fillRect(x * size, y * size, size, size);
				}
			}
		}
	}

	private void grid(Graphics g) {
		g.setColor(Color.decode("#ffe042"));
		for (int i = 0; i < life.rows; i++) {
			g.drawLine(0, i * size, xPanel, i * size);
			g.drawLine(i * size, 0, i * size, yPanel);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.decode("#f4b41a"));
		grid(g);
		display(g);
	}
}
