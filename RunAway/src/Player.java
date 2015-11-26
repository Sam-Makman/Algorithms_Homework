
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

	public void move(Direction d, Board board) {
		Tile[][] temp = board.getTiles();
		int width = board.getWidth()*3;
		int height = board.getHeight()*3;
		if(d == Direction.EAST){
			if(temp[(x+1)%width][y] != Tile.WALL){
				x = (x+1)%width;
			}
		}else if(d== Direction.WEST){
			if(temp[(x-1+width)%width][y] != Tile.WALL){
				x = (x-1+width)%width;
			}
		}else if(d == Direction.SOUTH){
			if(temp[x][(y+1)%height] != Tile.WALL){
				y=(y+1)%height;
			}
		}else if(d == Direction.NORTH){
			if(temp[x][(y-1+height)%height] != Tile.WALL){
				y=(y-1+height)%height;
			}
		}
	}
}
