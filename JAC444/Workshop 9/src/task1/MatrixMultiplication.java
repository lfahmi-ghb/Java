package task1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMultiplication {
	
	private static final int THREADS_TOTAL = 4;
	private static final int SIZE = 2000;

	
    private static double[][] getMatrix (int numRows, int numCols) {
        double matrix[][] = new double[numRows][numCols];
        for (int row = 0 ; row < numRows ; row++ ) {
            for (int col = 0 ; col < numCols ; col++ ) {
                matrix[row][col] = (double) ((int) (Math.random() * 10.0));
            }
        }
        
        for (int i = 0 ; i < numRows ; i++ ) {
            for (int j = 0 ; j < numCols ; j++ ) {
            	  System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
       
        return matrix;
    }
    
    
    public static void main(String[] args) {

		double[][] a = getMatrix(SIZE, SIZE);
		double[][] b = getMatrix(SIZE, SIZE);
		

		measureTime(a, b);
	}
	

    public static void measureTime(double[][] a, double[][] b){

        long seqCurrentTime = System.currentTimeMillis();        
        long parCurrentTime = System.currentTimeMillis();
        
        
        sequentialMultiplyMatrix(a, b);
		long seqTotTime = System.currentTimeMillis()- seqCurrentTime;
		System.out.println("The execution time for mulitplying the matices sequentially is: " + seqTotTime/60000 + " mins");
		
	    System.out.println("Parallel multiplication processing....");   		
		parallelMultiplyMatrix(a, b);			
		long parTotTime = System.currentTimeMillis() - parCurrentTime;
		System.out.println("The calculated time of all the parallel threads is: " + parTotTime/60000 + " mins");
		
    }
    
    
    /* implement the following method in parallel. */
    public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b) {
		double[][] result = new double[a.length][a[0].length];
			ExecutorService ex = Executors.newFixedThreadPool(THREADS_TOTAL);
			for(int rows = 0; rows < a.length; rows++) {
				for(int col = 0; col < a[0].length; col++) {
					ex.execute(new MultiplyMatrcies(a, b, rows, col, result));
				}
			}
			ex.shutdown();
			
			while(!ex.isTerminated()) {
				
			}		
		return result;
	}

    
    /*  Second must implemented method should be a normal sequential process  */
    
	public static double[][] sequentialMultiplyMatrix(double[][] a, double[][] b) {
		double[][] result = new double[a.length][a[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				for(int k = 0; k < a[0].length; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return result;
	}
	


	static class MultiplyMatrcies implements Runnable {
				
		private double[][] a;
		private double[][] b;
		private int col;
		private int row;
		private double[][] result;
	
		MultiplyMatrcies(final double[][] a, final double[][] b, final int col, final int row, final double[][] result) {
		  this.col = col;
		  this.row = row;
		  this.a = a;
		  this.b = b;
		  this.result = result;
		}
		
	
		public void run() {
			for (int i = 0; i < a[0].length; i++) {
				result[col][row] += a[col][i] * b[i][row];
		  	}
		}
		
		
	}



	
}
