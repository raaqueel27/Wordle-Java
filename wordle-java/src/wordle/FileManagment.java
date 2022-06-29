package wordle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import io.*;

/**
 * Clase FileManagment (Gestor de Ficheros)
 * Se encarga de recoger y escribir datos de los ficheros de texto.
 * @author guille | raquelcp
 *
 */
public class FileManagment {
    
    private final String PLAYERS_FILE = "/data/wordle/players.dat"; //Directorio del fichero Jugadores
    private final String WORDS_FILE = "/data/wordle/words.dat"; //Directorio del fichero Palabras
    private final String SCORES_FILE = "/data/wordle/scores.dat"; //Directorio del fichero Resultados

    private Writer playersWriter; //Escritor del fichero Jugadores
    private Reader playersReader; //Lector del fichero Jugadores

	private Writer wordsWriter; //Escritor del fichero Palabras
    private Reader wordsReader; //Lector del fichero Palabras
    
    private Writer scoresWriter; //Escritor del fichero Resultados
    private Reader scoresReader; //Escritor del fichero Resultados

    /**
     * Constructor de la clase FileManagment(Gestor de Ficheros)
     */
    public FileManagment() {
        playersWriter = new Writer(PLAYERS_FILE);
        playersReader = new Reader(PLAYERS_FILE);
        wordsWriter = new Writer(WORDS_FILE);
        wordsReader = new Reader(WORDS_FILE);
        scoresWriter = new Writer(SCORES_FILE);
        scoresReader = new Reader(SCORES_FILE);
    }

