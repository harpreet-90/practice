package PracticeProblems;

public class L19 {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 ListNode fast = head;
		 ListNode slow = head;
		 ListNode prev = head;
		 while(n!=0 && fast!=null) {
			 fast = fast.next;
			 n--;
		 }
		 if(fast == null && n==0) return head.next; 
		 while(fast!=null)
		 {
			 fast = fast.next;
			 prev = slow;
			 slow = slow.next;
			 
		 }
		 if(slow == null) return head;
		 if(slow == head && head.next == null) return head;
		 if(slow == head && head.next != null) return head.next;
		 prev.next = slow.next;
		 return head;
	 }
}
// 1->2->3->4->null
// 4