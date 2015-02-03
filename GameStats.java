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
	 
	 
	 public GameStats() {
		 
	 }
	 
	 public void addGameData(int pegsleft,int time, BoardType BType) {
		 if (BType == ENGLISH) {
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
		 return EnglishPegTotal / EnglishGameTotal
	 }
	 public int getTriangleAveragePegs(){
		 return TrianglePegTotal / TriangleGameTotal
	 }
	 public int getEnglishAverageTime() {
		 return EnglishTimeTotal / EnglishGameTotal
	 }
	 public int getTriangleAverageTime() {
		 return TriangleTimeTotal/ TriangleGameTotal
	 }
	 public String getTriangleChart() {
		 String ret;
		 ret = "_____________\n";
		 ret.concat("Pegs | Time\n");
		 for (int i = 0; i < Triangle.size(); i++){
			 ret.concat(Triangle.get(i) + "  |  " + TriangleTimes.get(i));
		 }
		 return ret;
				 
	 }
	 public String getEnglishChart() {
		 String ret;
		 ret = "_____________\n";
		 ret.concat("Pegs | Time\n");
		 for (int i = 0; i < English.size(); i++){
			 ret.concat(English.get(i) + "  |  " + EnglishTimes.get(i));
		 }
		 return ret;
	 }
	 
	 public String getEnglishGraph() {
		 int LargestPeg = 0
		 for (int i = 0; i < English.size(); i++){
			 if (English.get(i) > LargestPeg) {
				 LargestPeg = English.get(i);
			 }
		 }
		 String ret = "_______________________________________________________________\n";
		 for (int i = LargestPeg; i >= 0; i--) {
			 ret.concat(i + " |");
			 for (int j = 0; j < English.size(); j++){
				 if (English.get(j) == i) {
					 ret.concat("*");
				 } else {
					 ret.concat(" ");
				 }
			 } 
			 ret.concat("\n");
			 
		 }
		 
	 }
	 public String getTriangleGraph() {
		 int LargestPeg = 0
		 for (int i = 0; i < Triangle.size(); i++){
			 if (Triangle.get(i) > LargestPeg) {
				 LargestPeg = Triangle.get(i);
			 }
		 }
		 String ret = "_______________________________________________________________\n";
		 for (int i = LargestPeg; i >= 0; i--) {
			 ret.concat(i + " |");
			 for (int j = 0; j < Triangle.size(); j++){
				 if (Triangle.get(j) == i) {
					 ret.concat("*");
				 } else {
					 ret.concat(" ");
				 }
			 } 
			 ret.concat("\n");
			 
		 }
		 
	 }
}
