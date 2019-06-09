package PracticeProblems;

public class L430 {
	 public NodeWithChild flatten(NodeWithChild head) 
	 {
		 NodeWithChild trav = head;
		 NodeWithChild last = head;
		 
		 while(trav != null) 
		 {
			 if(trav.child != null)
			 {
				 NodeWithChild temp = trav.next;
				 trav.next = trav.child;
				 trav.next = flatten(trav.next); 
				 last = trav.next;
				 while(last!=null && last.next!=null)
				 {
					 last = last.next;
				 }
				 trav = last;
				 trav.next = temp;
				 
			 }
			 trav = trav.next;
		 }
		 trav = head;
		 NodeWithChild prev = null;
		 while(trav != null)
		 {
			 trav.prev = prev;
			 prev = trav;
			 trav.child = null;
			 trav = trav.next;
		 }
	     return head;   
	 }
}


