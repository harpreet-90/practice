import java.util.HashMap;

public class LeetCode {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> hash1 =createHashFromArr(nums);
		for(int i=0;i<nums.length;i++) {
			int secNum = target - nums[i];
			if(hash1.containsKey(secNum) && hash1.get(secNum) != i) {
				int[] arr = {i , (hash1.get(secNum))};
				return arr;
			}
		}
		return null;
    }
	
	HashMap<Integer,Integer> createHashFromArr(int[] arr){
		HashMap<Integer,Integer> hash1 = new HashMap<Integer,Integer>();
		if(arr.length == 0) {
			return null;
		}
		for(int i=0;i<arr.length;i++) {
			hash1.put(arr[i], i);
		}
		return hash1;
	}
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 int carry = 0, sum = 0;
		 ListNode trav1 = l1;
		 ListNode trav2 = l2;
		 ListNode newNode;
		 ListNode start = null, prev = null;
		 while(trav1 != null && trav2 != null) {
			 sum = trav1.val + trav2.val + carry;
			 carry = sum/10;
			 newNode = new ListNode(sum%10);
			 if(start == null)
			 {
				 start = newNode;
				 prev = newNode;
			 }
			 else {
				 prev.next = newNode;
			 }
			 prev = newNode;
			 trav2 = trav2.next;
			 trav1 = trav1.next;
		 }
		 
		 while(trav1 != null)
		 {
			 sum = trav1.val + carry;
			 carry = sum/10;
			 newNode = new ListNode(sum%10);
			 if(start == null)
			 {
				 start = newNode;
				 prev = newNode;
			 }
			 else {
				 prev.next = newNode;
			 }
			 prev = newNode;
			 trav1 = trav1.next;
		 }
		 
		 while(trav2 != null) {
			 sum = trav2.val + carry;
			 carry = sum/10;
			 newNode = new ListNode(sum%10);
			 if(start == null)
			 {
				 start = newNode;
				 prev = newNode;
			 }
			 else {
				 prev.next = newNode;
			 }
			 prev = newNode;
			 trav2 = trav2.next;
		 }
		 
		 if(carry != 0) {
			 newNode = new ListNode(carry);
			 prev.next = newNode;
		 }
		 return start;
	        
	 }
	 
	 
	
}

