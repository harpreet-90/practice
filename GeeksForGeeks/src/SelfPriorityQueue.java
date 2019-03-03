import java.util.*;

public class SelfPriorityQueue {
	 PriorityQueue<Integer> pq;
	int capacity = 0;
	 SelfPriorityQueue(int capacity){
		 pq = new PriorityQueue<Integer>(capacity);
		 this.capacity = capacity;
	 }
	 
	 int getMin(){
		 return this.pq.peek();
	 }
	 
	 void removeMin() {
		 pq.remove(getMin());
	 }
	 
	 void add(int val) {
		 
		if(!pq.isEmpty() && (pq.size() >= this.capacity) && (val > this.getMin())) {
				 removeMin();
				 pq.add(val);
		 }
		else if(pq.size() < this.capacity) { pq.add(val);}
	 }
}
