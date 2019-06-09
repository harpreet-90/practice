package PracticeProblems;

public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
     
     
     void printList(ListNode start)
     {
    	 while(start != null)
    	 {
    		 System.out.print(start.val+"->");
    		 start = start.next;
    	 }
    	 System.out.print("null");
    	 System.out.println();
     }
     
     public int findLength(ListNode start)
     {
    	 int length =0;
    	 
    	 while(start != null) {
    		 length++;
    		 start = start.next;
    	 }
    	 
    	 return length;
    	 
     }
}