package PracticeProblems;

public class L61 {
	public ListNode rotateRight(ListNode head, int k) 
	{
		int length = findLengthOfList(head);
		if(k == length) 
        { 
//        	head.printList(head); 
        	return head;
        }
		if(k > length) {
			k = k%length;
		}
		if(head == null || k==0) 
        { 
//        	head.printList(head); 
        	return head;
        }
        ListNode newStart = head;
        ListNode lastNode = head;
//        ListNode prev = head;
        
        while(k>0 && lastNode!=null)
        {
        	lastNode = lastNode.next;
        	k = k-1;
        }
        
        if(lastNode == null) 
        { 
//        	head.printList(head); 
        	return head;
        }
        
        while(lastNode != null && lastNode.next != null)
        {
//        	prev = newStart;
        	newStart = newStart.next;
        	lastNode = lastNode.next;
        }
        
        if(newStart.next == head) 
        { 
//        	head.printList(head); 
        	return head;
        }
        
        ListNode temp = head;
        head = newStart.next;
        newStart.next = null;
        lastNode.next = temp;
       // System.out.println(head);
        //head.printList(head);
		return head;
    }
	
	private int findLengthOfList(ListNode head)
	{
		int length = 0;
//		if(head != null) length =1;
		while(head!= null) {
			length++;
			head = head.next;
		}
		return length;
	}
}
