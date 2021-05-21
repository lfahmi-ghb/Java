import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args)throws Exception{
		java.io.File file = new java.io.File("hangman.txt");
		System.out.println("Hangman game (Task #1)");	
		HangmanGame();

	}
	

	   //**** public method to play the game (summary) ****//
	    //*1) opens the file
		//*2) reads and chooses a word randomly
	    //*3) censors it
		//*4) let's the user guess a letter
		//*4) decides if the letter is in, repeated, or not in the word
		//*5) invokes a method that would ask to add another word
	    //*6) asks the user if they wanted to play again
	
	   public static void HangmanGame() throws FileNotFoundException {
			 
				
			    char flag = 0; //works like a flag			 			 
		        String[] txtWordsArr = null;
		        String word;
		        int num_correctGuess = 0;
		        int count_missedGuess = 0;
		        char letter;
		        
		        /***check the file ***/
			   File file = new File("hangman.txt");
		        if (!file.exists()) {
		        	 throw new FileNotFoundException ("File "+ file +" does not exist");
		     }	        
		        /***scan a word in the array, when it comes to a new line, close the scanner***/
		        Scanner input = new Scanner(file);
		        while (input.hasNext()) {
		            String str = input.nextLine();
		            txtWordsArr = str.split("\n");
		     }
		        input.close();
		        
		        //** initialize the word, and its length**//
		       
		        Random rand = new Random();
		        word = txtWordsArr[rand.nextInt(txtWordsArr.length)];
		        
		     
		      //String Builder to add and print out previous guesses
		        StringBuilder guess = new StringBuilder();	    
			  
			   do {
			   
				   //** censor the word **//
				   for (int i = 0; i < (word.length()); i++) {
					   	guess.append('*');;
			 }
				   
			

			while (num_correctGuess < word.length()) {
			System.out.print("(Guess) Enter a letter in word " + guess + " > ");
			 @SuppressWarnings("resource")
			Scanner inputGuess = new Scanner(System.in);
			String s = inputGuess.nextLine();
			letter = s.charAt(0);
			
			/***cases***/
			
			/***1) if guessed letter's index isn't in the word***/
			if (word.indexOf(letter) < 0 ) {
				System.out.println("     " +letter + " is not in the word");
				count_missedGuess++;
			
			} 
			
			/***2) if guessed letter is already in the word***/
			else if (guess.toString().indexOf(letter) >= 0) {
				System.out.println("\t" + letter + " is already in the word");
			} 
			/***1) if guessed letter is ***/
			else {
				int k = word.indexOf(letter);
				while (k >= 0) {
						guess.setCharAt(k, letter);
						num_correctGuess++;
						k = word.indexOf(letter, k + 1);
			    }
			   }
			}

			
			/*** print out the results ***/
			System.out.println("The word is " + word + ". You missed " + count_missedGuess 
			+ " times");

			
			
			/*** invoke the AddWord function to add a word ***/
			AddAnotherWord();
			 
			 
			 
			/*** ask if they wanted to play again ***/
			
		        System.out.print("Do you want to play Hangman again? Enter y/n > ");
		        Scanner input2 = new Scanner(System.in);
		        String answer = input2.next();
		        if (answer.contains("y") || answer.contains("Y")) {		   
		        	HangmanGame();		         
		        }
			   } while (flag == 'y');
	   }

	   
	   
	   
	   public static void AddAnotherWord() {
	        System.out.print("Do you want to add another word? Enter y/n  > ");
	         Scanner input = new Scanner(System.in);
			 String answer = input.next();
	        if (answer.contains("y") || answer.contains("Y")) {
	        	//**if the user answers yes, scan the new word, then open the file**//
	            System.out.print("Enter a new word to be added in the memory > ");
	            String wordInput = input.next();
	          //**try opening the file, write the word on a new line, then close**//
	            try {
	                File hangman = new File("hangman.txt");
	                FileWriter fr = new FileWriter(hangman, true);
	                fr.write("\n" + wordInput);
	                fr.close();
	            } catch (IOException e) {
	                System.out.println("the word wasn't added");
	            }
	        }
	    }
	   
		}
    

