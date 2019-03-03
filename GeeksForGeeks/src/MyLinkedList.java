
public class MyLinkedList {

	LinkedListNode start = null;
	
	public void insert(int value){
		LinkedListNode newNode = new LinkedListNode(value);
		if(this.start == null) {
			this.start = newNode;
		}
		else {
			LinkedListNode trav = this.start;
			while(trav.next != null) {
				trav= trav.next;
			}
			trav.next = newNode;
		}
	}
	
	MyLinkedList reverseList(MyLinkedList list)
	{
		if(list == null) return null;
		MyLinkedList reverseList = new MyLinkedList();
		for(LinkedListNode trav = list.start; trav != null; trav = trav.next) {
			insertAtStart(reverseList, trav);
		}
		return reverseList;
	}
	
	void insertAtStart(MyLinkedList list, LinkedListNode node) {
		if(node == null || list == null) return;
		LinkedListNode tempStart = list.start;
		node.next = list.start;
		list.start = tempStart;
	}
	
	LinkedListNode reverseList(LinkedListNode start) {
		if(start == null) return null;
		LinkedListNode reverseListStart = null;
		LinkedListNode trav = start;
		while(trav !=null) {
			LinkedListNode nextNode = trav.next;
			reverseListStart = insertAtStart(reverseListStart, trav);
			trav = nextNode;
		}
		
		return reverseListStart;
	}
	
	LinkedListNode insertAtStart(LinkedListNode start, LinkedListNode node) {
		if( node == null ) return start;
		node.next = start;
		return node;
	}
	
	void printList(LinkedListNode start) {
		LinkedListNode trav = start;
		while(trav != null) {
			System.out.print(trav.value + "->");
			trav = trav.next;
		}
		System.out.print("null");
	}

	
	
	
}
