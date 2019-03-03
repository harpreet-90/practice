import java.util.*;
public class StackUtils {
	void MaxElementInStack(int[] arr)
	{
		if(arr.length == 0) return;
		int max=0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<arr.length;i++)
		{
			if(max < arr[i]) 
			{	
				stack.push((2*arr[i])-max);
				max = arr[i];
			}
			else
			{	
				stack.push(arr[i]);
			}
		}
		// printing max element at each element
		
		while(!stack.isEmpty()) {
			int val = stack.pop();
			if(val< max) {
				System.out.println(val + "->" + max);
			}
			else {
				System.out.println(max + "->" + max);
				max = 2*max - val;
			}
		}
		
	}
	
	void nextGratorElement(int arr[]) {
		int length = arr.length;
		if(length == 0) return;
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i=(length-1);i>=0;i--) {
			if(st.isEmpty()) {
				System.out.println(arr[i]+"->-1");
				st.push(arr[i]);
			}
			else {
				if(arr[i] < st.peek()) {
					System.out.println(arr[i]+"->"+st.peek());
					st.push(arr[i]);
				}
				else {
					while(!st.isEmpty() && arr[i] > st.peek()) {
						st.pop();
					}
					if(st.isEmpty()) {
						System.out.println(arr[i]+"->-1");
						st.push(arr[i]);
					}
					else {
						System.out.println(arr[i]+"->"+ st.peek());
						st.push(arr[i]);
					}
				}
			}
		}
	}
	
	
}
