import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SequentialSearchSTTest {
	SequentialSearchST<Integer, Integer> hTable;
	@Before
	public void setUp() throws Exception {
		hTable = new SequentialSearchST<Integer, Integer>();
	}

	@Test
	public void testPut() {
		hTable.put(0, 100);
		int i = hTable.first.key;
		assertEquals(i, 0);
		i = hTable.first.value;
		assertEquals(i, 100);
		hTable.put(1, 50);
		i = hTable.first.key;
		assertEquals(i, 1);
		i = hTable.first.value;
		assertEquals(i, 50);
		hTable.put(1, 2);
		i = hTable.first.key;
		assertEquals(i, 1);
		i = hTable.first.value;
		assertEquals(i, 2);
		
	}

	@Test
	public void testGet() {
		hTable.put(0, 100);
		hTable.put(3, 75);
		assertEquals(100, (int) hTable.get(0));
		assertEquals(75, (int) hTable.get(3));
		assertEquals(null,  hTable.get(100));
	
	}

	@Test
	public void testDelete() {
		hTable.put(0, 100);
		hTable.put(3, 75);
		hTable.put(2, 30);
		hTable.put(8, 75);
		hTable.delete(2);
		assertEquals(null,  hTable.get(2));
	}

	@Test
	public void testContains() {
		hTable.put(0, 100);
		hTable.put(3, 75);
		hTable.put(2, 30);
		hTable.put(8, 75);
		assertTrue(hTable.contains(8));
		assertFalse(hTable.contains(300));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(hTable.isEmpty());
		hTable.put(2, 30);
		assertFalse(hTable.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, hTable.size());
		hTable.put(0, 100);
		assertEquals(1, hTable.size());
		hTable.put(3, 75);
		assertEquals(2, hTable.size());
		hTable.put(2, 30);
		assertEquals(3, hTable.size());
		hTable.put(8, 75);
		assertEquals(4, hTable.size());
	}

	@Test
	public void testKeys() {
		hTable.put(0, 100);
		hTable.put(3, 75);
		hTable.put(2, 30);
		hTable.put(8, 75);
		int [] keys = new int []{8, 2, 3, 0};
		int count = 0;
		for(int i : hTable.keys()){
			assertEquals(i, keys[count]);
			count++;
		}
	}

}
