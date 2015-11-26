import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeparateChainHashSTTest {
	SeparateChainHashST<Integer, Integer> hash;
	@Before
	public void setUp() throws Exception {
		hash = new SeparateChainHashST<Integer, Integer>(2);
	}

	@Test
	public void testPut() {
		hash.put(0, 10);
		hash.put(1, 20);
		SequentialSearchST<Integer, Integer> st = (SequentialSearchST<Integer, Integer>) hash.hashTable[0];
		assertEquals(0, (int)st.first.key);
		assertEquals(10, (int)st.first.value);
		st = (SequentialSearchST<Integer, Integer>) hash.hashTable[1];
		assertEquals(1, (int)st.first.key);
		assertEquals(20, (int)st.first.value);
		hash.put(1, 40);
		assertEquals(1, (int)st.first.key);
		assertEquals(40, (int)st.first.value);
	}

	@Test
	public void testGet() {
		hash.put(0, 10);
		hash.put(1, 20);
		assertEquals((int)hash.get(0), 10);
		hash.put(0,  20);
		assertEquals((int)hash.get(0), 20);
		hash.put(2, 55);
		assertEquals((int)hash.get(2), 55);
	}

	@Test
	public void testDelete() {
		hash.put(0, 10);
		hash.put(1, 20);
		assertEquals((int)hash.get(0), 10);
		hash.delete(0);
		assertEquals(hash.get(0), null);
	}

	@Test
	public void testContains() {
		hash.put(0, 10);
		hash.put(1, 20);
		hash.put(6, 30);
		hash.put(5, 40);
		assertTrue(hash.contains(5));
		assertFalse(hash.contains(9));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(hash.isEmpty());
		hash.put(1, 20);
		assertFalse(hash.isEmpty());
		hash.delete(1);
		assertTrue(hash.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, hash.size());
		hash.put(0, 10);
		assertEquals(1, hash.size());
		hash.put(1, 20);
		assertEquals(2, hash.size());
		hash.put(6, 30);
		assertEquals(3, hash.size());
		hash.put(5, 40);
		assertEquals(4, hash.size());
		hash.delete(1);
		assertEquals(3, hash.size());
	}

	@Test
	public void testKeys() {
		hash.put(0, 10);
		hash.put(1, 20);
		hash.put(6, 30);
		hash.put(5, 40);
		int [] keys = new int [] {0 , 1, 6 , 5};
		for(int i : hash.keys()){
			boolean b = false;
			for(int j =0; j< keys.length; j++){
				if(i == keys[j]){
					b = true;
				}
			}
			assertTrue(b);
		}
	}
	
	@Test
	public void keys2(){
		hash.put(0, 10);
		hash.put(1, 20);
		hash.put(2, 30);
		hash.put(3, 40);
		hash.put(4, 10);//
		hash.put(5, 20);//
		hash.put(6, 30);//
		hash.put(7, 40);//
		hash.put(8, 10);//
		hash.put(9, 20);//
		hash.put(10, 30);//
		hash.put(11, 40);//
		hash.put(12, 10);//
		hash.put(13, 20);//
		hash.put(14, 30);//
		hash.put(15, 40);//
		System.out.println("size = " +hash.size());
		int count = 0;
		for(int i : hash.keys()){
			System.out.println(i);
			count++;
		}
		System.out.println("key count = " + count);
	}

}
