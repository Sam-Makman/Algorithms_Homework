package lab2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JavaSortedPagerTest {
	JavaSortedPager<Integer> pager;
	Integer[] obj;
	@Before
	public void setUp() throws Exception {
	obj = new Integer[101];
		for(int i = 0;i< obj.length; i++){
			obj[i] = new Integer((int)(Math.random()* Integer.MAX_VALUE));
		}
		pager = new JavaSortedPager<Integer>(obj, 10);
	}

	@Test
	public void ConstructorErrorTest() {
		boolean thrown = false;
		try{
			new JavaSortedPager(obj,0);
		}catch(IllegalArgumentException e){
			thrown = true;
		}
		assertTrue(thrown);
		thrown=false;
		try{
			new JavaSortedPager(null, 100);
		}catch(IllegalArgumentException e){
			thrown =true;
		}
		assertTrue(thrown);
		thrown=false;
		try{
			Integer [] a = new Integer[0];
			new JavaSortedPager(a, 100);
		}catch(IllegalArgumentException e){
			thrown =true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void getTest(){
		Integer a = pager.get(20);

		assertEquals(a, obj[20]);
	}//finish test
	
	@Test
	public void maxTest(){
		assertEquals(obj[obj.length-1], pager.max());
	}
	
	@Test
	public void minTest(){
		assertEquals(obj[0], pager.min());
	}

	@Test
	public void sizeTest(){
		assertEquals(obj.length, pager.size());
	}
	
	@Test
	public void pageSizeTest(){
		assertEquals(10, pager.pageSize());
	}
	
	@Test 
	public void pagesTest(){
		assertEquals(11,pager.pages());
	}
	
	@Test
	public void page(){
		Integer [] a = new Integer[10];
		for(int i = 0; i<10;i++){
			a[i] = obj[i + 20];
		}
		assertArrayEquals(a, pager.page(2));
		
	}
	
}	
	
