package wordle;

public class Letter {

	private final char c;
	private boolean exists;
	private boolean correctPosition;
	
	public Letter(char c) {
		this.c = c;
		exists = false;
		correctPosition = false;
	}
	
	public char getChar() {
		return c;
	}
	
	public boolean exists() {
		return exists;
	}
	
	public boolean isInCorrectPosition() {
		return correctPosition;
	}
	
	public void setExists(boolean exists) {
		this.exists = exists;
	}
	
	public void setCorrectPosition(boolean correctPosition) {
		this.correctPosition = correctPosition;
	}
	
	public String toString() {
		String s = String.valueOf(c);
		return s;
	}
	
}
