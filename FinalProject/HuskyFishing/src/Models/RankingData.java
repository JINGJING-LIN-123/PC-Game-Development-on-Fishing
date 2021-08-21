package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankingData {

	//private String Ranking;



	//private String Score;
	public static List list = new ArrayList();
	//public RankingData() {
	//}
	//public void	getData() {
		//File file=new File("data/rankinglist.txt");
		//try {
			//FileInputStream inputStream = new FileInputStream(file);
			//InputStreamReader reader=new InputStreamReader(inputStream);
			//BufferedReader bufferedReader=new BufferedReader(reader);
			//list.clear();
			//while ((Ranking=bufferedReader.readLine())!=null) {

				//Score=bufferedReader.readLine();
				//list.add(new RankingList(Ranking, Score));
			//}
			//bufferedReader.close();
			//reader.close();
			//inputStream.close();

		//} catch (FileNotFoundException e) {
			//e.printStackTrace();
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
	//}
	public void sortScore() {
		Collections.sort(list);
		Collections.reverse(list);
	}
	public void addScore(int score){
		if(list == null || list.size() < 3){
			list.add(score);
			sortScore();
		} else {
			int lastNum = (int)list.get(list.size()-1);
			if(score > lastNum){
				list.remove(list.size()-1);
				list.add(score);
				sortScore();
			}

		}
		try (FileWriter writer = new FileWriter("output.txt")) {
			for (int i = 0; i < list.size(); i++) {
				writer.write("" + list.get(i) + System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List getTopThreeScore(){
		return list;
	}

}
