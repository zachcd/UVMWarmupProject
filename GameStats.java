import java.util.*;

//Game stats is the complete class handling the statistics for the game board
// it takes in new game data with the add data method
//and has various get methods for printing the statistics
//it also has a simplistic showStats() method, which shows all stats. 
public class GameStats {
	 private int EnglishPegTotal;
	 private int EnglishGameTotal;
	 private long EnglishTimeTotal;
	 private int TrianglePegTotal;
	 private int TriangleGameTotal;
	 private long TriangleTimeTotal;
	 ArrayList<Integer> Triangle = new ArrayList<Integer>();
	 ArrayList<Long> TriangleTimes = new ArrayList<Long>();
	 ArrayList<Integer> English = new ArrayList<Integer>();
	 ArrayList<Long> EnglishTimes = new ArrayList<Long>();

	 public static void main(String[] args) {
		 //This is a tester
           GameStats stats = new GameStats();
           stats.showStats();
	        
        	 }
	 public GameStats() {
		 	//basic constructor
	 }

	 public void addGameData(int pegsleft,long time, BoardType BType) {
		 if (BType == BoardType.ENGLISH) {
			 //if the board type is english
			 EnglishPegTotal = EnglishPegTotal + pegsleft;
			 EnglishGameTotal = EnglishGameTotal + 1;
			 EnglishTimeTotal = EnglishTimeTotal + time;
			 English.add(Integer.valueOf(pegsleft));
			 EnglishTimes.add(Long.valueOf(time));
		 } else {
			 //if the board is a triangle
			 TrianglePegTotal = TrianglePegTotal + pegsleft;
			 TriangleGameTotal = TriangleGameTotal + 1;
			 TriangleTimeTotal = TriangleTimeTotal + time;
			 Triangle.add(Integer.valueOf(pegsleft));
			 TriangleTimes.add(Long.valueOf(time));
		 }


	 }
	 public int getEnglishAveragePegs(){
		 if (EnglishGameTotal == 0) {
			 return 0;
		 }
		 return EnglishPegTotal / EnglishGameTotal;
	 }
	 public int getTriangleAveragePegs(){
		 if (TriangleGameTotal == 0) {
			 return 0;
		 }
		 return TrianglePegTotal / TriangleGameTotal;
	 }
	 public long getEnglishAverageTime() {
		 if (EnglishGameTotal == 0) {
			 return 0;
		 }
		 return EnglishTimeTotal / EnglishGameTotal;
	 }
	 public long getTriangleAverageTime() {
		 if (TriangleGameTotal == 0) {
			 return 0;
		 }
		 return TriangleTimeTotal/ TriangleGameTotal;
	 }
	 public String getTriangleChart() {
		 String ret;
		 ret = "_____________\n"; //top bar
		 ret+="Pegs| Time\n"; //labels
		 for (int i = 0; i < Triangle.size(); i++){
			 ret+=Triangle.get(i) + "   |  " + TriangleTimes.get(i) + "\n";//appends the pegs and the time with a spacer
		 }
		 return ret;

	 }
	 public String showStats() {
		 String ret;
		 ret="English Average Pegs:\n";
		 ret+=getEnglishAveragePegs() +"\n";
		 ret+="Triangle Average Pegs:\n";
		 ret+=getTriangleAveragePegs() +"\n";
		 ret+="English Average Time:\n";
		 ret+=getEnglishAverageTime() +"\n";
		 ret+="Triangle Average Time:\n";
		 ret+=getTriangleAverageTime() +"\n";
		 ret+="English Chart:\n";
		 ret+=getEnglishChart();
		 ret+="Triangle Chart:\n";
		 ret+=getTriangleChart();
		 ret+="English Graph:\n";
		 ret+=getEnglishGraph();
		 ret+="Triangle Graph:\n";
		 ret+=getTriangleGraph();
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
		 int LargestPeg = 0;//this is to get the size needed for the graph
		 for (int i = 0; i < English.size(); i++){
			 if (English.get(i) > LargestPeg) {
				 LargestPeg = English.get(i);
			 }
		 }
		 String ret = "_______________________________________________________________\n"; //top bar for the graph
		 for (int i = LargestPeg; i >= 0; i--) {
			 ret+=i + " |";
			 for (int j = 0; j < English.size(); j++){
				 if (English.get(j) == i) {
					 ret+="*";//add a dot for that this space is occupied.
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
