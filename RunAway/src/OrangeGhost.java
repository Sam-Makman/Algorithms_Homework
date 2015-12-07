
public class OrangeGhost extends Ghost {
	
	@Override
	public void move(Player player, Board board) {
		boolean[][] searched = new boolean[board.getWidth() * 3][board.getHeight() * 3];
		Queue<Node> q = new Queue<Node>();
		q.enqueue(new Node(this.getX(), this.getY(), null));
		Node n = moveHelper(player, board, q, searched);
		for (Node node = n; node != null; node = node.last) {
			if(node.last == null){
				n = node;
			}else if (node.last.x == this.getX() && node.last.y == this.getY()) {
				n = node;
				break;
			}
		}
		if (n == null) {
		} else {
			this.setLocation(n.x, n.y);
		}
	}

	private Node moveHelper(Player p, Board b, Queue<Node> q, boolean[][] searched) {
		Node n = q.dequeue();
		int width = b.getWidth() * 3;
		int height = b.getHeight() * 3;
		if (n == null) {
			return n;
		}
		if (n.x == p.getX() && n.y == p.getY()) {
			return n;
		}

		if (!searched[n.x][n.y]) {
			if (b.getTiles()[(n.x + 1) % width][n.y] == Tile.HALL
					|| b.getTiles()[(n.x + 1) % width][n.y] == Tile.CAGE) {
				q.enqueue(new Node((n.x + 1) % width, n.y, n));
			}
			if (b.getTiles()[n.x][(n.y + 1) % height] == Tile.HALL
					|| b.getTiles()[n.x][(n.y + 1) % height] == Tile.CAGE) {
				q.enqueue(new Node(n.x, (n.y + 1) % height, n));
			}
			if (b.getTiles()[(n.x - 1 + width) % width][n.y] == Tile.HALL
					|| b.getTiles()[(n.x - 1 + width) % width][n.y] == Tile.CAGE) {
				q.enqueue(new Node((n.x - 1 + width) % width, n.y, n));
			}
			if (b.getTiles()[n.x][(n.y - 1 + height) % height] == Tile.HALL
					|| b.getTiles()[n.x][(n.y - 1 + height) % height] == Tile.CAGE) {
				q.enqueue(new Node(n.x, (n.y - 1 + height) % height, n));
			}
			searched[n.x][n.y] = true;
		}

		return moveHelper(p, b, q, searched);

	}

	class Node {
		int x, y;
		Node last;

		private Node(int x, int y, Node last) {
			this.x = x;
			this.y = y;
			this.last = last;
		}
	}
}
