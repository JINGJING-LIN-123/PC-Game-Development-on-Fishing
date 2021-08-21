package Models;

public class RankingList {

	private  String Ranking;

	private  String Score;

	public RankingList() {	}
	
	public RankingList(String Ranking, String Score) {
		
		this.Ranking=Ranking;
		this.Score=Score;
	}

	public String getRanking() {
		return Ranking;
	}

	public void setRanking(String ranking) {
		Ranking = ranking;
	}

	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		Score = score;
	}
	
	
	
	

	
	



	
}
