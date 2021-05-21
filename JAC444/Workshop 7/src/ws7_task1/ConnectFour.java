package ws7_task1;
import java.util.Scanner;

import java.util.Arrays;


public class ConnectFour {
    
    
		private static char[][] makeBoard() {
			char[][] board = new char[6][7];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

		private static void printBoard(char[][] board) {
			for (char[] column : board) {
				System.out.print("|");
				for (char space : column) {
					System.out.print(space + "|");
            }
            System.out.print("\n");
        }
        System.out.print("\n---------------\n");
    }

    


	    private static void playTheGame() {
	    	
	        char[][] board = makeBoard();
	        
	        char diskColour = 0 ;
	        
	        while (continuePlaying(board)) {
	        	
	            
	            printBoard(board);
	            int pos = 0;
		        boolean fullColumn = false;
		        while (!fullColumn) {
		        	Scanner input = new Scanner(System.in);

		            if (diskColour  == 'Y') {
		            	diskColour  = 'R';
		            	  System.out.print("Drop a red disk at column (0–6): ");
		            }	            	
		            else {
		            	diskColour = 'Y';
		            	  System.out.print("Drop a yellow disk at column (0–6): ");
		            }
		 	      
		 	       	pos =  input.nextInt();
		            if (board[0][pos] == ' ') {
		            	fullColumn = true;
		            	}
		            else System.out.println("Drop the disk at another column that is not full.");
		        }
		        
		        // if the column has an empty spot, then full it with the disk color
		        for (int i = board.length - 1; i >= 0 ; i--) {
		            if (board[i][pos] == ' ') {
		                board[i][pos] = diskColour;
		                break;
		            }
		        }
	        }
	        
	        // after taking the input, and validating the disk's color, print out the board
	        printBoard(board);
	        	        	        
	        
	        if (checkHorizontal(board) || checkVertical(board)||checkDiagonal1(board) ||checkDiagonal2(board)) {
	        	
	            if (diskColour  == 'Y') {
	            	  System.out.print("The yellow player won!");	            	 
	            }	            	
	            else {	            	
	            	 System.out.print("The red player won!");
	            }
	        } 	        	
	        else {
	        	System.out.println("It's a draw");
	        }

	    }

	    



	    private static boolean continuePlaying(char[][] board) {
	        if (checkHorizontal(board) || checkVertical(board)||checkDiagonal1(board) ||checkDiagonal2(board)) 
	        	return false;
	        for (int i = 0; i < board[0].length; i++) {
	             if (board[0][i] == ' ') 
	            	
	            	 return true;
	        }
	        return false;
	    }


	    
	    
	    
	    //*************  check for the winner ************//
	    
	    
	    /*****  check horizontally *****/
	    public static boolean checkHorizontal (char[][] disks) {
	        boolean check = false;
	      
	        for (int i = 0; i < disks.length; i++) {
	        	
	            for (int j = 0; j < disks[i].length - 3; j++) {
	            	
	                if (disks[i][j] == ' ')                	
	                	continue;
	                	check = true;
	                for (int k = 1; k < 4; k++) {
	                	
	                	check = disks[i][j] == disks[i][j+k];
	                }
	                if (check) {
	                	
	                	return true;
	                }
	            }
	        }
	        return check;
	    }
	    
	    
	    /*****  check vertically *****/
	    public static boolean checkVertical (char[][] disks) {
	        boolean check = false;
	      
	        for (int i = 0; i < disks.length - 3; i++) {
	        	
	            for (int j = 0; j < disks[i].length; j++) {
	            	
	                if (disks[i][j] == ' ')  
	                	
	                	continue;
	                	check = true;
	                	
	                for (int k = 1; k < 4; k++) {
	                	
	                	check =  disks[i][j] == disks[i+k][j];
	                	
	                }
	                if (check) {
	                	
	                	return true;
	                }
	                
	            }
	        }
	        
	        return  check;
	    }
	    
	    /*****  check diagonally *****/
	    
	    public static boolean checkDiagonal1 (char[][] disks) {
	        boolean check = false;
	        
	        for (int i = 0; i < disks.length - 3; i++) {
	        	
	            for (int j = 0; j <disks[i].length - 3; j++) {
	            	
	                if (disks[i][j] == ' ') 
	                	
	                	continue;
	                	check = true;
	                	
	                for (int k = 1; k < 4; k++) {
	                	
	                	check =   disks[i][j] == disks[i+k][j+k];
	                	
	                }
	                if (check) {
	                	return  check = false;
	                }
	            }
	        }
	        
	        return check;
	    }
	    
	    public static boolean checkDiagonal2 (char[][] disks) {
	        boolean check = false;
	      
	        for (int i = 4; i < disks.length; i++) {
	        	
	            for (int j = 0; j < disks[i].length - 3; j++) {
	            	
	                if (disks[i][j] == ' ') 
	                	
	                	continue;
	                	check = true;
	                	                
	                for (int x = 1; x < 4; x++) {
	                
	                	check =  disks[i][j] == disks[i-x][j+x];
	                
	                }
	                if (check) {
	                	return true;
	                }
	            }
	        }
	        return  check;
	    }
	    
	    
	    
	    /**** MAIN METHOD ****/
	    
		   public static void main(String[] args) {
			   System.out.printf("Name: Lara Fahmi\n");
			   System.out.printf("********Task 1*********\n\n");
			   playTheGame();
		    }
	    
}
