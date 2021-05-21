
public class BasePlusCommissionEmployee extends CommissionEmployee{


	private double baseSalary;
	
/****** Setters *******/	
	public void setBaseSalary(double bs){ baseSalary = bs; }
	

/****** Getters *******/
	public double getBaseSalary() { return baseSalary;}
	


/****** Constructor *******/	
	BasePlusCommissionEmployee(String f, String l, String snn, double gs, double cr, double bs) {
		super(f, l, snn, gs, cr);
		// TODO Auto-generated constructor stub
		baseSalary = bs;
	}

	
	
/****** Public Methods *******/	
	@Override
	public double getPaymentAmount() {
		return (getBaseSalary()+ super.getPaymentAmount()) * 0.1;
	}

	@Override
	public String toString() {
		return String.format("%s\nBase Salary:{$%,.2f}", super.toString(), getBaseSalary());
	}
}
