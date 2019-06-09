package PracticeProblems;

import java.util.*;

public class L49 {
	ArrayList<Boolean> usedHash = null;
	public List<List<String>> groupAnagrams(String[] strs1) 
	{
		List<List<String>> List = new ArrayList<List<String>>();
		usedHash = new ArrayList<Boolean>();
		int n = strs1.length;
		String[] strs = new String[n]; 
		for(int i=0; i<n;i++)
		{
			strs[i] = sortString(strs1[i]);
			usedHash.add(true);
		}
		
		for(int i=0;i<n;i++) {
			if(usedHash.get(i)) {
				ArrayList<String> anagrams = new ArrayList<String>();
				anagrams.add(strs1[i]);
				usedHash.set(i, false);
				for(int j=i+1; j<n; j++)
				{
					if(usedHash.get(j) && strs[i].equals(strs[j])) 
					{
						anagrams.add(strs1[j]);
						usedHash.set(j, false);
					}
				}
				List.add(anagrams);
			}
		}
		//printList(List);
		return List;
    }
	public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    }
	private void printList(List<List<String>> list) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++) {
			List<String> arr = list.get(i);
			System.out.print("[");
			for(int j=0; j<arr.size();j++)
			{
				System.out.print(arr.get(j)+", ");
			}
			System.out.println("]");
		}
	}
	
}
