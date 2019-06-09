package PracticeProblems;

public class L92 {
	
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
		head.printList(head);
		return head;
    }
	
	
}
//1->2->3->4->null