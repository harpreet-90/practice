package PracticeProblems;

import java.util.*;

public class L138 {
	HashMap<Node,Node> hash = new HashMap<Node,Node>();
	public Node copyRandomList(Node head) {
        Node newHead = copyListWithoutRandom(head);
		createHash(head, newHead);
        
		// add new Random Ptr in new List
		Node trav = newHead;
		while(trav!= null)
		{
			trav.random = hash.get(trav.random);
			trav = trav.next;
		}
		return newHead;
    }

	private void createHash(Node head, Node newHead) {
		// TODO Auto-generated method stub
		while(head!=null && newHead!=null)
		{
			hash.put(head, newHead);
			head = head.next;
			newHead = newHead.next;
		}
	}

	private Node copyListWithoutRandom(Node head) {
		if(head == null) return null;
		Node newHead = new Node(head.val,null,head.random);
		Node travN = newHead;
		Node travO = head;
		travO = travO.next;
		while(travO != null)
		{
			travN.next = new Node(travO.val,null,travO.random);
			travN = travN.next;
			travO = travO.next;
		}
		return newHead;
	}
}
