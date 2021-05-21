import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LetterCounter {

	
	/***  open file ***/
	public static void openFile(String filename) {
		try {
			@SuppressWarnings("unused")
			Scanner	input = new Scanner(new File(filename));
		
		}
		catch(IOException e) {
			System.out.println("Error");
		}
	}
	
	
	
	public static void main (String [] args) throws IOException {
		
		System.out.println("Letter Counter (Task #2)");	
		System.out.print("Enter the name of the file: ");
		/***read the file***/		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);		
		File file = new File(input.next());
		 if (!file.exists()) {
			 throw new FileNotFoundException ("File "+ file +" does not exist");
		 }
		
		
		 /***read the text***/
		BufferedReader text = new BufferedReader(new FileReader(file));
		try(text){
		/***count the letters***/    
		    int buf;
		    char[] letters = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		    int [] counter = new int[letters.length];
		    while((buf = text.read()) > -1) {  //while there's still text to read, count the occurrences
		    	for(int i=0; i < letters.length; i++) {
		    		if(letters[i] == (char)buf) { // if the letter at index [i] is equal to the character from the text, the count up.
		    			counter[i]++;
		    		}
		        }
		    	
		    };

		    
			 /***print the occurrences***/	    
	        for (int i = 0; i < letters.length; i++){
	            System.out.println(letters[i] + " occurrence # is = " + counter[i]);
	        }		    
			
		}
		 text.close();
	}
}
