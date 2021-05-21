package task2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Capitals {
	
	static Scanner input = new Scanner(System.in);
	final static Map<String,String>  hashMap = new HashMap<>();
	
	public static void start() {
		
		
		hashMap.put("Canada","Ottawa");
		hashMap.put("Brazil","Brasilia");
		hashMap.put("USA","Washingtion D.C");
		hashMap.put("Japan","Tokyo");
		hashMap.put("China","Bejing");
		hashMap.put("Englad", "London");
		hashMap.put("France", "Paris");
		hashMap.put("Iraq","Baghdad");
		hashMap.put("Korea","South: Seoul");
		hashMap.put("Mexico","Mexico City");
		hashMap.put("Russia","Moscow");
		hashMap.put("Serbia","Belgrade");
		hashMap.put("Slovakia","Bratislava");
		hashMap.put("Sweden","Stockholm");
		hashMap.put("Turkey","Ankara");
		hashMap.put("Venezuela","Caracas");
		hashMap.put("Vietnam","Hanoi");
		hashMap.put("Germany","Berlin");
		hashMap.put("Estonia","Tallinn");
		hashMap.put("Dominican Republic","Santo Domingo");
		hashMap.put("Cuba","Havana");
		hashMap.put("Algeria","Algiers");
		hashMap.put("Armenia","Yerevan");
		hashMap.put("Austria","Vienna");
		
		
		 System.out.println("***** Stored Countries *****\n");
		System.out.println("The countries stored in the map:");
		System.out.print("[");
	
		
		hashMap.forEach(
				(name, capital) -> System.out.print(name + ", "));
		System.out.print("]");
		
		
		System.out.println("\n\n***** Search Capitals *****");
		displayCapital();

		}
	
	
	 public static void displayCapital(){
		 boolean flag = false;
			while (!flag ) {
			
				System.out.print("Enter one country name from the list: ");
				String country = input.next();

				
			for (String name: hashMap.keySet()) {
				if (country.equals(name)) {
					System.out.println("The capital of " + country + " is " + hashMap.get(country));
					flag = true;
			
					searchAnotherCapital() ;
				}
				
			}
			if (!flag) 
				System.out.println("[ "+ country + " ] is not in the countries' list, please choose one of the countries in the list\n\n");
	
			
			}

	 }
	 
	 
	  public static void searchAnotherCapital() {
		  System.out.print("\n***** Search for Another *****");
		  System.out.print("\nDo you want to search for another capital? Enter y/n > ");
	        Scanner input = new Scanner(System.in);
	        String answer = input.next();
	        if (answer.contains("y") || answer.contains("Y")) {		   
	        	displayCapital();	         
	        }
	
	        if (answer.contains("n") || answer.contains("N")) {		   
	        	  System.out.println("Exiting...");
	              System.exit(0);         
	        }
	        
	  }

	
	public static void main(String[] args) {
		
		start();
	}
}
