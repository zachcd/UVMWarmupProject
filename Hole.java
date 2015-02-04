/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// 
// public methods
// 
// 
// 
// 
// 
// 
// 
//  boardType()
//  
//  
//  isDone()
//  
//  move(src, dest) 
//  
//  numPegs()   * from 1 to last    & if peg is in array, count 1.  at end return numPegs.
//  
//  toString()  from 1 to last  & if hole is empty return (O) if peg is not in array return (B), if blue peg is in return (*),
//  if red return (r)
//  
//  winner()  check if numPegs()
//  
 
 public enum Hole {
     FILLED, EMPTY, NONE
 }
 
public class GameBoard{
	
	public GameBoard(BoardType type) {
		
		if (type== BoardType.TRIANGLE) {
		Hole[] board;

		board = new Hole[5][5];
		    
		 board [0][0] = Hole.FILLED;
		 board [0][1] = Hole.EMPTY;
		 board [1][1] = Hole.NONE;
		 

		for (int i = 0; i < 5; i++) {
		    for (int j = 0; j < 5; j++) {
		        board[i][j] = FILLED;
		    }
		    for (int k = j; j < 5; k < 5; k++) {
		        board[i][k] = NONE;
		    }
		    }
		       
		board[2][1] = EMPTY;
		} else {
	         //ENGLISHBOARD  
	           
	          
	         
			 for (int i = 0; i < 7; i++) {
				 for (int j = 0; j < 7; j++) {
			 }
			         board[i][j] = FILLED;
			    }
			    for (int i = 0; i < 2; i++) {
			     for (int j = 0; j < 2; j++) {
			         board[i][j] = NONE;
			         board[i][6-j] = NONE;
			         board[6-i][j] = NONE;
			         board[6-i][6-j] = NONE;
			     }
			         
			 
			     }
			             }
			     
			            board[3][3] = EMPTY;
		
		}
		
		
	}


           
           
           
           
           
 

           
       

public bool move(int startx, int starty, int destx, int desty) {
// check if valid;
	if(destx < 0 || desty < 0 || destx > 5 || desty > 5 ||startx < 0 || starty < 0 || startx > 5 || starty > 5 ) {
		return false;
	}
	if(isValid(startx, starty, destx, desty)) {
  		 board[startx][starty] = EMPTY;
  		 board[destx][desty] = FILLED;
  		 board[(startx + destx) / 2][(starty + desty) /2] == EMPTY)//removes peg from board  
  		 return true;
   }   else {
       return false;
   }
}
   
   

   
           
       

            
           
  
           
           
   private bool isValid(int startx, int starty, int destx,int desty) {
       if(this.type) == ENGLISH) {
    if(startx != destx && starty != desty){
        return false;
       }
    
  if(board[startx][starty] == FILLED &&
   board[destx][desty] == EMPTY &&
   board[(startx + destx) / 2][(starty + desty) /2] == FILLED){
	  return true;
  }   
   else
       return false;
   }
   }
          
          
public bool isDone() {
    for(int i = 0; i < 7; i++) {
        for(int j = 0; j < 7; j++)
        {
           if((isValid(i,j,i+2,j+2) || 
           (isValid(i,j,i+2,j) ||
           (isValid(i,j,i,j+2) ||
           (isValid(i,j,i-2,j-2) ||
           (isValid(i,j,i-2,j) ||
           (isValid(i,j,i,j-2) ||
           (isValid(i,j,i+2,j-2) ||
           (isValid(i,j,i-2,j+2))
   return true;
        }
        }
    return false;
  }
        
           
           
               
            
}
}