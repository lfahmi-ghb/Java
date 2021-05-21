
class CheckingAccount extends Account {
	double m_feeCharged;
	
	public CheckingAccount(double balance, double fee) {
		super(balance);
		m_feeCharged = fee;
	}

	public void credit(double credit) {
		super.credit(credit);
		setM_balance(getM_balance() - m_feeCharged);
	}
	
	public void debit(double debit) {
		setM_balance(getM_balance() - (debit));
	}
} 
