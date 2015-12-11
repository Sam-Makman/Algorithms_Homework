
public class Queue<V> {
	private Node head,tail;
	private int size;
	public Queue(){
		
	}
	
	public void enqueue(V val){
		size++;
		Node n = new Node();
		n.val=val;
		if(tail == null){
			tail = n;
		}else{
		tail.next = n;
		tail = n;
		}
		if(head==null){
			head=n;
		}
	}
	
	public V dequeue(){
		if(head == null){
			return null;
		}
		size--;
		V temp = head.val;
		head=head.next;
		return temp;
	}
	
	private class Node{
		V val;
		Node next;		
	}
	public int size(){
		return size;
	}
}
