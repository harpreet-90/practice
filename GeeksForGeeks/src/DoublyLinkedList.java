
public class DoublyLinkedList {
	DoublyLinkListNode start = null;
	DoublyLinkListNode end =  null;
	
	void insert(DoublyLinkListNode node){
		if(node == null) return;
		
		if(start == null) {
			start = node;
			end = node;
		}
		else
		{
			node.prev = end;
			end.next = node;
			end = node;
		}
	}
	
	DoublyLinkedList append(DoublyLinkedList dll) {
		if(dll == null) return dll;
		
		if(this.start == null) {
			this.start = dll.start;
			this.end = dll.end;
		}
		else {
			this.end.next = dll.start;
			dll.start.prev = this.end;
			this.end = dll.end;
		}
		return this;
	}
	
	void printDll(Direction d) {
		if(start == null) return;
		
		DoublyLinkListNode trav = (d==Direction.FORWARD)? start: end;
		while(trav != null)
		{
			System.out.print(trav.value + " ");
			trav = d == Direction.FORWARD? trav.next: trav.prev;
		}
	}
}
