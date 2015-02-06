/**********************************
 CS205 Warmup Project
 Aaron Brunet, Jonathan Carter, Zachary Chay-Dolan,  Joseph Corbett
 
 GamePlayer - class to manage the peg solitaire gameplay
 Main author: Jonathan Carter
 ***********************************/
import java.util.Random;

public class GameAutoPlayer {

	private GameInterface iface; // handles user interaction
	private GameStats stats;			// stores and presents stats
  private GameBoard board;			// representation of the game board

	public GameAutoPlayer () 
	{
		boolean quit = false;
		
		iface = new GameInterface();
		stats = new GameStats();
		board = new GameBoard(BoardType.ENGLISH);
		
		iface.showWelcome();

		// Start main gameplay loop		
		while(!quit)
		{
			iface.showPlayMenu(board.boardType());
			
			char c = iface.getChar("PCSHQ");
			
			// Handle the user's menu choice
			switch(c){
				
				// Play game
				case 'P': for(int i = 0; i < 9; i++)
									{
										board = new GameBoard(BoardType.ENGLISH);
										this.playGame();
									}
									for(int j = 0; j < 9; j++)
									{
										board = new GameBoard(BoardType.TRIANGLE);
										this.playGame();
									}
	
									break;

				// Show Help
				case 'H': iface.showHelp(board.boardType());
									break;
								
				// show statistics
				case 'S': System.out.println(stats.showStats());
									break;
				
				// Show menu to select board type
				case 'C': iface.showBoardMenu();
									char bt = iface.getChar("ET");
									switch(bt) 
									{
										case 'E': board = new GameBoard(BoardType.ENGLISH); break;
										case 'T': board = new GameBoard(BoardType.TRIANGLE); break;
									}
									break;
				
				// Quit
				case 'Q': System.out.print("Are you sure you want to quit? (Y/N)");
									if(iface.getChar("YN") == 'Y')
									{
										iface.showFarewell(stats.showStats());
										quit = true;
									}
									break;
			}


		}
	}

	/******************************************************
	 playGame - manages the playing of a single game of peg
	 						solitaire
	 PRE: board and iface must be initialized
	 ******************************************************/
	private void playGame()
	{
		// start the stopwatch
		long startTime = System.currentTimeMillis();
		Random rand = new Random(System.currentTimeMillis());
		
		
//		int maxRow; // number of rows in the board
		int maxNum;		// number of columns in the board
		String move = "";
		
		if(board.boardType() == BoardType.TRIANGLE)
		{
//			maxRow = 5;
			maxNum = 5;
		}
		else
		{
//			maxRow = 7;
			maxNum = 7;
		}
		
		
//		int sx, sy, dx, dy = 0; // start and destination x & y values
		
		iface.showBoard(board.boardType(), board.toString());

		boolean quit = false;
		
		while(!board.isDone())
		{		
			// generate a random move
//			sx = rand.nextInt(maxNum);
//			sy = move.charAt(maxNum) - 'a';
//			dx = Character.getNumericValue(move.charAt(3))-1;
//			dy = move.charAt(2) - 'a';
			
			// attempt to move the peg and update if it works
			while(!board.move(rand.nextInt(maxNum), rand.nextInt(maxNum), rand.nextInt(maxNum), rand.nextInt(maxNum)))
			;

			iface.showBoard(board.boardType(), board.toString());
		}
		
		long endTime = System.currentTimeMillis();
		
		stats.addGameData(board.numPegs(), endTime - startTime, board.boardType());
		
//		if(board.winner())
//			iface.congrats();
//		else
//			iface.lost(board.numPegs());
				
		
	}
	
	/*** 
	 main - entry point for the peg solitaire game
	 ***/
	public static void main(String args[]) 
	{
		GameAutoPlayer game = new GameAutoPlayer();
	}
}