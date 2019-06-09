package PracticeProblems;

public class L86 {
	public ListNode partition(ListNode head, int x)
	{
		ListNode smallNode = head;
		ListNode trav = head;
		ListNode prev = head;
		while(smallNode != null && (smallNode.val < x) && smallNode.next!=null && smallNode.next.val < x)
		{
			prev = smallNode;
			smallNode = smallNode.next;
		}
		
		if(smallNode != null)
		{
			trav = smallNode.next;
			
			while(trav != null)
			{
				if(trav.val < x)
				{
					if(smallNode == head && smallNode.val >= x) 
					{
						prev.next = trav.next;
						smallNode = head;
						head = trav;
						head.next = smallNode;
						smallNode = head;
						trav = prev.next;
					}
					else
					{
						prev.next = trav.next;
						trav.next = smallNode.next;
						smallNode.next = trav;
						trav = prev.next;
						smallNode = smallNode.next;
					}
				}
				else {
					prev = trav;
					trav = trav.next;
				}
			}
		}
		head.printList(head);
		return head;
    }
}
