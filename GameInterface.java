
import java.util.Scanner;

public class GameInterface
{
  private Scanner scanner;  
  
	public GameInterface()
  {
     	System.out.println("CS205 Warmup Project");
			scanner = new Scanner(System.in);
			
  }

	public void showWelcome()
	{
		System.out.println("Hello");
		
	}
	
	public void showFarewell(String stats)
	{
		System.out.println("Here is how you did today:\n");
		System.out.println(stats);
		System.out.println("Thank you for playing.");
	}
	
	/*** 
		showPlayMenu - Displays the main gameplaying menu
			NB: no input is taken (use getInput)
	 ***/
	public void showPlayMenu(BoardType bt)
	{
		String message = "Menu:\n";
		message +=        "=====\n";
		
		message += "(P)lay game\n";
		message += "(C)hoose board type (Current: ";
		switch (bt) {
			case TRIANGLE: message += "Triangle";
										 break;
			case ENGLISH: message += "English";
										 break;
		  default: message += "Unknown";
		  				 break;
		}
		
		message += ")\n";
		message += "View (S)tats\n";
		message += "(H)elp\n";
		message += "Enter choice: ";
		
		System.out.print(message);
		
		
	}
	
	/*** 
		showBoardMenu - Displays the menu for selecting a board
			NB: no input is taken (use getInput)
	 ***/
	public void showBoardMenu()
	{
		showBoardMockups();
		
		String message = "Board Type:\n";
		message +=       "===========\n";
		
		message += "(T)riangle\n";
		message += "(E)nglish\n";
		message += "Enter your choice: ";
		
		System.out.print(message);
	}
	
	/***
	 showBoardMockups - displays a mockup of the board types 
	 ***/
	private void showBoardMockups()
	{
//		System.out.println("Board Mockups go here");
		String message = "";
		message += "                   * * *    \n";
		message += "     *             * * *    \n";
		message += "    * *        * * * * * * *\n";
		message += "   * o *       * * * o * * *\n";
		message += "  * * * *      * * * * * * *\n";
		message += " * * * * *         * * *    \n";
		message += "                   * * *    \n";
		message += "\n  Triangle         English\n\n";
		
		System.out.println(message);
	}

	public void showHelp(BoardType bt)
	{
		String message = "HELP:\n=====\n";
		message += "The object of the game is to remove all but one peg. You remove a peg\n";
		message += "by jumping over it with another peg. You can jump only one peg at a\n";
		message += "time. Pegs can only move through jumping. ";

		if(bt == BoardType.ENGLISH)
		{
			message += "Pegs can jump only\nhorizontally or vertically, they cannot jump diagonally.\n\n";
			message += "You define a move by specifying the from position and the to position\n";
			message += "using the row and column of the position. The rows are labeled 'a'\n";
			message += "through 'g' and the columns are labeled '1' through '7'. Therefore\n";
			message += "the center of the board is position 'd4'.\n\n";
		}
		else
		{
			message += "Pegs can jump in any\ndirection.\n\n";

			message += "You define a move by specifying the from position and the to position\n";
			message += "using the row and place within that row. The rows are labeled 'a'\n";
			message += "through 'e'. Therefore the peg in the middle of the bottom row is in\n";
			message += "position 'e3' and the peg at the top of the triangle is in position\n";
			message += "'a1'.\n\n";
		}

		message += "Positions containing a peg are represented by '*'. Empty positions \n";
		message += "are represented by 'o'. The game will end when there are no more valid\n";
		message += "moves available.\n\n";
		
		System.out.print("\n\n\n");
		
		System.out.print(message);
		
		enterToCont();

	}
	
	public void showBoard(BoardType bt, String board)
	{
		
	}
	
