package hw3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	Stack<Integer> s1, s2, s3;
	
	@Before
	public void init(){
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
		s3 = new Stack<Integer>();
		
		for(int i = 0; i< 100; i++){
			s1.push(i);
			s2.push(i);
			s3.push(i + 1);
		}
	}
	@Test
	public void equals(){
		System.out.println("first test");
		assertEquals(true, s2.equals(s1));
		System.out.println("second test");
		assertEquals(false, s1.equals(s3));
	}

}
