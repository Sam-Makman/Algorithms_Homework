import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DedupeTest {
	SeparateChainHashST<Integer, Integer> hashTable;
	@Before
	public void setUp() throws Exception {
		hashTable = new SeparateChainHashST<Integer, Integer>(3);
	}

	

	@Test
	public void testGeneratePostsWithDupes() throws CloneNotSupportedException {
		Post [] p = Dedupe.generatePostsWithDupes(4, .5);
		assertTrue(p[0].equals(p[2]));
		assertTrue(p[1].equals(p[3]));
	}



	@Test
	public void testGeneratePosts() {
		Post [] p = Dedupe.generatePosts(20);
		assertEquals(20 , p.length);
		boolean dup = true;
		for(int i = 0; i < 20; i++){
			for(int j = i+1; j < 20 ; j++){
				if(p[i].equals(p[j])){
					dup = false;
				}
			}
		}
		assertTrue(dup);
	}

}
