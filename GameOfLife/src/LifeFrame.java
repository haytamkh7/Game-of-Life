import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class LifeFrame extends JFrame {
	public static void main(String[] args) {
		new LifeFrame();
	}

	public LifeFrame() {
		add(new LifePanel());
		setTitle("Game of Life");
		setSize(1300, 700);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
