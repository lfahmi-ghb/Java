

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Set;

public class  Testing  {

	  public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	 
	        DecimalFormat df = new DecimalFormat("#.00");	     
	 //create an array of Account references to SavingsAccount and CheckingAccount objects
	        Account[] acntArr = new Account[4];
	        
	
	        acntArr[0] = new SavingsAccount(1000, 0.50); 
	        acntArr[1] = new CheckingAccount(10000, 3.75);
	        acntArr[2] = new CheckingAccount(10000, 5.00);
	        acntArr[3] = new SavingsAccount(2000, 0.97);
	  
	        		
	        System.out.println("Name: Lara Fahmi\n");
	        for (int i = 0 ;  i < 4; i++) {
	  //process each Account, determine its type
	        	
	        	
	           //////****IF IT'S SAVINGS ACCOUNT****////////
	        	
		        if (acntArr[i] instanceof SavingsAccount) {	
		        	 System.out.println("Savings Account #"+ i +" balance $" + (df.format(acntArr[i].getM_balance())));
		        	
		        	//1) allow the user to specify an amount of money to withdraw
		        	 System.out.print("Withdrawal amount from Account #"+ i +" : ");
		        	 double  amount = input.nextDouble();
		        	 acntArr[i].debit(amount);
	              
		          //2)  an amount of money to deposit into the Account using method Credit      
		        	 System.out.print("Enter deposit amount into Account #"+ i +" :");
		        	 amount = input.nextDouble();
		        	 acntArr[i].credit(amount);
		        	
		        	
		         // If an Account is a SavingsAccount, calculate the amount of interest owed	
	           	    amount = ((SavingsAccount) acntArr[i]).CalculateInterest();
	                System.out.print("An intrest of $" + (df.format(amount)) + " will be added " + "\n");
	                System.out.print("The updated Savings Account #"+ i +" balance is: $" + (df.format(acntArr[i].getM_balance())) + "\n\n");
	        }
		        
		        
		        //////****IF IT'S CHECKING ACCOUNT****////////
	        else {

	        	
	                System.out.println("Checking account #"+ i +" balance $" + (df.format(acntArr[i].getM_balance())));	       	 
	            
	            
	           //1) allow the user to specify an amount of money to withdraw	  
	 	           System.out.print("Enter withdrawal amount from Account #"+ i +" : ");
	 	           double enteredAmount= input.nextDouble();
	 	          acntArr[i].debit(enteredAmount);
	 	        
	 	        
	        	//2)  an amount of money to deposit into the Account using method Credit      
	 	           System.out.print("Enter deposit amount into Account #"+ i +" :");
	 	           enteredAmount = input.nextDouble();
	 	           acntArr[i].credit(enteredAmount);
	 	        
	 	         

	 	          System.out.print("The updated Checking Account #"+ i +" balance is: $" + (df.format(acntArr[i].getM_balance())) + "\n\n");
	        }
	     
	                             	 	
	        }
	 
	    }
}