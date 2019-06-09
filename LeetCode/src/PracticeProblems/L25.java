package PracticeProblems;

public class L25 {
//	 public ListNode reverseKGroup(ListNode head, int k) 
//	 {
//		 if(head == null || (head!=null && head.next == null) || k<=1) return head;
//		 ListNode start = head;
//		 ListNode trav = head.next;
//		 int j = 0;
//		 while(trav != null)
//		 {
//			 if(j == k)
//			 {
//				 j=0;
//				 start = trav;
//				 trav = trav.next;
//			 }
//			 else 
//			 {
//				 j++;
//				 if(start == head)
//				 {
//					 ListNode temp = trav.next;
//					 trav.next = null;
//					 trav.next = head;
//					 head = trav;
//					 start = head;
//					 trav = temp;
//				 }
//				 else
//				 {
//					 ListNode temp = trav.next;
//					 trav.next = null;
//					 trav.next = start;
//					 start = trav;
//					 trav = temp;
//				 }
//			 }
//			 
//		 }
//		 head.printList(head);
//		 return head;
//	 }
	 public ListNode reverseBetween(ListNode head, int m, int n)
		{
			if(head == null || (head != null && head.next == null) || (m==n)) return head;
			
			ListNode trav = head;
			ListNode prev = head;
			int j = m;
			while(trav != null && m>1)
			{
				prev = trav;
				trav = trav.next;
				--m;
			}
			boolean flag = false;
			if(trav == null) return head;
			ListNode trav2 = null;
			if(trav != null)
			{
				trav2 = trav.next;
			}
			int k=j+1;
			while(k<=n)
			{
				k++;
				trav.next = trav2.next;
				trav2.next = prev.next;
				
				if(trav == head)
				{
					trav2.next = head;
					head = trav2;
					prev = head;
				}
				else if(prev == head && j==1)
				{
					trav2.next = head;
					head = trav2;
					prev = head;
				}
				else
				{
					prev.next = trav2;
				}
				
				trav2 = trav.next;
			}
			//head.printList(head);
			return head;
	    }
	 public int findLength(ListNode start)
     {
    	 int length =0;
    	 
    	 while(start != null) {
    		 length++;
    		 start = start.next;
    	 }
    	 
    	 return length;
    	 
     }
	 public ListNode reverseKGroup(ListNode head, int k) 
	 {
		 if(head==null || k<=1 || (head!=null && head.next==null)) return head;
		 
		 int length = findLength(head);
		 
		 int m=1, n=k;
		 
		 while(m<=length)
		 {
			 
			 head = reverseBetween(head, m, n);
			 head.printList(head);
			 if(n >= length) break;
			 m = n+1;
			 if((m+k-1) > length) {
				 n = length;
			 }
			 else 
			 {
				 n = m+k-1;
			 }
			 
			 
		 }
		 head.printList(head);
		 return head;
	 }
}
