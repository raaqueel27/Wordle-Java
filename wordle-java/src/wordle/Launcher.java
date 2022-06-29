package wordle;

import javax.swing.JFrame;

import gui.*;

public class Launcher {
	public static void main(String[] args) {
		LoginWindow lw = new LoginWindow();
		JFrame frame = lw.getFrame();
		frame.setVisible(true);
	}
}
