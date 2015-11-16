package hw5;

import org.apache.commons.lang3.time.StopWatch;

public class SortEx {
	private static Integer  [] compA;
	private static int [] intA; 
	public static void main(String[] args) {
		for(int i=1;; i*=2){
			init(i);
			System.out.println("N : " + i);
			StopWatch s = new StopWatch();
			s.start();
			InSort.sort(intA);
			s.stop();
			System.out.println("Primitive array "+ s.getTime());
			s.reset();
			s.start();
			InSort.sortC(compA);
			s.stop();
			System.out.println("Comparable Array " + s.getTime());
		}

	}

	
	public static void init(int n){
		compA = new Integer[n]; 
		intA = new int[n];
		for(int i = 0; i<n; i++){
			compA[i] = new Integer(n-i);
			intA[i] = n-i;
		}
	}
}
