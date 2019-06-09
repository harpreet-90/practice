package PracticeProblems;

import java.util.ArrayList;
import java.util.Collections;

public class L4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length) {
			int[] c = nums2;
			nums2 = nums1;
			nums1 = c;
		}
        return findMedianSortedArrays(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
    }
	public double findMedianSortedArrays(int[] a1, int[] a2, int lr1, int rr1, int lr2, int rr2) {
		//if both arrays are of length 0
		if(a1.length == 0 && a2.length == 0) return -1;
		// if one array is of length 0
		if(a1.length == 0)
			return medianOfArray(a2);
		
		int n = (lr1==rr1)? 1 : (rr1-lr1)+1, m = (lr2==rr2)? 1 : (rr2-lr2)+1;
		int midn = (lr1 + rr1)/2;
		int midm = (lr2+rr2)/2;
		// if length of array a1 is 1
		if(n == 1) 
		{
			
			if(m==1)
			{
				return (a1[lr1]+a2[lr2])/2.0;
			}
			if(m==2) 
			{
				return medianOfThree(a1[lr1], a2[lr2], a2[lr2+1]);
			}
			if(m%2 == 0) 
			{
				return medianOfThree(a2[(midm)-1], a2[(midm)], a1[lr1]);
			}
			else 
			{
				int median = medianOfThree(a2[(midm)-1], a2[(midm)+1], a1[0+lr1]);
				return (double)(median+a2[midm])/2.0;
			}
		}
		if(n==2) 
		{
//			if(m==0) 
//			{
//				return medianOfArray(a1);
//			}
//			if(m==1) 
//			{
//				return medianOfThree(a1[lr1], a1[lr1+1], a2[lr2]);
//			}
			if(m==2) 
			{
				return medianOfFour(a1[lr1], a1[lr1+1], a2[lr2], a2[lr2+1]);
			}
			else if(m%2 == 1) 
			{
				//The median is given by median of following three elements: B[M/2], max(A[0], B[M/2 – 1]), min(A[1], B[M/2 + 1]).
				return medianOfThree(a2[(midm)], Math.max(a1[lr1], a2[(midm)-1]), Math.min(a1[lr1+1], a2[(midm)+1] ));
			}
			else 
			{
				//median of following four elements: B[M/2], B[M/2 – 1], max(A[0], B[M/2 – 2]), min(A[1], B[M/2 + 1])
				return medianOfFour(a2[(midm)], a2[(midm)-1], Math.max(a1[lr1],a2[(midm)-1]), a2[(midm)+1]);
			}
			
		}
		else 
		{
			if(a1[midn] == a2[midm]) 
			{
				if((a1.length + a2.length)%2 == 0) {
					return (a1[midn]+a2[midm])/2.0;
				}
				else
					return a1[midn];
			}
			else if(a1[midn] > a2[midm]) 
			{
				if(midn-1 >=0)
				{rr1 = midn-1;}
				if(midm+1 < a2.length)
				lr2 = midm+1;
				
				return findMedianSortedArrays(a1, a2, lr1, rr1, lr2, rr2);
			}
			else 
			{
				if(midn+1 < a1.length)
				{lr1 = midn+1;}
				if(midm-1 >=0)
				{
					rr2 = midm-1;
				}
				return findMedianSortedArrays(a1, a2, lr1, rr1, lr2, rr2);
			}
		}
    }

	private double medianOfFour(int i, int j, int k, int l) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(i);
		a.add(j);
		a.add(k);
		a.add(l);
		Collections.sort(a);
		return (a.get(1)+a.get(2))/2.0;
	}

	private int medianOfThree(int i, int j, int k) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(i);
		a.add(j);
		a.add(k);
		
		Collections.sort(a);
		return a.get(1);
	}

	private double medianOfArray(int[] a) {
		if(a.length == 0) return -1;
		if(a.length == 0) return a[0];
		int mid = a.length/2;
		if(a.length%2 == 0) {
			return (a[mid-1]+a[mid])/2.0;
		}
		else {
			return a[mid];
		}
	}
}
