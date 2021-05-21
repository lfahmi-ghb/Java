package ws7_task2;

// no-arg constructor
// constructor
// getArea()
// getPerimeter()
// contains(double x, double y)
// contains(Circle2D circle) 
// overlaps(Circle2D circle)


public class Circle2D {

	private double x; 
	private double y; 
	private double radius;
	
	/*** getter methods ***/
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	
	public double getRadius() {
		return radius;
	}
	
	
	/*** constructors ***/	
	
	public Circle2D() {
		this(0, 0, 1);
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	
	/*** public methods ***/
	
	
	public double getArea() {
		
		return Math.PI * Math.pow(radius, 2);
		
	}
	
	
	
	public double getPerimeter() {
		
		double area = 2 * Math.PI * radius;
		
		return area;
		
	}
	
	
	
	public boolean contains(double x, double y) {
		
		return Math.sqrt((x - this.x * x - this.x ) +  (y - this.y * y - this.y )) 
				 <= this.radius;
		
	}
	
	
	
	public boolean contains(Circle2D circle) {
		
		return (Math.sqrt(((x - circle.getX()) * (x - circle.getX() ))+ ((y - circle.getY()) * (y - circle.getY()))) + circle.getRadius())
				 <=(this.radius);
		
	}
	
	
	
	public boolean overlaps(Circle2D circle) {
		
		return Math.sqrt((circle.getX() - x) * (circle.getX() - x) + (circle.getY() - y * circle.getY() - y))  + circle.getRadius()
		<= this.radius;
		
	}
	
	
	
	/*** main method ***/
	public static void main(String[] args) {
		
		  Circle2D c1 = new Circle2D(2, 2, 5.5);
		  
		  System.out.printf("Name: Lara Fahmi\n");
		  System.out.printf("********Task 2*********\n\n");
		  System.out.printf("Output for the Area calculation is:  %,.2f\n", c1.getArea());
	      
		  System.out.printf("\nOutput for the Perimeter calculation is %,.2f\n\n" , c1.getPerimeter());
	      
	      System.out.println("Output for c1.contains(3,3):  " + c1.contains(3, 3));
	      
	      System.out.println("\nOutput for c1.contains(new Circle2D(4, 5, 10.5)): " + c1.contains(new Circle2D(4, 5, 10.5)));
	      
	      System.out.println("\nOutput for c1.overlaps(new Circle2D(3, 5, 2.3)): " + c1.overlaps(new Circle2D(3, 5, 2.3)));
	      
	   }
	
}
