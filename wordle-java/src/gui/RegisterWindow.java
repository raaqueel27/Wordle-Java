package gui;

import wordle.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class RegisterWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private int r = 0;
	private int n = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterWindow window = new RegisterWindow();
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
	public RegisterWindow() {
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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().setBackground(SystemColor.window);
		frame.getContentPane().setLayout(null);
		
		LineBorder line = new LineBorder(Color.black, 1, true);
		
		//Icono Wordle
		Image img = new ImageIcon(this.getClass().getResource("/wordle.png")).getImage();
		JLabel wordleIcon = new JLabel();
		wordleIcon.setIcon(new ImageIcon(img));
		wordleIcon.setBounds(260, 29, 101, 110);
		frame.getContentPane().add(wordleIcon);
		
		//Personal logo
		Image raquel = new ImageIcon(this.getClass().getResource("/raquel_small.png")).getImage();
		JLabel discord = new JLabel("raaqueel27#0936");
		discord.setForeground(Color.GRAY);
		discord.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		discord.setBounds(0, -11, 204, 60);
		discord.setIcon(new ImageIcon(raquel));
		frame.getContentPane().add(discord);
		
		JLabel lblNewLabel_1 = new JLabel("Crea tu usuario:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1.setForeground(SystemColor.windowText);
		lblNewLabel_1.setBounds(230, 150, 174, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("8 o m\u00E1s caracteres  ");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(SystemColor.windowText);
		lblNewLabel_2.setBounds(169, 201, 305, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("La contrase\u00F1a debe tener al menos una letra may\u00FAscula y ");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNewLabel_2_1.setForeground(SystemColor.windowText);
		lblNewLabel_2_1.setBounds(180, 188, 305, 19);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		textField.setBounds(260, 225, 131, 39);
		textField.setForeground(SystemColor.controlShadow);
		textField.setText("Usuario");
		textField.setBorder(line);
		textField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(r == 0) {
					textField.setText("");
					r++;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
		});
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		passwordField = new JPasswordField("Contraseña");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(260, 258, 131, 39);
		passwordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		passwordField.setForeground(SystemColor.controlShadow);
		passwordField.setBorder(line);
		passwordField.setEchoChar((char) 0);
		passwordField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(n == 0) {
					passwordField.setEchoChar('●');
					passwordField.setText("");
					n++;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(124, 377, 396, 53);
		frame.getContentPane().add(lblNewLabel_4);
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image img_2 = new ImageIcon(this.getClass().getResource("/confirm.png")).getImage();
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(img_2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileManagment fm = new FileManagment();
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				User u = fm.getPlayer(username);
				if(u != null) { //El nombre de usuario ya le pertenece a alguien
					lblNewLabel_4.setText("Este usuario ya existe. Cambia el nombre o inicia sesión.");
					textField.setText("");
					passwordField.setText("");
					return;
				}
				if(!User.passwordIsValid(password)) { //Contraseña no válida
					lblNewLabel_4.setText("Contraseña no válida. Recuerda que debe tener una mayúscula y 8 o más caracteres");
					lblNewLabel_4.setBounds(30, 377, 550, 13);
					textField.setText("");
					passwordField.setText("");
					return;
				} else {
					u = new User(username,password);
					fm.savePlayer(u);
					frame.setVisible(false);
					WordleWindow w = new WordleWindow(u);
					w.getFrame().setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(203, 317, 233, 49);
		frame.getContentPane().add(btnNewButton);
		
		Image img_3 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(img_3));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LoginWindow l = new LoginWindow();
				l.getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(0, 42, 51, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
