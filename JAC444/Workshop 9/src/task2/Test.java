package task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = null;
		Philosopher[] philosophers = null;
		
		try {
			
			
			/** create chopsticks **/
			

			Chopstick[] chopsticks = new Chopstick[5];
			
			for(int i = 0; i < 5; i++)
				chopsticks[i] = new Chopstick(i);
				
			/** create philosophers **/
			
			philosophers = new Philosopher[5];
			
			executorService = Executors.newFixedThreadPool(5);
			for(int i = 0; i < 5; i++) {
				philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i+1) % 5]);
				
				/* New threads will be created for each waiting task and all the tasks 
				will be running concurrently*/
				
				executorService.execute(philosophers[i]);
			}
			
			
			/* the thread scheduler picks up another thread 
			and so on */
			Thread.sleep(5000);
			
			/* after each thread is picked up, set a flag on 
			   it */
			
			for(Philosopher ps : philosophers)
				ps.doneEating(true);
			
		} finally {
			 executorService.shutdown();
			 /* after the threads are done, shut the executer down,
			   then printout to see the threads are done */
			while(!executorService.isTerminated())
				Thread.sleep(1000);
			
			for (Philosopher philosopher : philosophers) {
				System.out.println("\n" + philosopher + " exits --->" );
			}
			
		}
	}
}
