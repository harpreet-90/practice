import java.util.*;

public class LRUCache {
	
	Deque<Integer> list;
	int capacity;
	LRUCache(int capacity){
		this.capacity = capacity;
		list = new LinkedList();
	}
	void refer(int val) {
		if(list.contains(val)) {
			list.remove(val);
			list.addFirst(val);
			return;
		}
		if((list.size() < this.capacity))
		{
				list.addFirst(val);
		}
		else 
		{
			list.removeLast();
			list.addFirst(val);
		}
	}
	
	void display() {
		Iterator i = list.iterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}
}
