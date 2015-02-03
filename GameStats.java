import java.util.*;


public class GameStats {
	 private int EnglishPegTotal;
	 private int EnglishGameTotal;
	 private int EnglishTimeTotal;
	 private int TrianglePegTotal;
	 private int TriangleGameTotal;
	 private int TriangleTimeTotal;
	 ArrayList<Integer> Triangle = new ArrayList<Integer>();
	 ArrayList<Integer> TriangleTimes = new ArrayList<Integer>();
	 ArrayList<Integer> English = new ArrayList<Integer>();
	 ArrayList<Integer> EnglishTimes = new ArrayList<Integer>();

	 public static void main(String[] args) {
        GameStats stats = new GameStats();
        stats.addGameData(2, 50, BoardType.ENGLISH);
        stats.addGameData(4, 70, BoardType.ENGLISH);
        stats.addGameData(5, 90, BoardType.ENGLISH);
        System.out.println(stats.getEnglishAveragePegs());
        System.out.println(stats.getEnglishChart());
        System.out.println(stats.getEnglishGraph());
        stats.addGameData(7, 100, BoardType.TRIANGLE);
        stats.addGameData(6, 90, BoardType.TRIANGLE);
        stats.addGameData(5, 80, BoardType.TRIANGLE);
        stats.addGameData(4, 60, BoardType.TRIANGLE);
        stats.addGameData(3, 50, BoardType.TRIANGLE);
        stats.addGameData(2, 50, BoardType.TRIANGLE);
        System.out.println(stats.getTriangleAveragePegs());
        System.out.println(stats.getTriangleChart());
        System.out.println(stats.getTriangleGraph());
	 }
	 public GameStats() {

	 }

	 public void addGameData(int pegsleft,int time, BoardType BType) {
		 if (BType == BoardType.ENGLISH) {
			 EnglishPegTotal = EnglishPegTotal + pegsleft;
			 EnglishGameTotal = EnglishGameTotal + 1;
			 EnglishTimeTotal = EnglishTimeTotal + time;
			 English.add(Integer.valueOf(pegsleft));
			 EnglishTimes.add(Integer.valueOf(time));
		 } else {
			 TrianglePegTotal = TrianglePegTotal + pegsleft;
			 TriangleGameTotal = TriangleGameTotal + 1;
			 TriangleTimeTotal = TriangleTimeTotal + time;
			 Triangle.add(Integer.valueOf(pegsleft));
			 TriangleTimes.add(Integer.valueOf(time));
		 }


	 }
	 public int getEnglishAveragePegs(){
		 return EnglishPegTotal / EnglishGameTotal;
	 }
	 public int getTriangleAveragePegs(){
		 return TrianglePegTotal / TriangleGameTotal;
	 }
	 public int getEnglishAverageTime() {
		 return EnglishTimeTotal / EnglishGameTotal;
	 }
	 public int getTriangleAverageTime() {
		 return TriangleTimeTotal/ TriangleGameTotal;
	 }
	 public String getTriangleChart() {
		 String ret;
		 ret = "_____________\n";
		 ret+="Pegs| Time\n";
		 for (int i = 0; i < Triangle.size(); i++){
			 ret+=Triangle.get(i) + "   |  " + TriangleTimes.get(i) + "\n";
		 }
		 return ret;

	 }
	 public String getEnglishChart() {
		 String ret;
		 ret = "_____________\n";
		 ret+="Pegs | Time\n";
		 for (int i = 0; i < English.size(); i++){
			 ret+=English.get(i) + "   |  " + EnglishTimes.get(i) + "\n";
		 }
		 return ret;
	 }

	 public String getEnglishGraph() {
		 int LargestPeg = 0;
		 for (int i = 0; i < English.size(); i++){
			 if (English.get(i) > LargestPeg) {
				 LargestPeg = English.get(i);
			 }
		 }
		 String ret = "_______________________________________________________________\n";
		 for (int i = LargestPeg; i >= 0; i--) {
			 ret+=i + " |";
			 for (int j = 0; j < English.size(); j++){
				 if (English.get(j) == i) {
					 ret+="*";
				 } else {
					 ret+=" ";
				 }
			 }
			 ret+="\n";

		 }
		 ret+="_______________________________________________________________\n";
		 ret+="   ";
		 for (int k = 1; k <= English.size(); k++){
			 ret+=k;
		 }
		 return ret;
	 }
	 public String getTriangleGraph() {
		 int LargestPeg = 0;
		 for (int i = 0; i < Triangle.size(); i++){
			 if (Triangle.get(i) > LargestPeg) {
				 LargestPeg = Triangle.get(i);
			 }
		 }
		 String ret = "_______________________________________________________________\n";
		 for (int i = LargestPeg; i >= 0; i--) {
			 ret+=i + " |";
			 for (int j = 0; j < Triangle.size(); j++){
				 if (Triangle.get(j) == i) {
					 ret+="*";
				 } else {
					 ret+=" ";
				 }
			 }
			 ret+="\n";

		 }
		 ret+="_______________________________________________________________\n ";
		 ret+="   ";
		 for (int k = 1; k <= Triangle.size(); k++){
			 ret+=k;
		 }
		 return ret;
	 }
}
