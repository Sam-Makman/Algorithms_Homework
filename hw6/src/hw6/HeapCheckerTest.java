package hw6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeapCheckerTest {
	public int [] max, min, fails, same, mv,minv;
	@Before
	public void setUp() throws Exception {
		max = new int[100];
		min = new int[100];
		fails = new int[100];
		same = new int[100];
		mv = new int [100];
		minv = new int [100];
		for(int i = 0; i< 100; i++){
			max[i] = 100-i;
			min[i] = i;
			fails[i] = i;
			same[i] = 500;
			mv[i]= (int) Integer.MAX_VALUE;
			minv[i] = (int) Integer.MIN_VALUE;
		}
		minv[99]=0;
		fails[1] = 100;
	}

	@Test
	public void HeapCheckTest() {
		assertTrue(HeapChecker.HeapCheck(max)>0);
		assertTrue(HeapChecker.HeapCheck(min)<0);
		assertTrue(HeapChecker.HeapCheck(fails)==0);
		assertTrue(HeapChecker.HeapCheck(same)>0);
		assertTrue(HeapChecker.HeapCheck(minv) == 0);

	}

}
