package PracticeProblems;

public class L203 {
	public ListNode removeElements(ListNode head, int val) 
	{
		if(head == null) return null;
		ListNode trav = head;
		ListNode prev = head;
		while(trav != null)
		{
			if(trav.val == val) {
				if(trav == head)
				{
					head = trav.next;
					prev = head;
				}
				else {
					prev.next = trav.next;
				}
			}
			else {
				prev = trav;
			}
			trav = trav.next;
		}
		//head.printList(head);
		return head;
    }
}
