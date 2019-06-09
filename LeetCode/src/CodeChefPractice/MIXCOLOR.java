package CodeChefPractice;

import java.util.*;

public class MIXCOLOR {
	public void mixColor()
	{

		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		long[] colors;
		TreeMap<Long, Long> hash;
		for(long i=0; i<t; i++)
		{
			hash = new TreeMap<Long, Long>();
			
			long colorCount = sc.nextLong();
			hash.put(sc.nextLong(), (long) 1);
			Long color = (long)0;
			for(long j=1; j<colorCount; j++)
			{
				color = sc.nextLong();
				if(hash.containsKey(color) == true)
				{
//					hash.put(color, hash.get(color)+1);
					hash.replace(color, hash.get(color)+1);
				}
				else
				{
					hash.put(color, (long)1);
				}
			}
			
			int mixingCount = 0;
			Set set = hash.entrySet();
		    Iterator it = set.iterator();
		    while(it.hasNext()) 
		    {
		      Map.Entry me = (Map.Entry)it.next();
		      
		      long val = (long) me.getValue();
			  mixingCount += (val-1); 
		    }
		    
		    System.out.println(mixingCount);
		}
		  
	}
}
