import java.util.Hashtable;

class NQUEEN {

	public boolean arr[][];
	private int n;
	private Hashtable<Integer,Boolean> uperDiagonal=new Hashtable<Integer,Boolean>();  
	private Hashtable<Integer,Boolean> LowerDiagonal=new Hashtable<Integer,Boolean>();
	private Hashtable<Integer,Boolean> Row=new Hashtable<Integer,Boolean>();
	private Hashtable<Integer,Boolean> Col=new Hashtable<Integer,Boolean>();
	
	public NQUEEN(int n)
	{
		this.n=n;
		if(n <=3)
		{
			System.out.println("Not Possible to adjust");
			return;
		}
		arr = new boolean[n][n];
		for(int i=0; i<n ;i++)
		{
			for(int j=0; j<n; j++)
			{
				arr[i][j]= false;
			}
		}
		
		if(n_queen(n,0,0))
		{
			//print array
			for(int i=0; i<n ;i++)
			{
				for(int j=0; j<n; j++)
				{
					System.out.print((arr[i][j]) ? 1:0);
				}
				System.out.println();
			}
			
		}
		
	}
	
	boolean n_queen(int n, int counter, int i)
	{
		if(counter == n)
		{
			return true;
		}
		for(int j=0;j<n;j++)
		{
			if(safeToPlace(i,j))
			{
				arr[i][j]= true;
				uperDiagonal.put((i+j), true);
				LowerDiagonal.put((n+(i-j)), true);
				Row.put(i, true);
				Col.put(j, true);
				if(n_queen(n,counter+1, i+1))
				{
					
					return true;
				}
				else
				{
					arr[i][j] = false;
					uperDiagonal.put((i+j), false);
					LowerDiagonal.put((n+(i-j)), false);
					Row.put(i, false);
					Col.put(j, false);
				}
					
			}
		}
			
		return false;
	}

	private boolean safeToPlace(int i, int j) {
		// TODO Auto-generated method stub
		if(((Row.contains(i)== false) || (Row.containsKey(i) && Row.get(i)== false)) 
				&& ((Col.containsKey(j)==false) ||((Col.containsKey(j)==true) && Col.get(j)== false)) && (uperDiagonal.containsKey(i+j)==false ||( uperDiagonal.containsKey(i+j) && uperDiagonal.get(i+j)== false)) && (LowerDiagonal.containsKey(n+i-j)==false || (LowerDiagonal.containsKey(n + i-j) && LowerDiagonal.get(n+ i-j)== false)))
		{
			return true;
		}
		
		return false;
	}
}
