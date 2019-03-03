import java.io.*; 
import java.util.*; 
public class Graph {
	int vertexCount;
	LinkedList[] graph;
	
	public Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		graph = new LinkedList[this.vertexCount];
		
		for(int i=0; i< this.vertexCount; i++) {
			graph[i] = new LinkedList();
		}
	}
	
	void addEdge(int src, int dest) {
		graph[src].add(dest);
		graph[dest].add(src);
	}
	
	void printList(int i)
	{
		Iterator<Integer> it = graph[0].iterator();
		while(it.hasNext()) {
			
		}
	}
	

	void BFS() {
		// visited mark
		// put start in queue
		// whlie (queue not empty)
		// if q not visited add adjecent to Queue 
		
		
		boolean visited[] = new boolean[this.vertexCount];
		
		for(int i=0; i<this.vertexCount; i++) {
			visited[i] = false;
		}
		
		
		for(int start=0; start <this.vertexCount; start++)
		{
			LinkedList queue = new LinkedList();
			if(visited[start] == false)
			{
				queue.add(start);
				visited[start] = true;
				System.out.println("\nNew Connected Component");
			}
			while(!queue.isEmpty()) {
				 start =(int) queue.remove(); 
				 System.out.print(start + " ");
				 Iterator<Integer> i = graph[start].listIterator();
				 while(i.hasNext()) {
					 int val=  i.next();
					 if(!visited[val]) {
						 queue.add(val);
						 visited[val]= true;
					 }
				 }
			}
		}
	}
	//DFSUtils()
	void DFS() {
		boolean visited[] = new boolean[this.vertexCount];
		LinkedList stack = new LinkedList();
		int startVertex;
		for(int v=0; v<this.vertexCount; v++) {
			visited[v] = false;
		}
		
		for(int v=0; v<this.vertexCount; v++) {
			if(!visited[v]) {
				startVertex = v;
				visited[startVertex] = true;
				stack.push(startVertex);
			}
			
			while(!stack.isEmpty()) {
				startVertex = (int) stack.pop();
				System.out.print(startVertex + " ");
				Iterator vi = graph[startVertex].iterator();
				
				while(vi.hasNext()) {
					int connectedVertex = (int) vi.next();
					if(!visited[connectedVertex]) {
						stack.push(connectedVertex);
						visited[connectedVertex] = true; 
					}
				}
			}
			
		}
	}
}
