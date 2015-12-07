import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUI extends JFrame implements PropertyChangeListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 6862691583402188666L;
	
private static final int WIDTH = 420;
private static final int HEIGHT = 600;
private Direction playerMovement;
JFrame frame;
DrawPanel panel;
Board board;
ArrayList<JComponent> paintable;
public GUI(Board board){
	frame = createFrame();
	frame.addKeyListener(new Keys());
	paintable = new ArrayList<JComponent>();
	frame.getContentPane().add(new DrawPanel(board));
	frame.getContentPane().addKeyListener(new Keys());
	frame.setVisible(true);
	this.board= board;
}

public void paint(Graphics g){

}

private JFrame createFrame(){
	JFrame frame = new JFrame();
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	return frame;
}

private DrawPanel createPanel(){
	DrawPanel panel = new DrawPanel(board);
	panel.setLayout(null);
	frame.add(panel);
//	paintable.add(panel);
	return panel;
}

public Direction getPlayerMovement(){
	return playerMovement;
}
class Keys implements KeyListener{
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar()=='w'){
//			board.movePlayer(Direction.NORTH);
			playerMovement= Direction.NORTH;
		}
		else if(e.getKeyChar()=='s'){
//			board.movePlayer(Direction.SOUTH );
			playerMovement= Direction.SOUTH;
		}else if(e.getKeyChar()=='a'){
//			board.movePlayer(Direction.WEST);
			playerMovement= Direction.WEST;
		}else if(e.getKeyChar()=='d'){
//			board.movePlayer(Direction.EAST);
			playerMovement= Direction.EAST;
		}else if(e.getKeyChar()=='r'){
//			board.clear();
//			board.initBoard();
		}
		frame.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e){
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
@Override
public void propertyChange(PropertyChangeEvent evt) {
	repaint();
}


}
