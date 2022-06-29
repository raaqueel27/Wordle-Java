package gui;

import wordle.User;
import wordle.FileManagment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
/**
 * Clase LoginWindow:
 * Interfaz gráfica para el inicio de sesión del usuario. A parte tendrán  la opción de registrarse si no tienen ya una cuenta.
 * @author raquelcp
 *	@version 1.0
 */
public class LoginWindow {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField txtUsername;
	private int n = 0;
	private int r = 0;

	/**
	 * Crea la aplicación.
	 */
	public LoginWindow() {
		initialize();
	}
	
	/**
	 * Devuelve el JFrame de la aplicacion
	 * Necesario para llamar a la interfaz gráfica
	 * @return Jframe
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Inicializa todos los componentes de la interfaz.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.getContentPane().setLayout(null);
		
		LineBorder line = new LineBorder(Color.black, 1, true);
		
		//Personal logo
		Image raquel = new ImageIcon(this.getClass().getResource("/raquel_small.png")).getImage();
		JLabel discord = new JLabel("raaqueel27#0936");
		discord.setForeground(Color.GRAY);
		discord.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		discord.setBounds(0, -12, 204, 60);
		discord.setIcon(new ImageIcon(raquel));
		frame.getContentPane().add(discord);
		
		//Icono Wordle
		Image img = new ImageIcon(this.getClass().getResource("/wordle.png")).getImage();
		JLabel wordleIcon = new JLabel();
		wordleIcon.setHorizontalAlignment(SwingConstants.CENTER);
		wordleIcon.setIcon(new ImageIcon(img));
		wordleIcon.setBounds(247, 41, 110, 110);
		frame.getContentPane().add(wordleIcon);
		
		//Campo de texto para introducir el nombre del usuario
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtUsername.setForeground(SystemColor.controlShadow);
		txtUsername.setText("Usuario");
		txtUsername.setBounds(228, 192, 156, 33);
		txtUsername.setBorder(line);
		txtUsername.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(r == 0) {
					txtUsername.setText("");
					r++;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
		});
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Campo de texto para introducir la contraseña (El contenido de este no será visible"
		passwordField = new JPasswordField("Contraseña");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		passwordField.setForeground(SystemColor.controlShadow);
		passwordField.setBounds(228, 224, 156, 33);
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
		
		//Label "Si no tienes cuenta registrate pulsando el siguiente botón"
		JLabel lblNewLabel_2 = new JLabel("\u00BFNo tienes una cuenta? Reg\u00EDstrate usando este boton");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(SystemColor.windowText);
		lblNewLabel_2.setBounds(148, 337, 335, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		//Botón para registrarse
		Image img_3 = new ImageIcon(this.getClass().getResource("/registerButton.png")).getImage();
		JButton btnNewButton =  new JButton("");
		btnNewButton.setIcon(new ImageIcon(img_3));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * Una vez pulsado el botón se abrira la pantalla de registro de jugadores
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RegisterWindow r = new RegisterWindow();
				r.getFrame().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(188, 359, 243, 42);
		frame.getContentPane().add(btnNewButton);
		
		//Label invisible que mostrará los mensajes de error cuando el usuario introduzca parametros incorrectos
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBackground(new Color(255, 0, 0));
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(58, 312, 500, 33);
		frame.getContentPane().add(lblNewLabel_3);
		
		//Botón para enviar los datos de inicio de sesión
		Image img_2 = new ImageIcon(this.getClass().getResource("/loginButton.png")).getImage();
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon (new ImageIcon(img_2));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			/**
			 * Se ejecutará siempre que se pulse el botón de enviar
			 * Inicia la sesión del jugador (si es posible)
			 */
			public void actionPerformed(ActionEvent e) {
				FileManagment fm = new FileManagment();
				String name = txtUsername.getText();
				String password = new String(passwordField.getPassword());
				User u = fm.getPlayer(name);
				//Comprueba si el jugador se ha registrado previamente o no
				if(u == null){ 
					//No existe ningun jugador con ese nombre de usuario
					txtUsername.setText("");
					passwordField.setText("");
					lblNewLabel_3.setText("El usuario no existe. Regístrate.");
					return; //Deja de ejecutarse el resto del código
				}
				//Comprueba que la contraseña esté acorde con la registrada en el fichero
				if(!u.checkPassword(u,password)) {
					//La contraseña no es correcta
					passwordField.setText("");
					lblNewLabel_3.setText("Contraseña incorrecta.Vuelve a intentarlo.");
					return; //Deja de ejecutarse el resto del código
				}
				//Si la ejecución llega a este punto significa que tanto el nombre de usuario como la contraseña
				//son correctos
				//Por lo que llamamos a la ventana del juego
				frame.setVisible(false);
				WordleWindow w = new WordleWindow(u);
				w.getFrame().setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		btnNewButton_1.setBounds(188, 262, 243, 53);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Por favor, inicia sesi\u00F3n");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(148, 151, 318, 34);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		
	}
}