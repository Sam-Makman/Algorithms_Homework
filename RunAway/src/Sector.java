
public class Sector {
	private Tile[][] tiles;

	public Sector() {
		tiles = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < 3; j++) {
				tiles[i][j] = Tile.CAGE;
			}
		}
		tiles[0][0] = Tile.WALL;
		tiles[1][0] = Tile.HALL;
		tiles[2][0] = Tile.WALL;

	}

	public Sector(int type) {
		tiles = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j] = Tile.WALL;
			}
		}
		
		switch (type) {
		case 0:
			tiles[1][0] = Tile.HALL;
			tiles[1][1] = Tile.HALL;
			tiles[0][1] = Tile.HALL;
			break;
		case 1:
			tiles[1][0] = Tile.HALL;
			tiles[1][1] = Tile.HALL;
			tiles[1][2] = Tile.HALL;
			break;
		case 2:
			tiles[1][0] = Tile.HALL;
			tiles[0][1] = Tile.HALL;
			tiles[1][1] = Tile.HALL;
			tiles[1][2] = Tile.HALL;
			break;
		case 3:
			tiles[1][0] = Tile.HALL;
			tiles[0][1] = Tile.HALL;
			tiles[1][1] = Tile.HALL;
			tiles[1][2] = Tile.HALL;
			tiles[2][1] = Tile.HALL;
			break;
		}
	}

	public void rotate() {
		Tile[][] temp = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[i][j] = tiles[3 - j - 1][j];
			}
		}
		tiles = temp;
	}

	public void connect(Sector s, Direction d) {

	}

	public Tile[][] getTiles() {
		return tiles;
	}
}
