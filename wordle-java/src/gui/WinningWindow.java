package gui;

import wordle.*;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Image;
import java.util.Objects;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class WinningWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinningWindow window = new WinningWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WinningWindow() {
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
		
		Color green = Color.decode("#57AC57");
		
		//Personal logo
		Image raquel = new ImageIcon(this.getClass().getResource("/raquel_small.png")).getImage();
		JLabel discord = new JLabel("raaqueel27#0936");
		discord.setForeground(Color.GRAY);
		discord.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		discord.setBounds(0, 0, 204, 60);
		discord.setIcon(new ImageIcon(raquel));
		frame.getContentPane().add(discord);
				
		//Icono Wordle
		Image wordle = new ImageIcon(this.getClass().getResource("/wordle.png")).getImage();
		JLabel wordleIcon = new JLabel();
		wordleIcon.setIcon(new ImageIcon(wordle));
		wordleIcon.setBounds(247, 11, 110, 110);
		frame.getContentPane().add(wordleIcon);
		
		JLabel lblNewLabel_1 = new JLabel("\u00A1Has Acertado!");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(SystemColor.controlText);
		lblNewLabel_1.setBounds(162, 113, 279, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(25, 167, 182, 263);
		Image img = new ImageIcon(this.getClass().getResource("/cr7.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(lblNewLabel_2);
		
		FileManagment fm = new FileManagment();
		JLabel lblNewLabel_3 = new JLabel(fm.scoresToString(fm.readScores()));
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(SystemColor.controlText);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(248, 234, 287, 162);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ranking:");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblNewLabel_4.setForeground(SystemColor.controlText);
		lblNewLabel_4.setBounds(248, 198, 91, 25);
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
		btnNewButton.setBounds(318, 375, 234, 43);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("\u00BFQuieres a\u00F1adir otra palabra?");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNewLabel_6.setForeground(SystemColor.controlText);
		lblNewLabel_6.setBounds(453, 33, 150, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		textField.setBounds(484, 57, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(452, 77, 162, 25);
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
					lblNewLabel_7.setForeground(green);
					textField.setText("");
				} else {
					lblNewLabel_7.setForeground(Color.RED);
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
