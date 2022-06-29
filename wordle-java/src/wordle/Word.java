package wordle;

public class Word {

	private Letter[] word;
	
	public Word(String word) {
		this.word = new Letter[word.length()];
		for (int i = 0; i < word.length(); i++)
			this.word[i] = new Letter(word.charAt(i));
		if(word.length() != 5) {
			System.out.print("La palabra no tiene 5 letras.");
		}
	}
	
	public void printArray() {
		String s = "[ ";
		for(int i = 0; i < 5; i++) {
			s += word[i]+" ";
		}
		s += "]";
		System.out.println(s);
	}
	
	public Letter[] getArray() {
		return word;
	}
	
	public Letter LetterAt (int index) {
		return word[index];
	}
	
	public int lenght() {
		return word.length;
	}
	
	public String toString() {
		String s = "";
		for(Letter element: word) {
			s += element.getChar();
		}
		return s;
	}
	
}
