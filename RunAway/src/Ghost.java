
public abstract class Ghost {
	private int x, y;
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	 public int getX(){
		 return x;
	 }
	 
	 public int getY(){
		 return y;
	 }
	public abstract void move(Player player, Board board);
	
}

