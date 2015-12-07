import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Board {
	private static final int WIDTH = 7;
	private static final int HEIGHT = 10;
	private Ghost[] ghosts;
	private Player player;
	public Sector sectors[][];
	private GUI g;
	private boolean complete;
	
	public Board() {
		ghosts = new Ghost[2];
		sectors = new Sector[7][10];
		ghosts[0] = new OrangeGhost();
		ghosts[1] = new GreenGhost();
		player = new Player();
		player.setLocation(1, 1);
		setComplete(false);
		
	
	}
	public void setGui(GUI g){
		this.g = g;
	}
		public void initBoard(){
			int[] start = placeCage();
			
			placeSector(start[0], start[1]-1);
			player.setLocation(start[0]*3 + 1, (start[1]*3));
			ghosts[0].setLocation(start[0]*3 + 1, start[1]*3 + 1);
			ghosts[1].setLocation(start[0]*3 + 1, start[1]*3 + 2);
			for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if(sectors[i][j] == null){
				sectors[i][j] = new Sector(4);
				}
			}
		}
	setComplete(true);
		}
	public int[] placeCage() {
		Random r = new Random();
		int startx = r.nextInt(WIDTH - 1) + 1;
		int starty = r.nextInt(HEIGHT - 2) + 2;
		sectors[startx][starty] = new Sector();
		return new int[] { startx, starty };
	}

	/*
	 * rules: No dead ends No boxes (4 halls in a square)
	 * 
	 */
	public void placeSector(int x, int y)  {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		g.repaint();
		if(sectors[x][y]!=null)return;
		Random r = new Random();
		int j;
		for(j = 0; j<100; j++) {
			sectors[x][y] = new Sector(r.nextInt(6)%4);
			for(int i = 0; i<4;i++){
				if(!validSectorPlacement(x, y)){
					sectors[x][y].rotate();
				}
			}
			if(validSectorPlacement(x, y)){
			break;
			}
		}
		if(j>90){
			System.out.println("No valid placement");
			sectors[x][y] = new Sector(4);
			return;
		}
		if(sectors[x][y].getTiles()[1][0].equals(Tile.HALL)){
			if(sectors[x][((y-1)+HEIGHT)%HEIGHT] != null){
				if(sectors[x][((y-1)+HEIGHT)%HEIGHT].getTiles()[1][2].equals(Tile.WALL)){
					sectors[x][((y-1)+HEIGHT)%HEIGHT].getTiles()[1][2] = Tile.HALL;
				}
			}
			placeSector(x, ((y-1)+HEIGHT)%HEIGHT);
		}
		if(sectors[x][y].getTiles()[0][1].equals(Tile.HALL)){
			if(sectors[((x - 1)+WIDTH) % WIDTH][y] != null){
				if(sectors[((x - 1)+WIDTH) % WIDTH][y].getTiles()[2][1].equals(Tile.WALL)){
					sectors[((x - 1)+WIDTH) % WIDTH][y].getTiles()[2][1] = Tile.HALL;
				}
			}
			placeSector(((x - 1)+WIDTH) % WIDTH, y);
		}
		if(sectors[x][y].getTiles()[2][1].equals(Tile.HALL)){
			if(sectors[(x + 1) % WIDTH][y] != null){
				if(sectors[(x + 1) % WIDTH][y].getTiles()[0][1].equals(Tile.WALL)){
					sectors[(x + 1) % WIDTH][y].getTiles()[0][1] = Tile.HALL;
				}
			}
			placeSector((x + 1) % WIDTH, y);
		}
		if(sectors[x][y].getTiles()[1][2].equals(Tile.HALL)){
			if(sectors[x][(y+1)%HEIGHT] != null){
				if(sectors[x][(y+1)%HEIGHT].getTiles()[1][0].equals(Tile.WALL)){
					sectors[x][(y+1)%HEIGHT].getTiles()[1][0] = Tile.HALL;
				}
			}
			placeSector(x, (y+1)%HEIGHT);
		}
	}

	public boolean validSectorPlacement(int x, int y) {
		Sector temp = sectors[x][y];
		if (temp == null) {
			return false;
		}
		if (!(sectors[x][(y + 1) % HEIGHT] == null) && sectors[x][(y + 1) % HEIGHT].getTiles()[1][0].equals(Tile.HALL)) {
			if (!temp.getTiles()[1][2].equals(Tile.HALL)) {
				return false;
			}
		}
		if (!(sectors[(x + 1) % WIDTH][y]==null) && sectors[(x + 1) % WIDTH][y].getTiles()[0][1].equals(Tile.HALL)) {
			if (!temp.getTiles()[2][1].equals(Tile.HALL)) {
				return false;
			}
		}
		if (!(sectors[((x - 1)+WIDTH) % WIDTH][y] == null) && sectors[((x - 1)+WIDTH) % WIDTH][y].getTiles()[2][1].equals(Tile.HALL)) {
			if (!temp.getTiles()[0][1].equals(Tile.HALL)) {
				return false;
			}
		}
		if (!(sectors[x][((y-1)+HEIGHT)%HEIGHT] == null) && sectors[x][((y-1)+HEIGHT)%HEIGHT].getTiles()[1][2].equals(Tile.HALL)) {
			if (!temp.getTiles()[1][0].equals(Tile.HALL)) {
				return false;
			}
		}
		return true;
	}
	
	public Tile[][] getTiles() {
		Tile[][] tiles = new Tile[WIDTH * 3][HEIGHT * 3];
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				for (int m = 0; m < 3; m++) {
					for (int n = 0; n < 3; n++) {
						if(sectors[i][j]!=null){
						tiles[i * 3 + m][j * 3 + n] = sectors[i][j].getTiles()[m][n];
						}else{
							tiles[i * 3 + m][j * 3 + n] = null;
						}
					
					}
				}
			}
		}
		return tiles;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
	public Player getPlayer(){
		return player;
	}
	
	public Ghost[] getGhost(){
		return ghosts;
	}
	
	public void movePlayer(Direction d){
		player.move(d,this);
	}
	
	public void moveGhost(){
		ghosts[0].move(player, this);
		ghosts[1].move(player, this);
	}
	
	public void clear(){
		for(int i = 0; i<WIDTH; i++){
			for(int j = 0; j<HEIGHT; j++){
				sectors[i][j] = null;
			}
		}
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
}
