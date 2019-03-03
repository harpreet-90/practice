
public class LinkedListNode {
	int value;
	LinkedListNode next;
	LinkedListNode(int value){
		this.value = value;
		this.next =null;
	}
	
	LinkedListNode(LinkedListNode node) 
	{
		this.value = node.value;
		this.next = node.next;
	}
	
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	
	public LinkedListNode getNext() {
		return this.next;
	}
	
}
