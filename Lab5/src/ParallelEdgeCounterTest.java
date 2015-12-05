import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParallelEdgeCounterTest {
	ParallelEdgeCounter pec;
	Graph g;
	@Before
	public void setUp() throws Exception {
		Graph g = new Graph(100);
		ParallelEdgeCounter pec = new ParallelEdgeCounter(g);
	}

	@Test
	public void testSize() {
		g = new Graph(100);
		 pec = new ParallelEdgeCounter(g);
		for(int i = 0; i< 15; i++){
			g.addEdge(i%5, (i+1)%5);
		}
		assertEquals(pec.size(), 10);
	}

}
