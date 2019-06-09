package PracticeProblems;

import java.util.*;
class SortNode implements Comparator<ListNode> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(ListNode a, ListNode b) 
    { 
        return a.val - b.val; 
    } 
} 
public class L23 {
	 public ListNode mergeKLists(ListNode[] lists) 
	    {
	        ListNode head = null;
	        int k = lists.length;
	        PriorityQueue<ListNode> pQueue =  new PriorityQueue<ListNode>(new SortNode()); 
	        int i=0;
	        while(i<k)
	        {
	        	pQueue.add(lists[i]);
	        	i++;
	        }
	        ListNode trav = head;
	        while(!pQueue.isEmpty()) 
	        {
	        	ListNode temp = pQueue.poll();
	        	if(temp.next != null)
	        	{
	        		pQueue.add(temp.next);
	        	}
	        	temp.next = null;
	        	if(head == null) 
	        	{
	        		trav = temp;
	        		head = trav;
	        	}
	        	else
	        	{
	        		trav.next = temp;
	        		trav = trav.next;
	        	}
	        }
	        //head.printList(head);
		 	return head;
	    }
}
