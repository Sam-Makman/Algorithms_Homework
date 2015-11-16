import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUI extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 6862691583402188666L;
	
private static final int WIDTH = 420;
private static final int HEIGHT = 600;
JFrame frame;
DrawPanel panel;
Board board;
ArrayList<JComponent> paintable;
public GUI(Board board){
	this.board=board;
	frame = createFrame();
	frame.addKeyListener(new Keys());
	paintable = new ArrayList<JComponent>();
	frame.getContentPane().add(new DrawPanel(board));
	frame.getContentPane().addKeyListener(new Keys());
	frame.setVisible(true);
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
class Keys implements KeyListener{
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar()=='w'){
			board.movePlayer(0, 1);
		}
		else if(e.getKeyChar()=='s'){
			board.movePlayer(0, -1);
		}else if(e.getKeyChar()=='a'){
			board.movePlayer(-1, 0);
		}else if(e.getKeyChar()=='d'){
			board.movePlayer(1, 0);
		}else if(e.getKeyChar()=='r'){
			board.clear();
			board.initBoardd();
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


}
