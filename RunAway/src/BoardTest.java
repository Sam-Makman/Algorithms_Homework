import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	@Before
	public void setUp() throws Exception {
		board = new Board();
		
		
	}

	@Test
	public void testBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlaceCage() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlaceSector() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidSectorPlacement() {
		board.sectors[2][2] = new Sector(0);
		board.sectors[1][2] = new Sector(3);
		assertTrue(board.validSectorPlacement(2, 2));
	}

	@Test
	public void testFixBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTiles() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWidth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeight() {
		fail("Not yet implemented");
	}

}
