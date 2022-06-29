package wordle;

import java.util.ArrayList;
import java.util.Scanner;

public class Wordle {

	private String guess;
	private int attemptsLeft;
	private int score;
	private User user;
	
	public Wordle(User user) {
		guess = randomGuess().toUpperCase();
		attemptsLeft = 5;
		this.user = user;
	}
	
	public static String randomGuess() {
		FileManagment fm = new FileManagment();
		int choices = fm.getNumberOfWords(); 
		int randomChoice = (int)(Math.random() * (choices));
		ArrayList<String> words = fm.readWords();
		String guess = words.get(randomChoice);
		return guess;
	}
	
	public String getGuess() {
		return guess;
	}
	
	public int getAttemptsLeft() {
		return attemptsLeft;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@SuppressWarnings("resource")
	public Word askGuess() throws Exception {
		String word;
		Word w;
		Scanner input = new Scanner(System.in);
		word = input.nextLine().toUpperCase();
		if (word.length() != word.length())
			throw new Exception("Ambas palabras deben tener la misma longitud (se obtuvo " + word.length()
					+ " y se esperaba " + word.length() + ")");
		w = new Word(word);
		return w;
	}
	
	public static boolean isValid(Word attempt) {
		if(attempt.lenght() == 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isCorrect(Word attempt) {
		String a = attempt.toString();
		if(a.equals(guess)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void checkGuess(Letter[] attempt) {
		for(int i = 0; i < 5; i++) {
			isYellow(attempt[i]);
			isGreen(attempt,i);
		}
	}
	
	public void isYellow(Letter l) {
		char c = l.getChar();
		l.setExists(false);
		for(int i = 0; i < guess.length(); i++) {
			if(guess.charAt(i) == c) {
				l.setExists(true);
			}
		}
	}
	
	public void isGreen(Letter[] word, int pos) {
		char c = word[pos].getChar(); 
		word[pos].setCorrectPosition(false);
		if(guess.charAt(pos) == c) {
			word[pos].setCorrectPosition(true);
		}
	}
	
}
