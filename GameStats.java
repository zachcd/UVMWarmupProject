

public class GameStats {
	 private int EnglishPegTotal;
	 private int EnglishGameTotal;
	 private int EnglishTimeTotal;
	 private int TrianglePegTotal;
	 private int TriangleGameTotal;
	 private int TriangleTimeTotal;
	 
	 public GameStats() {
		 
	 }
	 
	 public void addGameData(int pegsleft,int time, BoardType BType) {
		 if (BType == English) {
			 EnglishPegTotal = EnglishPegTotal + pegsleft;
			 EnglishGameTotal = EnglishGameTotal + 1;
			 EnglishTimeTotal = EnglishTimeTotal + time;
		 } else {
			 TrianglePegTotal = TrianglePegTotal + pegsleft;
			 TriangleGameTotal = TriangleGameTotal + 1;
			 TriangleTimeTotal = TriangleTimeTotal + time;
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
}
