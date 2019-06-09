package PracticeProblems;

public class L24 {
	 public ListNode swapPairs(ListNode head) {
		 // if there 0 or 1 no. of nodes in list
		 if(head == null || head.next == null) return head;
		 
		 // more then one nodes
		 
		 //swap first 2 node and update head.
		 ListNode trav = head;
		 ListNode next = (trav.next).next;
		 head = trav.next;
		 head.next = trav;
		 ListNode prev = head.next;
		 head.next.next = next;
		 //set trav == 3rd node of list
		 trav = next;
		 while(trav != null && trav.next != null)
		 {
			 next = trav.next.next;
			 prev.next = trav.next;
			 trav.next = next;
			 prev.next.next = trav;
			 prev = trav;
			 trav = next;
		 }
		 	head.printList(head);
	        return head;
	    }
	 
	 
	 
	 
	 
}
