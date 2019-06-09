package PracticeProblems;

public class L21MergeTwoSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode trav1 = l1;
        ListNode trav2 = l2;
        ListNode newStart = null;
        ListNode prev =null;
        ListNode newNode = null;
        while(trav1!=null && trav2!=null)
        {
        	
        	if(trav1.val <= trav2.val) {
        		newNode = new ListNode(trav1.val);
        		trav1 = trav1.next;
        	}
        	else
        	{
        		newNode = new ListNode(trav2.val);
        		trav2 = trav2.next;
        	}
        	if(newStart == null)
        	{
        		newStart = newNode;
        		prev = newStart;
        	}
        	else
        	{
        		prev.next = newNode;
        	}
        	prev = newNode;
        }
        while(trav1 != null) {
        	newNode = new ListNode(trav1.val);
        	if(newStart == null)
        	{
        		newStart = newNode;
        		prev = newStart;
        	}
        	else
        	{
        		prev.next = newNode;
        	}
        	prev = newNode;
        	trav1 = trav1.next;
        }
        while(trav2 != null) {
        	newNode = new ListNode(trav2.val);
        	if(newStart == null)
        	{
        		newStart = newNode;
        		prev = newStart;
        	}
        	else
        	{
        		prev.next = newNode;
        	}
        	prev = newNode;
        	trav2 = trav2.next;
        }
        
		return newStart;
    }
}
