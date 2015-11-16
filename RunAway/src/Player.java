
public class Player {
	private int x, y;

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void move(int xdirection, int ydirection, Board board) {
		Tile[][] temp = board.getTiles();
		int width = board.getWidth()*3;
		int height = board.getHeight()*3;
		if(xdirection>0){
			if(temp[(x+1)%width][y] != Tile.WALL){
				x = (x+1)%width;
			}
		}else if(xdirection<0){
			if(temp[(x-1+width)%width][y] != Tile.WALL){
				x = (x-1+width)%width;
			}
		}else if(ydirection<0){
			if(temp[x][(y+1)%height] != Tile.WALL){
				y=(y+1)%height;
			}
		}else if(ydirection>0){
			if(temp[x][(y-1+height)%height] != Tile.WALL){
				y=(y-1+height)%height;
			}
		}
	}
}
