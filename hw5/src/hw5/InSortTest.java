package hw5;

import static org.junit.Assert.*;

import org.junit.Test;

public class InSortTest {

	@Test
	public void InSortTests() {
		int [] a = new int[]{0,9,8,7,6,5,4,3,2,1};
		int [] b = new int[]{0,1,2,3,4,5,6,7,8,9};
		InSort.sort(a);
		assertArrayEquals(a,b);	
	}
	
	@Test
	public void InSortCTest() {
		Comparable [] a = new Comparable[]{new Integer(0),new Integer(1),new Integer(2)
				,new Integer(3),new Integer(4),new Integer(5),new Integer(6),new Integer(7)
				,new Integer(8),new Integer(9)};
		Comparable [] b = new Comparable[]{new Integer(0),new Integer(9),new Integer(8)
				,new Integer(7),new Integer(6),new Integer(5),new Integer(4),new Integer(3)
				,new Integer(2),new Integer(1)};
		InSort.sortC(b);
		assertArrayEquals(a,b);	
	}

}
