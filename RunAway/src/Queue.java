
public class Queue<V> {
	private Node head,tail;

	public Queue(){
		
	}
	
	public void enqueue(V val){
		Node n = new Node();
		n.val=val;
		tail.next = n;
		tail=n;
		
		if(head==null){
			head=n;
		}
	}
	
	public V dequeue(){
		V temp = head.val;
		head=head.next;
		return temp;
	}
	
	private class Node{
		V val;
		Node next;		
	}
}
