package gui;

import wordle.FileManagment;
import wordle.Word;
import wordle.Wordle;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import wordle.FileManagment;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class LosingWindow {

	private JFrame frame;
	private String guess;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LosingWindow window = new LosingWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public LosingWindow(String guess) {
		this.guess = guess.toUpperCase();
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.getContentPane().setLayout(null);
		
		//Personal logo
		Image raquel = new ImageIcon(this.getClass().getResource("/raquel_small.png")).getImage();
		JLabel discord = new JLabel("raaqueel27#0936");
		discord.setForeground(Color.GRAY);
		discord.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		discord.setBounds(0, 0, 204, 60);
		discord.setIcon(new ImageIcon(raquel));
		frame.getContentPane().add(discord);
				
		//Icono Wordle
		Image img = new ImageIcon(this.getClass().getResource("/wordle.png")).getImage();
		JLabel wordleIcon = new JLabel();
		wordleIcon.setIcon(new ImageIcon(img));
		wordleIcon.setBounds(247, 11, 110, 110);
		frame.getContentPane().add(wordleIcon);
		
		JLabel lblNewLabel_1 = new JLabel("Has perdido...");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(SystemColor.windowText);
		lblNewLabel_1.setBounds(162, 113, 279, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(25, 167, 230, 263);
		Image img_4 = new ImageIcon(this.getClass().getResource("/sadcat.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img_4));
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(lblNewLabel_2);
		
		FileManagment fm = new FileManagment();
		JLabel lblNewLabel_3 = new JLabel(fm.scoresToString(fm.readScores()));
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(SystemColor.windowText);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(283, 214, 287, 162);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ranking:");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_4.setForeground(SystemColor.windowText);
		lblNewLabel_4.setBounds(283, 178, 91, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		Image img_3 = new ImageIcon(this.getClass().getResource("/playAgain.png")).getImage();
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(img_3));
		btnNewButton.setBackground(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow lw = new LoginWindow();
				JFrame newFrame = lw.getFrame();
				frame.setVisible(false);
				newFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(318, 375, 234, 43);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("La palabra era " + guess);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(SystemColor.windowText);
		lblNewLabel_5.setBounds(235, 148, 168, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u00BFQuieres a\u00F1adir otra palabra?");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNewLabel_6.setForeground(SystemColor.windowText);
		lblNewLabel_6.setBounds(447, 32, 156, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(484, 57, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(441, 88, 162, 25);
		frame.getContentPane().add(lblNewLabel_7);
		
		Image img_2 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileManagment fm = new FileManagment(); 
				String wordS = textField.getText().toUpperCase();
				Word word = new Word(wordS);
				if(Wordle.isValid(word)) {
					fm.writeWord(wordS);
					lblNewLabel_7.setText("¡Añadida correctamente!");
					lblNewLabel_7.setForeground(Color.GREEN);
					textField.setText("");
				} else {
					lblNewLabel_7.setText("<html><body>Tiene que ser una palabra<br> de 5 letras</body></html>");
					textField.setText("");
				}
			}
		});
		btnNewButton_1.setBounds(581, 54, 33, 23);
		btnNewButton_1.setIcon(new ImageIcon(img_2));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
		
		
		
	}
}


