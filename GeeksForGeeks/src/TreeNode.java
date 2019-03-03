

public class TreeNode<T>
{
	public T val;
	public TreeNode<T> Left=null;
	public TreeNode<T> Right=null;
	
	TreeNode(T val)
	{
		this.val=val;
		
	}
	TreeNode(T val, TreeNode<T> Left, TreeNode<T> Right)
	{
		this.val=val;
		this.Left=Left;
		this.Right=Right;
	}
}

