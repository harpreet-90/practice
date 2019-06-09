package PracticeProblems;

public class L2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 int carry = 0, sum = 0;
		 ListNode trav1 = l1;
		 ListNode trav2 = l2;
		 ListNode newNode;
		 ListNode start = null, prev = null;
		 while(trav1 != null && trav2 != null) {
			 sum = trav1.val + trav2.val + carry;
			 carry = sum/10;
			 newNode = new ListNode(sum%10);
			 if(start == null)
			 {
				 start = newNode;
				 prev = newNode;
			 }
			 else {
				 prev.next = newNode;
			 }
			 prev = newNode;
			 trav2 = trav2.next;
			 trav1 = trav1.next;
		 }
		 
		 while(trav1 != null)
		 {
			 sum = trav1.val + carry;
			 carry = sum/10;
			 newNode = new ListNode(sum%10);
			 if(start == null)
			 {
				 start = newNode;
				 prev = newNode;
			 }
			 else {
				 prev.next = newNode;
			 }
			 prev = newNode;
			 trav1 = trav1.next;
		 }
		 
		 while(trav2 != null) {
			 sum = trav2.val + carry;
			 carry = sum/10;
			 newNode = new ListNode(sum%10);
			 if(start == null)
			 {
				 start = newNode;
				 prev = newNode;
			 }
			 else {
				 prev.next = newNode;
			 }
			 prev = newNode;
			 trav2 = trav2.next;
		 }
		 
		 if(carry != 0) {
			 newNode = new ListNode(carry);
			 prev.next = newNode;
		 }
		 return start;
	        
	 }
}
