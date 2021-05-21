package task2;


import java.util.Random;
public class Philosopher implements Runnable{
	
	private int philosopherID;
	private Chopstick left;
	private Chopstick right;
	private Random random;
	private volatile boolean done = false;

	
	/* constructor to initialize variables and make Philosopher objects in the main function */
	public Philosopher(int id, Chopstick left, Chopstick right) {
		super();
		this.philosopherID = id;
		this.left = left;
		this.right = right;
		this.random = new Random();
	}
	
	
	public void doneEating(boolean done) {
		this.done = done;
	}
	
	@Override
	public void run() {


			
			while(!done) {
				/* first printout the philosophers with their idle state*/
				System.out.println(this + " is idle.");
				try {
					Thread.sleep(random.nextInt(1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/* if the philosopher picks up the left and right chopstick,
				  then the philosopher is eating.
				  then make the thread sleep
				  and let the philosopher put down the chopsticks*/
				try {
					if(left.pickUpChopstick(philosopherID)) {
						
						if(right.pickUpChopstick(philosopherID)) {
							
							System.out.println(this + " is eating.");
							Thread.sleep(random.nextInt(1000));
							
							right.putDownChopstick(philosopherID);
						}
						
						left.putDownChopstick(philosopherID);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	
	}

	
	
	
	
	
	
	
	public String toString() {
		return "Philosopher "+ philosopherID;
	}


}