	/***
	 getMove - gets a move such that from and two are in the proper range
	 PRE: maxChar and maxNum are defined
	 POST: FCTVAL == "wxyz" where  'a' <= w <= maxChar and 1 <= x <= maxNum and
	 															 'a' <= y <= maxChar and 1 <= z <= maxNum
	 ***/
	public String getMove(char maxChar, int maxNum)
	{
		
		String move = "";
		String to = "";
		
		System.out.println("Please enter your move:");

		String from = getValidPosition("From (ex: e3; x to cancel): ", maxChar, maxNum);
		
		if(from.charAt(0) != 'x')
		{
			to = getValidPosition("To (ex: e3; x to cancel): ", maxChar, maxNum);
			
			if(to.charAt(0) != 'x')
				return from + to;
			else
				return "x";
		}
		else
			return "x";
	}   
	
	/***
	 getValidPosition - Prompts the user and ensures a valid response
	 PRE: prompt, maxChar and maxNum defined
	 POST: FCTVAL == "xy" where 'a' <= x <= maxChar and 1 <= y <= maxNum
	 ***/ 
	private String getValidPosition(String prompt, char maxChar, int maxNum) {
		
		boolean invalid = true;
		String entry = "";
		
		while(invalid){
			invalid = false;
			System.out.print(prompt + " ");
			
			entry = scanner.nextLine();
			
			//System.out.println("Your choice: " + entry);
			
			if( entry.length() > 0 && entry.toLowerCase().charAt(0) == 'x' )
				return "x";
			else if(entry.length() < 2)
			{
				System.out.println("Invalid Entry");
				invalid = true;
			}
			else
			{
				if(entry.charAt(0) < 'a' || 
					 entry.charAt(0) > maxChar)
				{
					System.out.println("Invalid Row");
					invalid = true;
				}
				
				if(!Character.isDigit(entry.charAt(1)) ||
						Character.getNumericValue(entry.charAt(1)) > maxNum ||
						Character.getNumericValue(entry.charAt(1)) < 1)
				{
					System.out.println("Invalid Column");
					invalid = true;
				}
				
			}
		}
		
		return entry;
		
	}
	
	public void congrats()
	{
		System.out.println("Congratulations! You win!!!");
		
		enterToCont();
	}
	
	
	/***
	 enterToCont - waits for entry from the user in order to pause 
	 							 operation
	 PRE: none
	 POST: none
	 ***/
	private void enterToCont()
	{ 
	      System.out.println("Press enter to continue...");
	      
	      scanner.nextLine(); 
	}	
	 
	 
	/***
	 getChar - gets a character from the user and makes sure it is valid
	 by making sure it appears in valid
	 PRE: valid is a sting containing all response characters considered valid
	 POST: FCTVAL == char s.t. char is in valid
	 ***/
	public char getChar(String valid)
	{
		valid = valid.toUpperCase();
		String entry = scanner.nextLine();
		while (entry.length() < 1 ||
					 valid.indexOf(entry.toUpperCase().charAt(0)) < 0)
		{
			System.out.print("Invalid entry, try again: ");
			entry = scanner.nextLine();
		}
			
		return entry.toUpperCase().charAt(0);			 
	
	}
	
	public static void main(String[] args) {	
		
		Scanner tempScanner = new Scanner(System.in);
		GameInterface iface = new GameInterface();
		String move = "";
		char bt = 'T';
		
		iface.showPlayMenu(BoardType.TRIANGLE);
		
		char c = iface.getChar("PCSH");
		switch(c){
			case 'P': System.out.println("Playing the game...");
								move = iface.getMove('e', 5);
								break;
			case 'H': switch(bt) {
								case 'E': iface.showHelp(BoardType.ENGLISH);
												  break;
								case 'T': iface.showHelp(BoardType.TRIANGLE);
												  break;
								}
								break;
			case 'S': System.out.println("showStats");
								break;
			case 'C': iface.showBoardMenu();
								bt = iface.getChar("ET");
								break;
		}
			int sx, sy, dx, dy = 0;
		if(move.length() > 0)
		{
			System.out.print(Character.getNumericValue(move.charAt(1)));
			System.out.print(" " + (move.charAt(0) - 'a' + 1));
			System.out.print(" " + Character.getNumericValue(move.charAt(3)));
			System.out.print(" " + (move.charAt(2) - 'a' + 1));
		}
			
		
	}
		
}