package gui;

import wordle.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class WordleWindow {

	private JFrame frmWordle;
	private int attemptsLeft = 5;
	private int score = 0;
	private User user;
	private Wordle game;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordleWindow window = new WordleWindow(user);
					window.frmWordle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public WordleWindow(User user) {
		this.user = user;
		game = new Wordle(this.user);
		initialize();
	}

	public JFrame getFrame() {
		return frmWordle;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWordle = new JFrame();
		frmWordle.getContentPane().setFont(new Font("Arial Black", Font.BOLD, 16));
		frmWordle.getContentPane().setForeground(new Color(255, 255, 255));
		frmWordle.setBackground(new Color(95, 158, 160));
		frmWordle.setForeground(new Color(0, 128, 0));
		frmWordle.setTitle("Wordle");
		frmWordle.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 12));
		frmWordle.getContentPane().setBackground(SystemColor.window);
		frmWordle.getContentPane().setLayout(null);
		
		Color green = Color.decode("#57AC57");
		Color yellow = Color.decode("#FCE438");
		Color gray = Color.decode("#A2A19D");
		Color txt = Color.decode("#EAFAF1");
		
		Image send = new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(send));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.WHITE);
		
		//Personal logo
		Image raquel = new ImageIcon(this.getClass().getResource("/raquel_small.png")).getImage();
		JLabel discord = new JLabel("raaqueel27#0936");
		discord.setForeground(Color.GRAY);
		discord.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		discord.setBounds(0, -12, 204, 60);
		discord.setIcon(new ImageIcon(raquel));
		frmWordle.getContentPane().add(discord);
		
		//Icono Wordle
		Image img = new ImageIcon(this.getClass().getResource("/wordle.png")).getImage();
		JLabel wordleIcon = new JLabel();
		wordleIcon.setHorizontalAlignment(SwingConstants.CENTER);
		wordleIcon.setIcon(new ImageIcon(img));
		wordleIcon.setBounds(254, 11, 110, 110);
		frmWordle.getContentPane().add(wordleIcon);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField.setEditable(false);
		formattedTextField.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField.setBounds(172, 132, 47, 33);
		frmWordle.getContentPane().add(formattedTextField);
		
		JFormattedTextField formattedTextField_25 = new JFormattedTextField();
		formattedTextField_25.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		formattedTextField_25.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_25.setBounds(172, 359, 215, 33);
		formattedTextField_25.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == 10) { //Presiona la tecla ENTER
					btnNewButton.doClick();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub				
			}			
		});
		frmWordle.getContentPane().add(formattedTextField_25);
		
		JFormattedTextField formattedTextField_26 = new JFormattedTextField();
		formattedTextField_26.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_26.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_26.setEditable(false);
		formattedTextField_26.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_26.setBounds(229, 132, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_26);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_1.setEditable(false);
		formattedTextField_1.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_1.setBounds(287, 132, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_2.setEditable(false);
		formattedTextField_2.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_2.setBounds(344, 132, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_2);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_3.setEditable(false);
		formattedTextField_3.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_3.setBounds(401, 132, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_3);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_4.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_4.setEditable(false);
		formattedTextField_4.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_4.setBounds(172, 175, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_4);
		
		JFormattedTextField formattedTextField_26_1 = new JFormattedTextField();
		formattedTextField_26_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_26_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_26_1.setEditable(false);
		formattedTextField_26_1.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_26_1.setBounds(229, 175, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_26_1);
		
		JFormattedTextField formattedTextField_1_1 = new JFormattedTextField();
		formattedTextField_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_1_1.setEditable(false);
		formattedTextField_1_1.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_1_1.setBounds(287, 175, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_1_1);
		
		JFormattedTextField formattedTextField_2_1 = new JFormattedTextField();
		formattedTextField_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_2_1.setEditable(false);
		formattedTextField_2_1.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_2_1.setBounds(344, 175, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_2_1);
		
		JFormattedTextField formattedTextField_3_1 = new JFormattedTextField();
		formattedTextField_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_3_1.setEditable(false);
		formattedTextField_3_1.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_3_1.setBounds(401, 175, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_3_1);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_5.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_5.setEditable(false);
		formattedTextField_5.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_5.setBounds(172, 218, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_5);
		
		JFormattedTextField formattedTextField_26_2 = new JFormattedTextField();
		formattedTextField_26_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_26_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_26_2.setEditable(false);
		formattedTextField_26_2.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_26_2.setBounds(229, 218, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_26_2);
		
		JFormattedTextField formattedTextField_1_2 = new JFormattedTextField();
		formattedTextField_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_1_2.setEditable(false);
		formattedTextField_1_2.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_1_2.setBounds(287, 218, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_1_2);
		
		JFormattedTextField formattedTextField_2_2 = new JFormattedTextField();
		formattedTextField_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_2_2.setEditable(false);
		formattedTextField_2_2.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_2_2.setBounds(344, 218, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_2_2);
		
		JFormattedTextField formattedTextField_3_2 = new JFormattedTextField();
		formattedTextField_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3_2.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_3_2.setEditable(false);
		formattedTextField_3_2.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_3_2.setBounds(401, 218, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_3_2);
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_6.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_6.setEditable(false);
		formattedTextField_6.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_6.setBounds(172, 261, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_6);
		
		JFormattedTextField formattedTextField_26_3 = new JFormattedTextField();
		formattedTextField_26_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_26_3.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_26_3.setEditable(false);
		formattedTextField_26_3.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_26_3.setBounds(229, 261, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_26_3);
		
		JFormattedTextField formattedTextField_1_3 = new JFormattedTextField();
		formattedTextField_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_3.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_1_3.setEditable(false);
		formattedTextField_1_3.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_1_3.setBounds(287, 261, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_1_3);
		
		JFormattedTextField formattedTextField_2_3 = new JFormattedTextField();
		formattedTextField_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2_3.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_2_3.setEditable(false);
		formattedTextField_2_3.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_2_3.setBounds(344, 261, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_2_3);
		
		JFormattedTextField formattedTextField_3_3 = new JFormattedTextField();
		formattedTextField_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3_3.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_3_3.setEditable(false);
		formattedTextField_3_3.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_3_3.setBounds(401, 261, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_3_3);
		
		JFormattedTextField formattedTextField_7 = new JFormattedTextField();
		formattedTextField_7.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_7.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_7.setEditable(false);
		formattedTextField_7.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_7.setBounds(172, 304, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_7);
		
		JFormattedTextField formattedTextField_26_4 = new JFormattedTextField();
		formattedTextField_26_4.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_26_4.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_26_4.setEditable(false);
		formattedTextField_26_4.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_26_4.setBounds(229, 304, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_26_4);
		
		JFormattedTextField formattedTextField_1_4 = new JFormattedTextField();
		formattedTextField_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_1_4.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_1_4.setEditable(false);
		formattedTextField_1_4.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_1_4.setBounds(287, 304, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_1_4);
		
		JFormattedTextField formattedTextField_2_4 = new JFormattedTextField();
		formattedTextField_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_2_4.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_2_4.setEditable(false);
		formattedTextField_2_4.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_2_4.setBounds(344, 304, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_2_4);
		
		JFormattedTextField formattedTextField_3_4 = new JFormattedTextField();
		formattedTextField_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3_4.setFont(new Font("Arial Black", Font.BOLD, 16));
		formattedTextField_3_4.setEditable(false);
		formattedTextField_3_4.setBackground(SystemColor.inactiveCaptionBorder);
		formattedTextField_3_4.setBounds(401, 304, 47, 33);
		frmWordle.getContentPane().add(formattedTextField_3_4);
		frmWordle.setBounds(100, 100, 640, 480);
		frmWordle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(113, 323, 385, 14);
		frmWordle.getContentPane().add(lblNewLabel_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Score s = null;
				FileManagment fm = new FileManagment();
				lblNewLabel_1.setText("");
				String attemptS = formattedTextField_25.getText().toUpperCase();
				if(attemptS.length() != 5) {
					lblNewLabel_1.setText("Solo puedes poner palabras de 5 letras! ¬¬");
					formattedTextField_25.setText("");
					return;
				}
				Word attempt = new Word(attemptS);
				Letter[] wordA = attempt.getArray();
				game.checkGuess(wordA);
				formattedTextField_25.setText("");
				for(int i = 0; i < attemptS.length();i++) {
					if(wordA[i].isInCorrectPosition()) 
						score += attemptsLeft * 10;
					else if (wordA[i].exists())
						score += (attemptsLeft * 10)/2;
				}
				switch(attemptsLeft) {
					case 5:
						formattedTextField.setText(wordA[0].toString().toUpperCase());
						if(wordA[0].isInCorrectPosition()) {
							formattedTextField.setBackground(green);
						} else if (wordA[0].exists()) {
							formattedTextField.setBackground(yellow);
						} else {
							formattedTextField.setBackground(gray);
						}
						formattedTextField_26.setText(wordA[1].toString().toUpperCase());
						if(wordA[1].isInCorrectPosition()) {
							formattedTextField_26.setBackground(green);
						} else if (wordA[1].exists()) {
							formattedTextField_26.setBackground(yellow);
						} else {
							formattedTextField_26.setBackground(gray);
						}
						formattedTextField_1.setText(wordA[2].toString().toUpperCase());
						if(wordA[2].isInCorrectPosition()) {
							formattedTextField_1.setBackground(green);
						} else if (wordA[2].exists()) {
							formattedTextField_1.setBackground(yellow);
						} else {
							formattedTextField_1.setBackground(gray);
						}
						formattedTextField_2.setText(wordA[3].toString().toUpperCase());
						if(wordA[3].isInCorrectPosition()) {
							formattedTextField_2.setBackground(green);
						} else if (wordA[3].exists()) {
							formattedTextField_2.setBackground(yellow);
						} else {
							formattedTextField_2.setBackground(gray);
						}
						formattedTextField_3.setText(wordA[4].toString().toUpperCase());
						if(wordA[4].isInCorrectPosition()) {
							formattedTextField_3.setBackground(green);
						} else if (wordA[4].exists()) {
							formattedTextField_3.setBackground(yellow);
						} else {
							formattedTextField_3.setBackground(gray);
						}
						attemptsLeft--;
						break;
					case 4:
						formattedTextField_4.setText(wordA[0].toString().toUpperCase());
						if(wordA[0].isInCorrectPosition()) {
							formattedTextField_4.setBackground(green);
						} else if (wordA[0].exists()) {
							formattedTextField_4.setBackground(yellow);
						} else {
							formattedTextField_4.setBackground(gray);
						}
						formattedTextField_26_1.setText(wordA[1].toString().toUpperCase());
						if(wordA[1].isInCorrectPosition()) {
							formattedTextField_26_1.setBackground(green);
						} else if (wordA[1].exists()) {
							formattedTextField_26_1.setBackground(yellow);
						} else {
							formattedTextField_26_1.setBackground(gray);
						}
						formattedTextField_1_1.setText(wordA[2].toString().toUpperCase());
						if(wordA[2].isInCorrectPosition()) {
							formattedTextField_1_1.setBackground(green);
						} else if (wordA[2].exists()) {
							formattedTextField_1_1.setBackground(yellow);
						} else {
							formattedTextField_1_1.setBackground(gray);
						}
						formattedTextField_2_1.setText(wordA[3].toString().toUpperCase());
						if(wordA[3].isInCorrectPosition()) {
							formattedTextField_2_1.setBackground(green);
						} else if (wordA[3].exists()) {
							formattedTextField_2_1.setBackground(yellow);
						} else {
							formattedTextField_2_1.setBackground(gray);
						}
						formattedTextField_3_1.setText(wordA[4].toString().toUpperCase());
						if(wordA[4].isInCorrectPosition()) {
							formattedTextField_3_1.setBackground(green);
						} else if (wordA[4].exists()) {
							formattedTextField_3_1.setBackground(yellow);
						} else {
							formattedTextField_3_1.setBackground(gray);
						}
						attemptsLeft--;
						break;
					case 3:
						formattedTextField_5.setText(wordA[0].toString().toUpperCase());
						if(wordA[0].isInCorrectPosition()) {
							formattedTextField_5.setBackground(green);
						} else if (wordA[0].exists()) {
							formattedTextField_5.setBackground(yellow);
						} else {
							formattedTextField_5.setBackground(gray);
						}
						formattedTextField_26_2.setText(wordA[1].toString().toUpperCase());
						if(wordA[1].isInCorrectPosition()) {
							formattedTextField_26_2.setBackground(green);
						} else if (wordA[1].exists()) {
							formattedTextField_26_2.setBackground(yellow);
						} else {
							formattedTextField_26_2.setBackground(gray);
						}
						formattedTextField_1_2.setText(wordA[2].toString().toUpperCase());
						if(wordA[2].isInCorrectPosition()) {
							formattedTextField_1_2.setBackground(green);
						} else if (wordA[2].exists()) {
							formattedTextField_1_2.setBackground(yellow);
						} else {
							formattedTextField_1_2.setBackground(gray);
						}
						formattedTextField_2_2.setText(wordA[3].toString().toUpperCase());
						if(wordA[3].isInCorrectPosition()) {formattedTextField_2_2.setBackground(green);
						} else if (wordA[3].exists()) {
							formattedTextField_2_2.setBackground(yellow);
						} else {
							formattedTextField_2_2.setBackground(gray);
						}
						formattedTextField_3_2.setText(wordA[4].toString().toUpperCase());
						if(wordA[4].isInCorrectPosition()) {
							formattedTextField_3_2.setBackground(green);
						} else if (wordA[4].exists()) {
							formattedTextField_3_2.setBackground(yellow);
						} else {
							formattedTextField_3_2.setBackground(gray);
						}
						attemptsLeft--;
						break;
					case 2:
						formattedTextField_6.setText(wordA[0].toString().toUpperCase());
						if(wordA[0].isInCorrectPosition()) {
							formattedTextField_6.setBackground(green);
						} else if (wordA[0].exists()) {
							formattedTextField_6.setBackground(yellow);
						} else {
							formattedTextField_6.setBackground(gray);
						}
						formattedTextField_26_3.setText(wordA[1].toString().toUpperCase());
						if(wordA[1].isInCorrectPosition()) {
							formattedTextField_26_3.setBackground(green);
						} else if (wordA[1].exists()) {
							formattedTextField_26_3.setBackground(yellow);
						} else {
							formattedTextField_26_3.setBackground(gray);
						}
						formattedTextField_1_3.setText(wordA[2].toString().toUpperCase());
						if(wordA[2].isInCorrectPosition()) {
							formattedTextField_1_3.setBackground(green);
						} else if (wordA[2].exists()) {
							formattedTextField_1_3.setBackground(yellow);
						} else {
							formattedTextField_1_3.setBackground(gray);
						}
						formattedTextField_2_3.setText(wordA[3].toString().toUpperCase());
						if(wordA[3].isInCorrectPosition()) {
							formattedTextField_2_3.setBackground(green);
						} else if (wordA[3].exists()) {
							formattedTextField_2_3.setBackground(yellow);
						} else {
							formattedTextField_2_3.setBackground(gray);
						}
						formattedTextField_3_3.setText(wordA[4].toString().toUpperCase());
						if(wordA[4].isInCorrectPosition()) {
							formattedTextField_3_3.setBackground(green);
						} else if (wordA[4].exists()) {
							formattedTextField_3_3.setBackground(yellow);
						} else {
							formattedTextField_3_3.setBackground(gray);
						}
						attemptsLeft--;
						break;
					case 1:
						formattedTextField_7.setText(wordA[0].toString().toUpperCase());
						if(wordA[0].isInCorrectPosition()) {
							formattedTextField_7.setBackground(green);
						} else if (wordA[0].exists()) {
							formattedTextField_7.setBackground(yellow);
						} else {
							formattedTextField_7.setBackground(gray);
						}
						formattedTextField_26_4.setText(wordA[1].toString().toUpperCase());
						if(wordA[1].isInCorrectPosition()) {
							formattedTextField_26_4.setBackground(green);
						} else if (wordA[1].exists()) {
							formattedTextField_26_4.setBackground(yellow);
						} else {
							formattedTextField_26_4.setBackground(gray);
						}
						formattedTextField_1_4.setText(wordA[2].toString().toUpperCase());
						if(wordA[2].isInCorrectPosition()) {
							formattedTextField_1_4.setBackground(green);
						} else if (wordA[2].exists()) {
							formattedTextField_1_4.setBackground(yellow);
						} else {
							formattedTextField_1_4.setBackground(gray);
						}
						formattedTextField_2_4.setText(wordA[3].toString().toUpperCase());
						if(wordA[3].isInCorrectPosition()) {
							formattedTextField_2_4.setBackground(green);
						} else if (wordA[3].exists()) {
							formattedTextField_2_4.setBackground(yellow);
						} else {
							formattedTextField_2_4.setBackground(gray);
						}
						formattedTextField_3_4.setText(wordA[4].toString().toUpperCase());
						if(wordA[4].isInCorrectPosition()) {
							formattedTextField_3_4.setBackground(green);
						} else if (wordA[4].exists()) {
							formattedTextField_3_4.setBackground(yellow);
						} else {
							formattedTextField_3_4.setBackground(gray);
						}
						attemptsLeft--;
						break;
					default:
						break;
				}
				if(game.isCorrect(attempt)) {
					try {
						fm.sumWin(user.getName());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					frmWordle.setVisible(false);
					WinningWindow ww = new WinningWindow();
					JFrame newFrame = ww.getFrame();
					newFrame.setVisible(true);
					
				} else if (attemptsLeft <= 0) {
					frmWordle.setVisible(false);
					LosingWindow lw = new LosingWindow(game.getGuess());
					JFrame newFrame = lw.getFrame();
					newFrame.setVisible(true);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(397, 359, 55, 33);
		frmWordle.getContentPane().add(btnNewButton);
		
	
	}
	
	private void executeAttempt() {
		
	}
}
