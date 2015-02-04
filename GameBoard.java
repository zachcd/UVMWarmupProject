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

public class GameBoard{
	
   //declare variables
   private Hole[][] board;
   private BoardType type;
   
	public GameBoard(BoardType type) {
		this.type = type; 
      
      if (type== BoardType.TRIANGLE) {
		//TRIANGLE

		board = new Hole[5][5];
		    
		 board [0][0] = Hole.FILLED;
		 board [0][1] = Hole.EMPTY;
		 board [1][1] = Hole.NONE;
		 

		for (int i = 0; i < 5; i++) {
		    for (int j = 0; j <= i ; j++) {
		        board[i][j] = Hole.FILLED;
		    
//   		    for (int k = j; k < 5; k++) {
//   		        board[k][i] = Hole.NONE;
   		    }//end nested for
          //}//end parent for
		}
		       
		board[2][1] = Hole.EMPTY;
		} 
      else {
	   //ENGLISHBOARD  
			     
			board = new Hole[7][7];  
	         
			 for (int i = 0; i < 7; i++) {
				 for (int j = 0; j < 7; j++) {
			 
			         board[i][j] = Hole.FILLED;
			    }//end nested for
          }//end for
			 for (int i = 0; i < 2; i++) {
			     for (int j = 0; j < 2; j++) {
			         board[i][j] = Hole.NONE;
			         board[i][6-j] = Hole.NONE;
			         board[6-i][j] = Hole.NONE;
			         board[6-i][6-j] = Hole.NONE;
			     }//end nested for 
          }//end for
          board[3][3] = Hole.EMPTY;
		}//end else
		
	}//end constructor
   public boolean move(int startx, int starty, int destx, int desty) {
   // check if valid;
    System.out.println("" + startx + " " + starty + " " +  destx + " " + desty);
   	
//   	if(destx < 0 || desty < 0 || destx > 5 || desty > 5 ||startx < 0 || starty < 0 || startx > 5 || starty > 5 ) {
//			if(isValid (startx, starty, destx, desty))
//	   		return false;
//   	}
   	if(isValid(startx, starty, destx, desty)) {
     		 board[starty][startx] = Hole.EMPTY;
     		 board[desty][destx] = Hole.FILLED;
     		 board[(starty + desty) / 2][(startx + destx) /2] = Hole.EMPTY; //removes peg from board  
     		 return true;
      }   else {
          return false;
      }
   }//end move     
   public BoardType boardType() {
	   return type;
   }
   private boolean isValid(int startx, int starty, int destx,int desty) {
       if(startx < 0 || starty < 0 || destx < 0 || desty < 0)
       	return false;
       
       if((this.type) == BoardType.ENGLISH) {
       	 if(startx > 6 || starty > 6 || destx > 6 || desty > 6)
       	   return false;
       		
          if(startx != destx && starty != desty){
//          		System.out.println("Diagonal: " + startx + starty + destx + dest);
              return false;
             }
        }//first if  
        else if(startx > 4 || starty > 4 || destx > 4 || desty > 4)
        	return false;
        	  
        if(board[starty][startx] == Hole.FILLED &&
         	 board[desty][destx] == Hole.EMPTY &&
         	 board[(starty + desty) / 2][(startx + destx) /2] == Hole.FILLED){
      	  	 return true;
        }   
         else{
//         	System.out.println("Bad move?");
             return false;
        }   
   }//end isValid
                
   public boolean isDone() {
   	if (type == BoardType.ENGLISH){
       for(int i = 0; i < 7; i++) {
           for(int j = 0; j < 7; j++)
           {
              if((isValid(i,j,i+2,j+2)) || 
              (isValid(i,j,i+2,j)) ||
              (isValid(i,j,i,j+2)) ||
              (isValid(i,j,i-2,j-2)) ||
              (isValid(i,j,i-2,j)) ||
              (isValid(i,j,i,j-2)) ||
              (isValid(i,j,i+2,j-2)) ||
              (isValid(i,j,i-2,j+2))){
                  return false;
              }//end if
           }//end nested for
        }//end for
          return true;
   	 }//end if 
       else {
   		 for(int i = 0; i < 5; i++) {
   		        for(int j = 0; j < 5; j++)
   		        {
   		           if((isValid(i,j,i+2,j+2)) || 
   		           (isValid(i,j,i+2,j)) ||
   		           (isValid(i,j,i,j+2)) ||
   		           (isValid(i,j,i-2,j-2)) ||
   		           (isValid(i,j,i-2,j)) ||
   		           (isValid(i,j,i,j-2)) ||
   		           (isValid(i,j,i+2,j-2)) ||
   		           (isValid(i,j,i-2,j+2))){
   		               return false;
   		           }//end if
   		        }//end nested for
   		    }//end for
   		    return true;
         }//end else
      }//end isDone
   public int numPegs() {
	   int k = 0;
	   if (type== BoardType.ENGLISH) {
		   for(int i = 0; i < 7; i++) {
			   for (int j = 0; j < 7; j++) {
				   if (board[i][j] == Hole.FILLED) {
					   k = k+ 1;
				   }
			   }
		   }
	   } else {
			   for(int i = 0; i < 5; i++) {
				   for (int j = 0; j < 5; j++) {
					   if (board[i][j] == Hole.FILLED) {
						   k = k+ 1;
					   }
				   }
			   }
		   }
	   return k;
   }
   public boolean winner() {
	   if (numPegs() == 1) { 
		   return true;
	   } else {
		   return false;
	   }
   }

public String toString() {

String ret = "";
if (type == BoardType.TRIANGLE) {
	for (int j = 0; j < 5; j++) { // each row
    for(int k = j; k < 4; k++)
    	ret+=" ";		
    for(int i = 0; i <= j; i++) {
      if (board[j][i] == Hole.FILLED) {
		  	ret+= "* ";}
		  else if (board[j][i] == Hole.EMPTY) {
		  	ret+= "o ";}
		  
    }
   	
   	ret  += "\n";
    
    }
	 }
	 
	 
	else {
	
		for (int i = 0; i < 7; i++) {
	    for (int j = 0; j < 7; j++) {
	        if (board[i][j] == Hole.FILLED) 
			  		ret+= "* ";
			  	else if (board[i][j] == Hole.EMPTY )
			  		ret+= "o ";
			 		else 
			 			ret+= "  ";
	
	    }
			ret += "\n";
		}
	}
return ret;
}
   
}//end class