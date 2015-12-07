import java.util.concurrent.TimeUnit;

public class RunAway {

	public static void main(String[] args) throws InterruptedException {
		Board board = new Board();
		GUI gui = new GUI(board);
		board.setGui(gui);
		Task t = new Task(board);
		t.addPropertyChangeListener(gui);
		t.execute();
		boolean b = true;
		while(true){
			b= !b;
			gui.frame.repaint();
			if(board.isComplete()){
			TimeUnit.MILLISECONDS.sleep(250);
			board.movePlayer(gui.getPlayerMovement());
			if(b){
			board.moveGhost();
			}
			}
		}
	}

}
