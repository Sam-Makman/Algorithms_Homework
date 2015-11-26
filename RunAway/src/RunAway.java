import java.util.concurrent.TimeUnit;

public class RunAway {

	public static void main(String[] args) throws InterruptedException {
		Board board = new Board();
		GUI gui = new GUI(board);
		board.initBoard();
		while(true){
			TimeUnit.MILLISECONDS.sleep(250);
			gui.frame.repaint();
			board.movePlayer(gui.getPlayerMovement());
			board.moveGhost();
		}
	}

}
