//Created by Michael Beall

public class RCS_Q<T> implements RCS_I<T> {
	public class LNode {
		T data;
		LNode link;
		public LNode(T theData, LNode nextLink) {
			data = theData;
			link = nextLink;
		}
	}
	private LNode head;
	private LNode current;
	
	public RCS_Q() {
		head = current = null;
	}
	
	public void enQueue(T addToQ) {
		LNode enter = new LNode(addToQ,null);
		if(head == null) {
			head = enter;
			current = head;
			return;
		}
		while (current.link != null)
			current = current.link;
	}
	public T deQueue() {
		if(head == null)
			return null;
		LNode temp = head;
		head = head.link;
		return temp.data;
	}
	public T peek() {
		if(head == null)
			return null;
		return head.data;
	}
	
	public void print() {
		LNode temp = head;
		while (temp != null) {
			System.out.println(temp.data.toString());
			temp = temp.link;
		}
	}
}