    /**
     * Lee las líneas del fichero Jugadores y guarda los usuarios encontrados en el en una Arraylist
     * @return  ArrayList<User> con todos los jugadores del fichero
     */
    public ArrayList<User> readPlayers() {
        ArrayList<User> players = new ArrayList<User>(); //Inicializa la Arraylist de Usuarios
        ArrayList<String> playersString = playersReader.readLines(); //Lee todas las lineas del archivo Jugadores y las guarda en una ArrayList de Strings
        //Recorre la Array de Strings
        for(int i = 0; i < playersString.size(); i++) { 
            String playerString = playersString.get(i);
            String[] playerData = splitString(playerString); //Crea un array con los datos de cada Jugador
            String name = playerData[0]; //Nombre de usuario
            String password = playerData[1]; //Contrase�a
            try {
                User user = new User(name,password);
                players.add(user); //A�ade el usuario a la ArrayList
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return players;
    }

    /**
     * Busca en el archivo de jugadores a un usuario por su nombre y devuelve la instacia de la clase User correspondiente
     * @param name  Nombre a buscar en el fichero
     * @return      Usuario con el nombre buscado (Devolver� null si no existe)
     */
    public User getPlayer(String name) {
        User player = null;
        ArrayList<String> players = playersReader.readLines();
        for(int i = 0; i < players.size(); i++){
            String currentPlayer = players.get(i);
            String[] playerData = splitString(currentPlayer);
            if(playerData[0].equals(name)) {
                try {
                    player = new User(playerData[0],playerData[1]);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return player;
    }

    /**
     * Registra un usuario dado en el fichero de Jugadores
     * @param user  Usuario a registrar en el fichero
     */
    public void savePlayer(User user) {
    	String userLabel = user.getName() + "#" + user.getPassword();
        playersWriter.writeLine(userLabel);
    }
    
    /**
     * Lee todas las líneas del archivo Palabras y las recoge en un ArrayList de Strings
     * @return  ArrayList<String> con todas las palabras del fichero
     */
    public ArrayList<String> readWords() {
    	ArrayList<String> words = new ArrayList<String>();
    	ArrayList<String> word = wordsReader.readLines();
    	for(int i = 0; i < word.size(); i++) {
    		String oneWord = word.get(i);
    		words.add(oneWord);
    	}
    	return words;
    }

    /**
     * Divide un string en dos partes limitadas por el caracter "#"
     * @param s Cadena de caracteres a dividir
     * @return  Array unidimensional de Strings que devuelve ambas partes de la String inicial
     */
    public String[] splitString(String s) {
		String[] parts = s.split("#");
		return parts;
	}
    
    /**
     * Cuenta el número de palabras existentes en el fichero Palabras
     * @return  Número de palabras
     */
    public int getNumberOfWords() {
    	int count = 0;
    	ArrayList<String> words = wordsReader.readLines();
    	count = words.size();
    	return count;
    }
    
    /**
     * Lee todos los resultados registrados en el fichero Resultados y recoge los datos en una ArrayList.
     * @return  ArrayList<Score> con todos los resultados del fichero
     */
    public ArrayList<Score> readScores() {
    	ArrayList<Score> scores = new ArrayList<Score>();
    	ArrayList<String> scoreS = scoresReader.readLines();
    	for(int i = 0; i < scoreS.size(); i++) {
    		String currentScoreS = scoreS.get(i);
    		String[] scoreData = splitString(currentScoreS);
    		String userS = scoreData[0];
    		int score = Integer.parseInt(scoreData[1]);
    		try {
    			Score s = new Score(userS,score);
    			scores.add(s);
    		} catch(Exception e) {
                System.out.println(e.getMessage());
            }
    	}
    	return scores;
    }
    
    public String getScore(String username) {
    	FileManagment fm = new FileManagment(); 
    	ArrayList<Score> scores = fm.readScores();
    	String score = null;
    	for(int i = 0; i < scores.size(); i++) {
    		String scoreS = scores.get(i).toString();
    		String[] scoreData = splitString(scoreS);
    		if(scoreData[0].equals(username)) {
    			score = scores.get(i).toString();
    		}
    	}
		return score;
    }
    
    /**
     * Escribe nuevos resultados en el fichero Resultados
     * @param username Nombre del usuario al que le queremos registrar la victoria
     * @throws FileNotFoundException 
     */
    public void sumWin(String username) throws FileNotFoundException {
    	ArrayList<Score> currentScores = readScores();
    	ArrayList<String> newScores = new ArrayList<String>();
    	for(int i = 0; i < currentScores.size(); i++) {
    		Score score = currentScores.get(i);
    		String cUsername = score.getName();
    		int cScore = score.getScore();
    		if(username.equals(cUsername)) {
    			cScore++;
    		}
    		newScores.add(cUsername+"#"+String.valueOf(cScore));
    	}
    	if(getScore(username) == null) {
    		newScores.add(username+"#1");
    	}
    	PrintWriter writer = new PrintWriter(System.getProperty("user.dir") + SCORES_FILE);
    	writer.print("");
    	writer.close();
    	for(int i = 0; i < newScores.size(); i++) {
    		String s = newScores.get(i);
    		scoresWriter.writeLine(s);
    	}
    }
    
    /**
     * Obtiene una lista de los 5 mejores resultados en un formato más presentable
     * @param scores    ArrayList con todos los resultados que queremos representar
     * @return          String que muestra los 5 mejores resultados
     */
    public String scoresToString(ArrayList<Score> scores) {
    	String s = "<html><body>";
    	Collections.sort(scores);
    	int max = 0;
    	if (scores.size() >= 5) {
    		max = 5;
    	} else {
    		max = scores.size();
    	}
    	for(int i = 0; i < max; i++) {
    		Score currentScore = scores.get(i);
    		s += (i+1) + ". " + currentScore.getName() + "   |   " + currentScore.getScore() + "<br>";
    	}
    	s += "</body></html>";
    	return s;
    }
    
    /**
     * Escribe una palabra nueva en el fichero Palabras
     * @param w Palabra a añadir
     */
    public void writeWord(String w) {
    	w = w.toUpperCase();
    	wordsWriter.writeLine(w);
    }
}
