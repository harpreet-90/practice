import java.util.*;

public class BinaryTree extends BST {

	BSTNode root = null;

	void insert(int val) {
		this.root = insert(this.root, val);
	}

	private BSTNode insert(BSTNode root, int val) {
		BSTNode newNode = new BSTNode(val);

		if (root == null) {
			root = newNode;
			return root;
		}
		if (val < root.data) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}

	ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

	void diagonalTrav() {
		arr.add(0, new ArrayList<Integer>());
		diagonalTrav(this.root, 0);

		Iterator outerIterator = arr.iterator();
		while (outerIterator.hasNext()) {
			Iterator innerIterator = ((ArrayList<ArrayList<Integer>>) outerIterator.next()).iterator();
			while (innerIterator.hasNext()) {
				System.out.print(innerIterator.next() + " ");
			}
			System.out.println();
		}
	}

	private void diagonalTrav(BSTNode root, int count) {
		if (root == null)
			return;
		ArrayList<Integer> tempArr = new ArrayList<Integer>();
		tempArr.add(root.data);
		if (arr.size() <= count)
			arr.add(count, new ArrayList<Integer>());
		arr.get(count).addAll(tempArr);
		diagonalTrav(root.right, count);
		diagonalTrav(root.left, ++count);
	}

	int diameterOfTree() {
		if (root == null)
			return 0;

		BSTNode trav = this.root;
		int max = 0, curDia = 0;

		Deque<BSTNode> q = new LinkedList<BSTNode>();

		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			trav = q.remove();

			if (trav == null) {
				if (max < curDia) {
					max = curDia;
				}
				// System.out.println();
				curDia = 0;
				if (!q.isEmpty())
					q.add(null);
			} else {
				curDia++;
				// System.out.print(trav.data + " ");
				if (trav.left != null) {
					q.add(trav.left);
				}
				if (trav.right != null) {
					q.add(trav.right);
				}
			}

		}
		return max;
	}
	
	void printBoundaryOfTree() {
		
		printLeftBoundary(this.root);
		
		printLeafNodes(this.root);
		
		printRightBoundary(this.root);
		
	}

	
	private void printRightBoundary(BSTNode root) {
		if(root == null) return;
		printRightBoundary(root.right);
		if(root.left != null && root.right != null)
		{
			System.out.print(root.data +" ");
		}
		
	}

	private void printLeftBoundary(BSTNode root) {
		if(root == null) return;
		
		if(root.left != null && root.right != null)
		{
			System.out.print(root.data +" ");
		}
		printLeftBoundary(root.left);
	}

	private void printLeafNodes(BSTNode root) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			System.out.print(root.left);
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);
		
	}
	
	boolean ifTwoTreesAreMirror(BSTNode root1, BSTNode root2) {
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;
		boolean leftSideStatus = false, rightSideStatus = false;
		if(root1.data == root2.data) {
			leftSideStatus = ifTwoTreesAreMirror(root1.left, root2.right);
			rightSideStatus = ifTwoTreesAreMirror(root1.right, root2.left);
			return leftSideStatus &&  rightSideStatus;
		}
		return false;
	}
	Stack<Integer> st = new Stack();
	
	void printPathOfGivenNodeInBT(int val) {
		st.clear();
		boolean result = printPathOfGivenNodeInBT(this.root, val);
		if(result) {
			while(!st.isEmpty()) {
				System.out.print(st.pop() + " ");
			}
		}
		System.out.println();
	}
	
	boolean printPathOfGivenNodeInBT(BSTNode root, int val) {
		if(root == null) return false;
		if(root.data == val) {
			//System.out.print(root.data + " ");
			st.push(root.data);
			return true;
		}
		else 
		{
			boolean leftResult = printPathOfGivenNodeInBT(root.left, val);
			boolean rightResult = printPathOfGivenNodeInBT(root.right, val);
			
			if(leftResult || rightResult) {
				//System.out.print(root.data + " ");
				st.push(root.data);
				return true;
			}
			else {
				return false;
			}
			
		}
	}
	
	
	
	
}
