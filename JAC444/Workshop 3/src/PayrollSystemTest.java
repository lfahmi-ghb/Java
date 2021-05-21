/**********************************************
Workshop 3
Course:JAC44 - Winter 2021
Last Name: <Fahmi>
First Name: <Lara>
ID: 109742197
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2021-02-13
**********************************************/



public class PayrollSystemTest {
	
	public static void main(String[] args) {
		
		BasePlusCommissionEmployee BaseCom = new BasePlusCommissionEmployee("Lara", "Fahmi", "123-456-789", 1000.0, 0.42, 700);
		CommissionEmployee ComEmp = new CommissionEmployee("Leia", "Skywalker", "222-222-222",  25000.0,  0.12);
		HourlyEmployee HourEmp = new HourlyEmployee ("Sarah", "Conor", "333-333-333", 45.50, 40);
		SalariedEmployee SalEmp = new SalariedEmployee("Micheal", "Scott", "444-444-444", 900.00);
		
		
		
		System.out.println("*********** First Task (Individual Printing) ****************\n");
		System.out.printf("%s\nEarned: $%,.2f\n\n", SalEmp, SalEmp.getPaymentAmount());
		System.out.printf("%s\nEarned: $%,.2f\n\n", ComEmp, ComEmp.getPaymentAmount());
		System.out.printf("%s\nEarned: $%,.2f\n\n", HourEmp, HourEmp.getPaymentAmount());
		System.out.printf("%s\nEarned: $%,.2f\n\n", BaseCom, BaseCom.getPaymentAmount());

		
		
		Employee[] emps = {SalEmp, ComEmp, HourEmp, BaseCom};
		
		
		
		

		System.out.println("*********** Task #2 (Polymorphic Printing) ****************\n");
		
		 for ( Payable currentPayable : emps ) {
			 System.out.printf( "%s \n%s: $%,.2f\n\n",
					 currentPayable.toString(),
					 "Earned", currentPayable.getPaymentAmount() );
		 } 
		 
		 
		 
			System.out.println("*********** Task #3 (Printing Object Types) ****************\n");
		for (int i = 0; i < emps.length; i++)
			System.out.printf("Employee %d belongs to %s\n", i+1, emps[i].getClass()); 
	}
}

