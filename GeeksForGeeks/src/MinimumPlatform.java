import java.util.*;
class SortString implements Comparator<Pair> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Pair a, Pair b) 
    { 
    	String[] t1 = (a.time).split(":", 2);
    	String[] t2 = (b.time).split(":", 2);
    	if(Integer.parseInt(t1[0]) == Integer.parseInt(t2[0]) ) {
    		return (Integer.parseInt(t1[1]) - Integer.parseInt(t2[1]));
    	}
    	else {
    		return (Integer.parseInt(t1[0]) - Integer.parseInt(t2[0]));
    	}
        
    } 
}
class Pair{
	String time;
	EventType type;
	
	public Pair(String time, EventType type){
		this.time = time;
		this.type = type;
	}
}

enum EventType {
	ARRIVAL,
	DEPARTURE
}

public class MinimumPlatform{

	public int findMinimumPlatform(ArrayList<String> arival, ArrayList<String> dep ) {
		ArrayList<Pair> arr = new ArrayList<Pair>();
		int maxPlatform = 0;
		// Add all the arivals in new array with type arival
		Iterator<String> it = arival.iterator();
		while (it.hasNext()) 
		{
            arr.add(new Pair((String)it.next() , EventType.ARRIVAL));
    	} 
		// Add all the departures in new array with type dep
		it = dep.iterator(); 
		while (it.hasNext()) 
		{
	        arr.add(new Pair((String)it.next() , EventType.DEPARTURE));
	 	} 
		//Sort the array According to the timings
		arr.sort(new SortString());
		int PlatformCount = 0;
		//count minimum Platform required
		Iterator<Pair> pairit = arr.iterator(); 
		while (pairit.hasNext()) 
		{
	       Pair currTime = pairit.next();
	       // if it is train arrival add platform
	       if(currTime.type == EventType.ARRIVAL) {
	    	   PlatformCount++;
	       }
	       // if its train departure remove platform
	       if(currTime.type == EventType.DEPARTURE) {
	    	   PlatformCount--;
	       }
	       // update maximum count
	       if(PlatformCount > maxPlatform) {
    		   maxPlatform = PlatformCount;
    	   }
	 	}
		
		return maxPlatform;
	}

	
}
