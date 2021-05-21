
public class Invoice implements Payable{
	
 private String part;
 private String description;
 private int count;
 private double price;
 
 public Invoice(String prt, String desc, int cnt, double prc) {
	 part = prt;
	 description = desc;
	 count = cnt;
	 price = prc;
 }
 
 
 /****** Getters *******/
 public String getPart() { return part; }
 public String getDescription() { return description; }
 public int getCount () { return count; }
 public double getPrice() { return price; }
 
 
 /****** Setters *******/
 
 public void setPart(String p) { part = p;}
 public void setDescription(String d) { description = d;}
 public void setCount(int c) { 
	 if ( c >= 0 )
	 count = c;
	 else
		 throw new ArithmeticException("Count should be greater than 0");
 
 }
 public void setPrice(double p) { 
	 if ( p >= 0.0 )
		 price = p;
	 else
		 throw new ArithmeticException("Price should be greater than 0");
	 }
 
 
 
 /****** Public Methods *******/
 @Override
 public String toString () {
	 return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f", "invoice", "part number", getPart(), getDescription(), "count", getCount(), "price per item", getPrice());
	 
 }
 
 
 @Override
 public double getPaymentAmount () {
	 return getCount() * getPrice();
 }
}
