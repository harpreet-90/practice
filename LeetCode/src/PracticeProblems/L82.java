package PracticeProblems;

import java.util.ArrayList;

public class L82 {
	public ListNode deleteDuplicates(ListNode head)
	{
		if(head == null || (head != null && head.next==null)) return head;
		boolean flag = false;
		ListNode prev = head;
		ListNode pprev = head;
		ListNode trav = head;
		ListNode duplicate = null;
		while(trav != null)
		{
			if(trav.val != prev.val) 
			{	
				if(flag == true) 
				{
					flag = false;
					pprev.next = trav;
					prev = trav;
				}
				else
				{
					pprev = prev;
					prev = trav;
				}
			}
			else 
			{
				flag = true;
				duplicate = prev;
			}
			trav = trav.next;
		}
		
		head.printList(head);
		return head;
    }
	
	public ListNode deleteDuplicates1(ListNode head)
	{
		ArrayList<ListNode> hash = new ArrayList<ListNode>();
		ListNode prev = head;
		ListNode curr = head;
		
		if(head == null ||(head != null && head.next == null)) return head;
		hash.add(curr);
		curr = curr.next;
		while(curr != null)
		{
			if(prev.val == curr.val)
			{
				hash.remove(prev);
			}
			else 
			{
				hash.add(curr);
				prev = curr;
			}		
			if(curr != null) curr = curr.next;
		}
		head = null;
		if(hash.size() == 0) return null;
	
		head = hash.get(0);
		ListNode trav = head;
		trav.next = null;
		for(int i=1; i<hash.size(); i++)
		{
			ListNode temp = hash.get(i);
			temp.next = null;
			trav.next = temp;
			trav = trav.next;
			
		}
		head.printList(head);
		return head;
	}
}




/*


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
class Solution {
    public ListNode deleteDuplicates(ListNode head)
	{
		if(head == null || (head != null && head.next==null))   
            return head;
		
		ListNode prev = head;
		ListNode trav = head;
		
		while(trav != null)
		{
			if(trav.val != prev.val) 
			{	prev.next = trav;
				prev = trav;
			}
			else 
            {
				if(trav.next == null)
                {
					prev.next = null;
				}
			}
			trav = trav.next;
		}
		//head.printList(head);
		return head;
    }
}


*/