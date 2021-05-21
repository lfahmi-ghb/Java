
public class SalariedEmployee  extends Employee{
double weeklysalary;


/****** Getters *******/
	public double getWeeklySalary()  { return weeklysalary; }

	
/****** Setters *******/
	public void setWeeklySalary(double ws) { 
		if (ws >= 0.0)
			weeklysalary = ws;
		else {
			 throw new ArithmeticException("Weekly salary should be greater than 0");
		}
	}

	
/****** Constructor *******/	
	SalariedEmployee(String f, String l, String snn, double ws) {
		super(f, l, snn);
		setWeeklySalary(ws);
	}
	
	
	
	
/****** Public Methods *******/	
	@Override
	public double getPaymentAmount() {
		return weeklysalary;
	} 
	@Override
	public String toString() {
		return String.format("%s Weekly Salaried Employee: {Weekly: $%,.2f}", super.toString(),  getWeeklySalary());
	}


}
