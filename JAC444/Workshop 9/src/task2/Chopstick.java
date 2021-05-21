package task2;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Chopstick {
  

	private int chopstick_id;
	private Lock lock;
	
	public Chopstick(int id) {
		super();
		this.chopstick_id = id;
		this.lock = new ReentrantLock();
	}
	
	public boolean pickUpChopstick(int philosopherID) throws InterruptedException {
		/*the thread waits for a certain time period as defined by arguments of the 
 		  to acquire the lock on the resource before exiting.*/
		if(lock.tryLock(10, TimeUnit.MILLISECONDS)) {
			System.out.println("Philosopher " + philosopherID + " picked up "+ chopstick_id);
			return true;
		}
		return false; 
	}
	
	public void putDownChopstick(int philosopherID) {
		/* at this point, after eating the resource is released. we use unlock to implement that*/
		lock.unlock();
		System.out.println("Philosopher " + philosopherID + " put down "+ chopstick_id);
	}
	


}