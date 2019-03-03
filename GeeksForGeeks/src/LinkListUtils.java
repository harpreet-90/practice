import java.util.*;

public class LinkListUtils {
	
	boolean detectLoop(LinkedListNode start) {
	
		if(start == null) return false;
		LinkedListNode slow = start, fast = start;
		
		while((slow != null) && (fast != null) && (fast.next != null))
		{
			slow = slow.next;
			fast = (fast.next).next;
			if(fast == slow) return true;
		}
		return false;
	}
	
	LinkedListNode findLoopStart(LinkedListNode start) {
		
		if(start == null) return null;
		LinkedListNode slow = start, fast = start, prev = null;
		
		while((slow != null) && (fast != null) && (fast.next != null))
		{
			slow = slow.next;
			fast = (fast.next).next;
			if(fast == slow) { break;}
		}
		if((slow != null) && (fast != null) && (fast.next != null))
		{
			slow = start;
			while(slow != fast) 
			{
				prev = fast;
				slow = slow.next;
				fast = fast.next;
			}
			return prev;
		}
		return prev;
	}
	
	void removeListLoop(LinkedListNode start) {
		LinkedListNode lastNode = findLoopStart(start);
		if(lastNode != null) {
			lastNode.next = null;
			
		}
	}
	
	LinkedListNode mergeSortList(LinkedListNode start)
	{
		if((start == null) || (start.next == null)) { return start;}
	
		//find middle of linked list
		LinkedListNode middle = getMiddle(start);
		LinkedListNode nextOfMiddle = middle.next;
		
		middle.next = null;
		
		LinkedListNode left = mergeSortList(start);
		LinkedListNode right = mergeSortList(nextOfMiddle);
		
		LinkedListNode sortedListStart = sortedMerge(left, right);
		
		return sortedListStart;
		
	}
	
	
	private LinkedListNode sortedMerge(LinkedListNode left, LinkedListNode right) {
		if(left == null) return right;
		if(right == null) return left;
		LinkedListNode result = null;
		if(left.value < right.value) {
			result = left;
			result.next = sortedMerge(left.next, right);
		}
		else {
			result = right;
			result.next = sortedMerge(left, right.next);
		}
		return result;
	}

	private LinkedListNode getMiddle(LinkedListNode start) {
		if(start == null) return null;
		LinkedListNode slow =start;
		LinkedListNode fast = start.next;
		while((slow != null) && (fast != null) && (fast.next != null))
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	
	void printFlatenSortedList(NodeVerNext start) {
		if(start == null) return;
		 PriorityQueue<NodeVerNext> pQueue = initializeQueue(start);
		 
		 while(!pQueue.isEmpty()) {
			 NodeVerNext minNode = pQueue.remove();
			 if(minNode.vertical != null) pQueue.add(minNode.vertical);
			 System.out.print(minNode.value + " ");
		 }
	}

	private PriorityQueue<NodeVerNext> initializeQueue(NodeVerNext start) {
		 PriorityQueue<NodeVerNext> pQueue = new PriorityQueue<NodeVerNext>(new QueueSortingComparator()); 
		 NodeVerNext trav = start;
		 
		 while(trav != null) {
			 pQueue.add(trav);
			 trav = trav.next;
		 }
		return pQueue;
	}	
	
}

class QueueSortingComparator implements Comparator<NodeVerNext> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(NodeVerNext a, NodeVerNext b) 
    { 
       return a.value - b.value;  
    } 
}
