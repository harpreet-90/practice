import java.util.LinkedList;

class AdjacencyMatrix{
	int matrix[][];
	int vertexCount;
	
	AdjacencyMatrix(int vertexCount){
		this.vertexCount = vertexCount;
		matrix = new int[this.vertexCount][this.vertexCount];
		for(int row=0; row<this.vertexCount; row++){
			for(int col=0;col<this.vertexCount; col++){
				matrix[row][col] = 0;
			}
		}
	}
	
	void addEdge(int src, int dest){
		matrix[src][dest] = 1;
		matrix[dest][src] = 1;
	}
	
	void BFS()
	{
		if(this.vertexCount == 0) return;
		
		boolean visited[] = new boolean[this.vertexCount];
		LinkedList queue = new LinkedList();
		
		for(int v=0; v<this.vertexCount; v++)
		{
			int startVertex;
			if(!visited[v]){
				queue.add(v);
				visited[v] = true;
			}
			
			while(!queue.isEmpty()){
				startVertex = (int) queue.remove();
				System.out.print(startVertex + " " );
				
				for(int connectedVertex=0; connectedVertex<this.vertexCount;connectedVertex++)
				{
					if(visited[connectedVertex] && matrix[startVertex][connectedVertex] != 0){
						queue.add(connectedVertex);
						visited[connectedVertex] = true;
					}
				}
			}
		
		}
	
	}


}
