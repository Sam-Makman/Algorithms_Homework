import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class DrawPanel extends JComponent{
	private final static  int WIDTH = 20;
	private final static int HEIGHT = 20;
	Board board;
	
	public DrawPanel(Board board){
		this.board = board;
	}
	
	@Override
	public void paint(Graphics g){
	
		for(int i = 0; i<board.getWidth()*3; i++){
			for(int j=0; j<board.getHeight()*3;j++){
				if(board.getTiles()[i][j] == null){
				g.setColor(Color.CYAN);
				}
				else if(board.getTiles()[i][j].equals(Tile.CAGE)){
					g.setColor(Color.RED);
				}else if(board.getTiles()[i][j].equals(Tile.HALL)){
					g.setColor(Color.BLUE);
				}else if(board.getTiles()[i][j].equals(Tile.WALL)){
					g.setColor(Color.BLACK);
				}
				g.fillRect(20*i,20*j,WIDTH,HEIGHT);
			}
		}
		g.setColor((Color.YELLOW));
		g.fillRect(board.getPlayer().getX()*20, board.getPlayer().getY()*20, WIDTH, HEIGHT);
		g.setColor((Color.ORANGE));
		g.fillRect(board.getGhost().getX()*20, board.getGhost().getY()*20, WIDTH, HEIGHT);
	}
}
