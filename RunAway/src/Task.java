import javax.swing.SwingWorker;

public class Task extends SwingWorker<Void, Void>{
	Board b;
	public Task(Board b){
		this.b = b;
	}
	@Override
	protected Void doInBackground() throws Exception {
	b.initBoard();
		return null;
	}

}
