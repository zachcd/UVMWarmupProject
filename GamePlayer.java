
public class GamePlayer {

	private GameInterface iface;
	private GameStats stats;
  private GameBoard board;

	public GamePlayer () 
	{
		boolean quit = false;
		
		iface = new GameInterface();
		stats = new GameStats();
		board = new GameBoard(BoardType.TRIANGLE);
		
		iface.showWelcome();
		
		while(!quit)
		{
			iface.showPlayMenu(BoardType.TRIANGLE);
			
			char c = iface.getChar("PCSHQ");
			switch(c){
				case 'P': this.playGame();
									break;

				case 'H': iface.showHelp(board.boardType());
									break;
								
				case 'S': System.out.println(stats.showStats());
									break;

				case 'C': iface.showBoardMenu();
									char bt = iface.getChar("ET");
									switch(bt) 
									{
										case 'E': board = new GameBoard(BoardType.ENGLISH); break;
										case 'T': board = new GameBoard(BoardType.TRIANGLE); break;
									}
									break;

				case 'Q': iface.showFarewell(stats.showStats());
									quit = true;
									break;
			}


		}
	}

	private void playGame()
	{
		int startTime = System.currentTimeMillis()/1000;
		
		char maxChar;
		int maxNum;
		String move = "";
		
		if(board.boardType() == BoardType.TRIANGLE)
		{
			maxChar = 'e';
			maxNum = 5;
		}
		else
		{
			maxChar = 'g';
			maxNum = 7;
		}
		
		int sx, sy, dx, dy = 0;
		
		iface.showBoard();

		while(!quit && !board.isDone())
		{

			move = iface.getMove(maxChar, maxNum);
			if(move.length() > 1)
			{
				sx = Character.getNumericValue(move.charAt(1));
				sy = move.charAt(0) - 'a' + 1;
				dx = Character.getNumericValue(move.charAt(3));
				dy = move.charAt(0) - 'a' + 1;
				
				if(!board.move(sx, sy, dx, dy))
				{
					System.out.println("Invalid move...");
				}
				else
				{
					iface.showBoard();
				}	
			}
			else if(move == "q")
			{
				quit = TRUE;
			}		
		}
		
		int endTime = System.currentTimeMillis()/1000;
		
		stats.addGameData(board.numPegs(), endTime - startTime, board.boardType());
		
		if(board.winner())
			iface.congrats();
				
		
	}
	
	public static void main(String args[]) 
	{
		GamePlayer game = new GamePlayer();
	}
}