class SavingsAccount extends Account {
	 private double interestRate;
	 private double intrest;
	 
		public SavingsAccount(double balance, double rt) {
			super(balance);
			interestRate = rt;	
		}
		
		public double CalculateInterest() {      //tested and it works
			System.out.println("The balance is " + getM_balance());
			intrest = (getM_balance() * interestRate) / 100;
			setM_balance(getM_balance() + intrest);
			return intrest;
		}
}
