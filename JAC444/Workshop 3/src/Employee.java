
public abstract class Employee implements Payable {
private String first;
private String last;
private String SNN;

   /****** Getters *******/

String getFirstName(){ return first; };
String getLastName(){ return last; }
String getSNN(){ return SNN; }

  /****** Setters *******/
public void setFirstName(String f) { first = f;};
public void setLastName(String l) { last = l;};
public void setSNN(String snn) { SNN = snn;};



  /****** Constructor *******/
Employee(String f, String l, String snn){
	first = f;
	last = l;
	SNN = snn;
 }


  /****** Public Methods *******/
public String toString () {
	return String.format( "Employee: %s %s; SSN: %s", first, last, SNN);
	 
 }

}
