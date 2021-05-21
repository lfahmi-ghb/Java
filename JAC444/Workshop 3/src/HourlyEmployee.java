
public class HourlyEmployee extends Employee{

	double wage;
	double hour;

	
	   /****** Getters *******/	
public double getHour() { return hour;} 
public double getWage() { return wage;} 
	
	
	   /****** Setters *******/
public void setWage(double w) { 
	if (w >= 0.0)  wage = w;
	else {
		throw new ArithmeticException("Wage should be greater than 0");
		}	
	}
public void setHour(double h) { 
	if (h >= 0.0 && h <= 168)
			hour = h;
		else {
			 throw new ArithmeticException("Hours should be greater than 0");
		}	
	}
	


  /****** Constructor *******/	
	HourlyEmployee(String f, String l, String snn, double w, double h) {
		super(f, l, snn);
		setWage(w);
		setHour(h);
	}
	
	

 /****** Public Methods *******/
	@Override
	public double getPaymentAmount() {
		return getHour() * getWage();
	}
	
	@Override
	public String toString() {
		return String.format("%s Hourly Employee{ Hourly wage: $%,.2f; Total Hours: %,.2f}", super.toString(),  getWage(),  getHour());
	} 

}
