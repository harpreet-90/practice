package PracticeProblems;

public class L114 {
	public void flatten(TreeNode root) 
	{
		root = flatten1(root);
    }
	
	TreeNode flatten1(TreeNode root)
	{
		if(root == null) return null;
		if(root.left==null && root.right==null) return root;
		
		TreeNode Left = flatten1(root.left);
		TreeNode Right = flatten1(root.right);
		TreeNode tempLeft = Left;
		root.left =null;
		root.right = Left;
		while(tempLeft != null && tempLeft.right != null)
		{
			tempLeft = tempLeft.right;
		}
		if(tempLeft==null) root.right = Right;
		else tempLeft.right.right = Right;
		return root;
	}
	
}
