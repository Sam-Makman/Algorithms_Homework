package hw3;

import java.util.Arrays;
import org.apache.commons.lang3.time.StopWatch;



public class copyEx  {

	
	
public static void main(String [] args){	
	
	copyEx.test();
}
	
	/**
	 * 
	 * @param number of Items in array
	 * @param Array Pointer
	 * 
	 * this creates a new array of random ints
	 */
	public static void setUpI(int n, int[] experiment){
		experiment = new int[n];
		for(int i = 0; i<n; i++){
			experiment[i] = (int) (Math.random() * (2147483647 - (-2147483647))  - 2147483647);
		}
	}
	
	/**
	 * this copies the array "experiment" using copyOf and arrayCopy then prints out the time taken
	 * test runs until stopped or OutOfMemoryError 
	 */
	public static void test(){
		
	for(int i = 1;true;i = i * 2){
		int[] experiment = new int[i]; 
		setUpI(i, experiment);
		int[] acopy  = new int[i];
		int[] cOf;
		StopWatch stop1 = new StopWatch();
		StopWatch stop2 = new StopWatch();
		
		stop1.start();
		System.arraycopy(experiment, 0, acopy, 0, i);
		stop1.stop();
		
		//uncomment next line to create a new array of random ints to avoid using values already cashed in memory.
		setUpI(i, experiment);
		
		
		stop2.start();
		cOf = Arrays.copyOf(experiment, i);
		stop2.stop();
		System.out.println("copyOf: " + stop2.getTime()  + " Array Copy: "+ stop1.getTime()+ " with " + i + "values");	
	}	
	}
}
