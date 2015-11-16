package hw3;

import static org.junit.Assert.*;
import hw3.StackChecker;
import org.junit.Before;
import org.junit.Test;

public class StackCheckerTest {
Boolean [] works;
Boolean [] fails;
Boolean [] fail2;
	@Before
	public void init(){
		fail2 = new Boolean[1];
		works = new Boolean[100];
		fails = new Boolean[100];
		for(int i = 0; i < 100; i++){
			
			if(i<50){
				works[i]= true;
			}else{
				works[i]= false;
			}
			if(i%4 == 0){
				fails[i] = true;
				
			}else{
				fails[i] = false;
			}
		}
	}
	
	@Test
	public void stackCheckerTest0() {
		assertEquals(true, StackChecker.stackChecker(works) );
		//assertEquals(false, StackChecker.stackChecker(fails));
		//assertEquals(false, StackChecker.stackChecker(fail2));
	}
	@Test
	public void stackCheckerTest1() {
		//assertEquals(true, StackChecker.stackChecker(works) );
		assertEquals(false, StackChecker.stackChecker(fails));
		//assertEquals(false, StackChecker.stackChecker(fail2));
	}
	@Test
	public void stackCheckerTest2() {
		//assertEquals(true, StackChecker.stackChecker(works) );
//		assertEquals(false, StackChecker.stackChecker(fails));
		assertEquals(false, StackChecker.stackChecker(fail2));
	}

}
