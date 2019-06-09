package PracticeProblems;

public class L328 {
	 public ListNode oddEvenList(ListNode head) {
		 
		 if(head==null || (head!=null && head.next == null)) return head;
		 
		 ListNode h1 = head;
		 ListNode h2 = head.next;
		 ListNode trav1 = h1;
		 ListNode trav2 = h2;
		 ListNode temp1 = h1;
		 ListNode temp2 = h2;
		 
		 while(trav1!=null && trav2!=null && trav2.next!=null)
		 {
			 temp1 = (trav1.next).next;
			 temp2 = (trav2.next).next;
			 trav1.next = temp1;
			 trav2.next = temp2;
			 trav1 =trav1.next;
			 trav2 = trav2.next;
		 }
		 head = h1;
		 trav1.next = h2;
		 head.printList(head);
		 return head;
	 }
}
