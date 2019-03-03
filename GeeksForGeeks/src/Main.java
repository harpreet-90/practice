import java.util.*;

public class Main {
	final int VERTEX_COUNT = 2000;
	public static void main(String[] args)
	{
		ArrayUtils au = new ArrayUtils();
		int[] arr = {2,4,0,6};
		au.nextGreatorElement(arr);
//		au.printArray(arr);
//		int[][] arr = {{1, 2},{2, 4},{ 3, 5}};
//		System.out.println(au.searchInSortedMatrix(arr, 3, 2, 5));
//		System.out.println(au.searchInSortedMatrix(arr, 3, 2, 9));
//		System.out.println(au.searchInSortedMatrix(arr, 3, 2, 4));
//		System.out.println(au.searchInSortedMatrix(arr, 3, 2, 6));
	}
}

//Scanner sc = new Scanner(System.in);
//int k = sc.nextInt();
//SelfPriorityQueue spq =  new SelfPriorityQueue(k);
//int arr[] =  {10, 20, -11, -70, 50, 40, 100, 5} ;
//int length = arr.length;
//for(int i=0; i<length; i++) {
//	spq.add(arr[i]);
//}
//System.out.println(spq.getMin());
//NQUEEN nqueen= new NQUEEN(30);
//MyNode Root = new MyNode(1);
//Root.Left= new MyNode(2);
//Root.Right= new MyNode(3);
//(Root.Left).Left= new MyNode(4);
//(Root.Right).Left= new MyNode(5);
//(Root.Left).Right= new MyNode(6);
//(Root.Right).Right= new MyNode(7);
//((Root.Left).Left).Left= new MyNode(8);
//((Root.Right).Right).Left= new MyNode(9);
//int[] NegArray = new int[10];
//int[] PosArray = new int[10];
//for(int i=0;i<10;i++)
//{
//	NegArray[i]=0;
//	PosArray[i]=0;
//}
//
//VerticalSum vs= new VerticalSum();
//vs.FindVerticalSum(Root, NegArray, PosArray, 0);
//for(int i=9;i>=0;i--)
//{
//	if(NegArray[i] !=0) {
//		System.out.println("sum of col -"+i+" : "+NegArray[i]);
//	}
//	if(PosArray[i] !=0) {
//		System.out.println("sum of col "+i+" : "+PosArray[i]);
//	}
//}
