
public class CommissionEmployee extends Employee{
	
	private double grossSales;
	private double commissionRate;
	

	  /****** Constructor *******/	
CommissionEmployee(String f, String l, String snn, double gs, double cr) {
		super(f, l, snn);
		setGrossSales(gs);
		setComRate(cr);
		
	}

	   /****** Getters *******/
public double getComRate() { return commissionRate; } 
public double getGrossSales() { return grossSales; } 
	
	

	   /****** Setters *******/
public void setGrossSales(double gs) { 
	if(gs >= 0.0)
		grossSales = gs;
		
	else {
	    throw new ArithmeticException("Gross sale should be greater than 0");
		}		
	};	
	
	

public void setComRate(double cr) {
		if (cr > 0.0 && cr < 1.0)
		commissionRate = cr;
		else {
			 throw new ArithmeticException("Commission rate should be greater than 0 OWO");
		}
	};	
	
	
	
	   /****** Public Methods *******/
@Override
public double getPaymentAmount() {
	return getGrossSales() * getComRate();
} 
	
	
@Override
public String toString() {
	return String.format("%s Commission: {Gross: $%,.2f; Commission Rate: %.2f }", super.toString(), getGrossSales(), getComRate());
} 
}
