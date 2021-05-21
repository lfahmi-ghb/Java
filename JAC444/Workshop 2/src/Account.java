import java.util. * ;
class Account {
	
	 private double m_balance;

	 
	    public Account(double balance){	 
	    	if (balance >= 0.0)
	    		setM_balance(balance);
	    	else {
	    		 balance = 0.0;
	    		 System.err.println("Balance was not initialized");
	    	}
	       
	    }
	    
       public Account() {
			// TODO Auto-generated constructor stub
		}

		public void credit(double amount){
           this.setM_balance(this.getM_balance() + amount);
       }
       
       public void debit(double amount){
       	if (amount > this.getM_balance()) {
       		System.out.println("Debit amount exceeds account balance.");
       	}
       	else
       		this.setM_balance(this.getM_balance() - amount);
       }
       

       


	public double getM_balance() {
		return m_balance;
	}

	public void setM_balance(double m_balance) {
		this.m_balance = m_balance;
	}

}
