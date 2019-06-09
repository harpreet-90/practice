package PracticeProblems;

public class L147 {
	public ListNode insertionSortList(ListNode head) {
        if(head==null || (head!=null && head.next==null)) return head;
        ListNode newHead = head;
        ListNode trav = head.next;
        newHead.next = null;
        
        while(trav!=null)
        {
            ListNode temp = trav.next;
            trav.next = null;
            newHead = insertInSortedList(trav, newHead);
            trav = temp;
        }
        newHead.printList(newHead);
        return newHead;
    }
    
    private ListNode insertInSortedList(ListNode newNode, ListNode head)
    {
        if(head == null) return newNode;
        ListNode trav = head;
        if(head.val >= newNode.val)
        {
            newNode.next = head;
            return newNode;
        }
        else{
            if(head.next == null || head.next.val >= newNode.val)
            {
                newNode.next = head.next;
                head.next = newNode;
                return head;
            }
            else{
                trav = head.next;
            }
        }
        
        while(trav != null)
        {
            if(isSafe(trav,newNode))
            {
                newNode.next = trav.next;
                trav.next = newNode;
                return head;
            }
            else{
                trav = trav.next;
            }
        }     
        return null;
    }
    
    boolean isSafe(ListNode head, ListNode item)
    {
        if(head.val <= item.val)
        {
            if(head.next == null || head.next.val >= item.val)
            {
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
}
