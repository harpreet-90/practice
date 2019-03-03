public class VerticalSum 
{
	public void FindVerticalSum(MyNode Root, int[] NegArray, int[] PosArray, int RootCol)
	{
		if(Root == null)
		{
			return;
		}
	
		if(RootCol == 0)
		{
			NegArray[RootCol] += Root.value;
			PosArray[RootCol] += Root.value;
		}
		else if(RootCol<0)
		{
			NegArray[(-1)*RootCol] += Root.value;
		}
		else if(RootCol>0)
		{
			PosArray[RootCol] += Root.value;
		}
		
		if(Root.Left != null)
		{
			FindVerticalSum(Root.Left,NegArray,PosArray,RootCol-1);
		}
		
		if(Root.Right != null)
		{
			FindVerticalSum(Root.Right,NegArray,PosArray,RootCol+1);
		}
		
	}

}
