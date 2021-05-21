package ws6_task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Processor implements ArrayProcessor{

	static Scanner input =  new Scanner(System.in);
	
	/************ counter ***************/
	public static ArrayProcessor counter (double value) {
		return elements -> {
			int counter = 0;
			for (int i = 0; i < elements.length; i++)
				if (value == elements[i]) { counter++; }		
			return counter;
		};
	}
	
	
	
	/************ methods ***************/
	
	public static final ArrayProcessor max = values -> {
		double max = values[0];
		for (int i =0 ; i < values.length; i++)
			if (max < values[i])
				max = values[i];
		return max;
	};
	
	public static final ArrayProcessor min = values -> {
		double min = values [0];
		for (int i=0 ; i< values.length;i++)
			if (min > values[i])
				min = values[i];
		return min;
	};
	
	public static final ArrayProcessor sum = values -> {
		double sum = 0;
		for (int i=0;i< values.length;i++)
			sum += values[i];
		return sum;
	};
	
	public static final ArrayProcessor avg = values ->{
		return sum.apply(values)/values.length;
	};
	
	

	

	/************ main ***************/
	
	public static void main(String[] args) {
		System.out.print("Enter the number of the elements for the array: ");
		int count = input.nextInt();
		
		double[] array = new double[count];
		
		System.out.print("Enter the array elements : ");
		for (int i =0 ; i< array.length; i++) {
			array[i] = input.nextDouble();
		}
	
			
			System.out.println("\n*************** Part 1: count avg, min, max, sum *******************");
			System.out.println("Maximum value in the array : "+ max.apply(array));
			System.out.println("Minimum value in an array: " + min.apply(array));
			System.out.printf("Sum of the values in the array: %,.2f" , sum.apply(array));
			System.out.printf("\nAverage of the values in the array: %,.2f", avg.apply(array));
			
			
			System.out.println("\n*************** Part 2: count occurances *******************");
			System.out.println("Choose 1 value of the array to find the occurences: ");
			double choice  = input.nextDouble();
			System.out.println(choice + " occured "+ counter(choice).apply(array)+ " time(s) in the array.");
			input.close();

	}
	@Override
	public double apply(double[] array) {
		// TODO Auto-generated method stub
		return 0;
	}

}
