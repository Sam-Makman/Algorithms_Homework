public class Stack<V> {

	Node head;
	
	public void push(V val){
		Node n = new Node();
		n.val = val;
		n.next = head;
		head = n;
	}
	
	public V pop(){
		V temp = head.val;
		head = head.next;
		return temp;
		
	}
	
	private class Node{
		V val;
		Node next;		
	}
}
