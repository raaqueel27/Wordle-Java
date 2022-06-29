package wordle;

public class Score implements Comparable<Score>{
	
	private String user;
	private int score;
	
	public Score(String user,int score) {
		this.user = user;
		this.score = score;
	}
	
	@Override
	public int compareTo(Score o) {
		if (this.getScore() > o.getScore())
			return -1;
		if (this.getScore() < o.getScore())
			return 1;
		else
			return 0;
	}
	public String toString() {
		return user + "#" + score;
	}
	
	public String getName() {
		return user;
	}
	
	public int getScore() {
		return score;
	}
}
