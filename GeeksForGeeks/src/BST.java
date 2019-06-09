import java.util.*;

public class BST {
	ArrayList<Integer> preOrder;
	ArrayList<Integer> inOrder;
	int pIdx = 0;
	BSTNode root = null;

	BST(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
		this.preOrder = preOrder;
		this.inOrder = inOrder;
	}

	BST() {

	}

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

	void balanceInsert(int val) {
		this.root = balanceInsert(this.root, val);
	}

	BSTNode balanceInsert(BSTNode root, int val) {
		BSTNode newNode = new BSTNode(val);

		if (root == null) {
			root = newNode;
			return root;
		}
		if (val < root.data) {
			root.left = balanceInsert(root.left, val);
			if (diff(root.right, root.left) == 2) {
				if (val < root.left.data) {
					root = singleRotateLeft(root);
				} else {
					root = doubleRotateLeft(root);
				}
			}
		} else {
			root.right = balanceInsert(root.right, val);
			if (diff(root.right, root.left) == 2) {
				if (val > root.right.data) {
					root = singleRotateRight(root);
				} else {
					root = doubleRotateRight(root);
				}
			}
		}

		root.height = 1 + maxHeight(root.right, root.left);

		return root;
	}

	int maxHeight(BSTNode node1, BSTNode node2) {
		int max = 0;
		if (node1 != null) {
			max = node1.height;
		}
		if (node2 != null && max < node2.height) {
			max = node2.height;
		}
		return max;
	}

	int diff(BSTNode node1, BSTNode node2) {
		int val1 = 0, val2 = 0, diff = 0;
		if (node1 != null) {
			val1 = node1.height;
		}
		if (node2 != null) {
			val2 = node2.height;
		}
		if (val1 > val2) {
			diff = val1 - val2;
		} else {
			diff = val2 - val1;
		}
		return diff;
	}

	private BSTNode doubleRotateRight(BSTNode root) {
		if (root == null)
			return null;
		root.right = singleRotateLeft(root.right);
		return singleRotateRight(root);
	}

	private BSTNode singleRotateRight(BSTNode root) {
		if (root == null)
			return null;
		BSTNode w = root.right;
		root.right = w.left;
		w.left = root;
		root.height = 1 + maxHeight(root.left, root.right);
		return w;
	}

	private BSTNode doubleRotateLeft(BSTNode root) {
		if (root == null)
			return null;
		root.left = singleRotateRight(root.left);
		return singleRotateLeft(root);
	}

	private BSTNode singleRotateLeft(BSTNode root) {
		if (root == null)
			return null;
		BSTNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.height = 1 + maxHeight(root.left, root.right);
		return newRoot;
	}

	void delete(int val) {
		this.root = delete(this.root, val);
	}

	private BSTNode delete(BSTNode root, int val) {

		if (root == null)
			return root;

		if (val < root.data) {
			root.left = delete(root.left, val);
		} else if (val > root.data) {
			root.right = delete(root.right, val);
		} else {
			if (root.left != null && root.right != null) {
				BSTNode temp = findMax(root.left);
				root.data = temp.data;
				root.left = delete(root.left, temp.data);
			} else {
				if (root.left == null) {
					root = root.right;
				} else {
					root = root.left;
				}
			}
		}

		return root;
	}

	boolean find(int val) {
		return find(this.root, val);
	}

	boolean find(BSTNode root, int val) {
		if (root == null)
			return false;
		if (val == root.data)
			return true;
		if (val < root.data) {
			return find(root.left, val);
		} else {
			return find(root.right, val);
		}
	}

	BSTNode findMax(BSTNode root) {
		if (root == null)
			return root;
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	BSTNode findMin(BSTNode root) {
		if (root == null)
			return root;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	void inOrderTrav() {
		inOrderTrav(this.root);
	}

	void inOrderTrav(BSTNode root) {
		if (root == null)
			return;

		inOrderTrav(root.left);
		System.out.print(root.data + " ");

		inOrderTrav(root.right);
	}

	void preOrderTrav() {
		preOrderTrav(this.root);
	}

	void preOrderTrav(BSTNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");

		preOrderTrav(root.left);
		preOrderTrav(root.right);
	}

	void postOrderTrav() {
		postOrderTrav(this.root);
	}

	void postOrderTrav(BSTNode root) {
		if (root == null)
			return;

		postOrderTrav(root.left);
		postOrderTrav(root.right);

		System.out.print(root.data + " ");
	}

	int height = 3;

	void levelOrderTrav() {
		if (this.root == null)
			return;

		LinkedList<BSTNode> queue = new LinkedList<BSTNode>();
		queue.addFirst(null);
		queue.addFirst(this.root);

		while (!queue.isEmpty()) {
			BSTNode queueNode = queue.removeLast();
			if (queueNode == null) {
				if (!queue.isEmpty()) {
					queue.addFirst(null);
					System.out.println();
					queueNode = queue.removeLast();
				} else {
					return;
				}
			}
			if (queueNode.left != null) {
				queue.addFirst(queueNode.left);
			}
			if (queueNode.right != null) {
				queue.addFirst(queueNode.right);
			}
			System.out.print(queueNode.data + "\t");
		}
	}

	boolean isBST() {
		MaxMinPair mm = isBST(this.root);
		if (mm == null)
			return false;
		return mm.status;
	}

	MaxMinPair isBST(BSTNode root) {
		if (root == null)
			return null;
		MaxMinPair mm = new MaxMinPair();

		MaxMinPair left = isBST(root.left);
		MaxMinPair right = isBST(root.right);

		mm = findMaxMinStatus(root, left, right);
		return mm;
	}

	private MaxMinPair findMaxMinStatus(BSTNode root, MaxMinPair left, MaxMinPair right) {
		if (root == null)
			return null;

		MaxMinPair mm = new MaxMinPair();

		mm.max = root.data;
		mm.min = root.data;
		if ((left != null) && (right != null)) {
			mm.status = true;
			return mm;
		}

		mm.min = (left != null && left.min < mm.min) ? left.min : mm.min;
		mm.min = (right != null && right.min < mm.min) ? right.min : mm.min;

		mm.max = (left != null && left.max < mm.max) ? left.max : mm.max;
		mm.max = (right != null && right.max < mm.max) ? right.max : mm.max;

		mm.status = (left != null) ? left.status : false;
		mm.status = (right != null && right.status == false) ? right.status : mm.status;

		return mm;
	}

	void leftViewOfTree() {
		if (this.root == null)
			return;

		LinkedList<BSTNode> queue = new LinkedList<BSTNode>();
		queue.addFirst(null);
		queue.addFirst(this.root);
		boolean flag = true;
		while (!queue.isEmpty()) {

			BSTNode queueNode = queue.removeLast();
			if (queueNode == null) {
				if (!queue.isEmpty()) {
					queue.addFirst(null);
					flag = true;
					System.out.println();
					queueNode = queue.removeLast();
				} else {
					return;
				}
			}
			if (queueNode.left != null) {
				queue.addFirst(queueNode.left);
			}
			if (queueNode.right != null) {
				queue.addFirst(queueNode.right);
			}
			if (flag == true) {
				System.out.print(queueNode.data + " ");
				flag = false;
			}
		}
	}

	void bstToDll() {
		DoublyLinkedList dll = bstToDll(this.root);
		dll.printDll(Direction.FORWARD);
	}

	DoublyLinkedList bstToDll(BSTNode root) {
		if (root == null)
			return null;

		DoublyLinkedList dll = new DoublyLinkedList();

		DoublyLinkListNode newNode = new DoublyLinkListNode(root.data);

		dll.insert(newNode);

		DoublyLinkedList prev = bstToDll(root.left);
		DoublyLinkedList next = bstToDll(root.right);
		if (prev != null) {
			dll = prev.append(dll);
		}
		if (next != null) {
			dll = dll.append(next);
		}
		return dll;

	}

	void printDll(DoublyLinkListNode start) {
		if (start == null)
			return;
		DoublyLinkListNode trav = start;
		while (trav != null) {
			System.out.print(trav.value + " ");
			trav = trav.next;
		}
	}

	void BSTfromPreOrder() {
		this.root = BSTfromPreOrder(0, 5);
	}

	BSTNode BSTfromPreOrder(int inIdxLeft, int inIdxRight) {

		int length = this.preOrder.size();
		if (length == 0 || pIdx >= length) {
			return null;
		}
		int rootIdx;
		BSTNode left = null, right = null;
		rootIdx = this.inOrder.indexOf(preOrder.get(pIdx));

		if (inIdxLeft <= rootIdx - 1) {
			pIdx++;
			left = BSTfromPreOrder(inIdxLeft, rootIdx - 1);
		}
		if (inIdxRight >= rootIdx + 1) {
			pIdx++;
			right = BSTfromPreOrder(rootIdx + 1, inIdxRight);

		}
		BSTNode root = new BSTNode(inOrder.get(rootIdx));
		root.left = left;
		root.right = right;

		return root;
	}
	BSTNode findDataNode(BSTNode root, int data){
		if(root == null) return null;
		if(root.data == data) {
			return root;
		}
		BSTNode left = findDataNode(root.left, data);
		if(left != null) 
		{
			return left;
		}
		else {
			return findDataNode(root.right, data);
		}
		
	}
	void printReverseTreePathUtil(BSTNode root, int data) {
		
		if(root == null) return;
		
		BSTNode nodeToSwap = findDataNode(root, data);
		
		if(nodeToSwap == null) {
			System.out.println("invalid data");
			return;
		}
		
		NodePair np = swap(root, nodeToSwap);
		root = np.a;
		nodeToSwap = np.b;
		preOrderTrav(root);
	}
	
	NodePair swap(BSTNode a, BSTNode b) {
		if(a == null || b == null) return null;
		int c = a.data;
		a.data = b.data;
		b.data = c;
		return new NodePair(a,b);
	}
	// find minimum distance between two nodes
	
	int findDistanceInTwoNodes(int node1, int node2) {
		BSTNode lca = LcaInBst(this.root, node1, node2);
		System.out.println(lca.data);
		if(lca.data == node1) {
			return findDistanceInParentChild(lca, new BSTNode(node1));
		}
		int dist1 = findDistanceInParentChild(lca, new BSTNode(node1));
		int dist2 = findDistanceInParentChild(lca, new BSTNode(node2));
//		System.out.println(dist1);
//		System.out.println(dist2);
		if(dist1 == -1 || dist2 == -1)
			return -1;
		else
			return (dist1+dist2-1);
	}
	
	
	
	/// distance between parent and child node in BST
	int findDistanceInParentChild(BSTNode parent, BSTNode child) {
		if(parent == null || child == null) return 0;
		if(parent.data == child.data) return 1;
		int count = 0;
		
		if(child.data < root.data) {
			count = findDistanceInParentChild(parent.left, child) ;
		}
		else {
			count = findDistanceInParentChild(parent.right, child);
		}
		if(count == -1)
			return count;
		else
			return ++count;
	}
	
	// Least Common Ancestors in BST
	
	void LCAinBST(int a, int b) {
		BSTNode lca = null;
		if(find(this.root, a) && find(this.root, b)) {
			lca = LcaInBst(this.root, a, b);
		}
		if(lca != null) {
			System.out.println(lca.data);
		}
	}

	private BSTNode LcaInBst(BSTNode root, int a, int b) {
		if(root == null) return null;
		if(root.data <a && root.data < b) {
			return LcaInBst(root.right, a, b); 
		}
		if(root.data > a && root.data > b) {
			return LcaInBst(root.left, a, b);
		}
		else {
			return root;
		}
	}
	
	
	boolean eachNodeHasOneChild(BSTNode root) {
		if(root == null) return true;
		if(root.left == null || root.right == null) {
			return eachNodeHasOneChild(root.left) && eachNodeHasOneChild(root.right);
		}
		else return false;
	}
	
	int findTotalNodeInTree(BSTNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int count = 0 ;
		count = findTotalNodeInTree(root.left);
		count += findTotalNodeInTree(root.right);
		
		return ++count;
	}
	
	int markCount(BSTNode root, int count) {
		if (root == null)
			return 0;
		if(root.left == null && root.right == null) return 1;
		
		count += markCount(root.left, count);
		
		root.count = count + 1; 
		count += markCount(root.right, count);
		return count;
	}
	
	void findKthLargestNoInBST(int k) {
		count = 0;
		int total = findTotalNodeInTree(this.root);
		k = total - k;
		findKthLargestNoInBST(this.root, k);
	}
	
	int count =0;
	void findKthLargestNoInBST(BSTNode root, int k) {
		if(root == null) return;
		
		//count left nodes
		findKthLargestNoInBST(root.left, k);
		// count root node
		count++;
		if(count == k) {
			System.out.println(root.data +" islasrgest no.");
			return;
		}
		// count right nodes
		findKthLargestNoInBST(root.right,k);
	}
	int idx=0;
	boolean checkSortedSequence(int[] seq) {
		idx=0;
		return checkSortedSequence(this.root,seq);
	}

	private boolean checkSortedSequence(BSTNode root, int[] seq) {
		if(root == null) return false;
		
		boolean leftSideStatus = checkSortedSequence(root.left, seq);
		if(idx >= seq.length) return true;
		if(root.data == seq[idx]) {
			idx++;
		}
		
		
		boolean rightSideStatus = checkSortedSequence(root.right, seq);
		
		return leftSideStatus || rightSideStatus;
	}
	
	int findMaxforN(BSTNode root, int min, int n) {
		if(root == null) return -1;
		
		if(n < root.data){
			min = Math.max(findMaxforN(root.left, min, n), min);
		}
		else if(n == root.data) return root.data;
		else {
			if(min < root.data) {
				min = root.data;
			}
			min = Math.max(findMaxforN(root.right, min,n), min);
		}
		return min;
	}
	
	int countBSTSubTreesInRange(BSTNode root, int minR, int maxR) {
		if(root == null) return 0;
		int count = 0;
		count += countBSTSubTreesInRange(root.left, minR, maxR);
		
		count += checkRootChildsInRange(root, minR, maxR) ? 1 : 0;
		
		count += countBSTSubTreesInRange(root.right, minR, maxR);
		return count;
	}

	private boolean checkRootChildsInRange(BSTNode root, int minR, int maxR) {
		if(root == null ) return false;
		if(root.data >= minR && root.data <= maxR) {
			if(root.left == null && root.right == null) return true;
			boolean left = (root.left == null) ? true : false ;
			if(root.left != null && root.left.data >= minR && root.left.data <= maxR) {
				left =  true;
			}
			boolean right = (root.right == null) ? true : false ;
			if(root.right != null && root.right.data >= minR && root.right.data <= maxR) {
				right =  true;
			}
			return left && right;
		}
		return false;
	}
	
	
	MaxMinPairNode1 correctDistortedBST(BSTNode root) {
		if (root == null)
			return null;
		MaxMinPairNode1 mm = new MaxMinPairNode1();

		MaxMinPairNode1 left = correctDistortedBST(root.left);
		MaxMinPairNode1 right = correctDistortedBST(root.right);

		mm = findMaxMinStatusNode(root, left, right);
		return mm;
	}

	private MaxMinPairNode1 findMaxMinStatusNode(BSTNode root, MaxMinPairNode1 left, MaxMinPairNode1 right) {
		if (root == null)
			return null;

		MaxMinPairNode1 mm = new MaxMinPairNode1();

		mm.max = root;
		mm.min = root;
		if ((left != null) && (right != null)) {
			mm.status = true;
			return mm;
		}

		mm.min = (left != null && left.min.data < mm.min.data) ? left.min : mm.min;
		mm.min = (right != null && right.min.data < mm.min.data) ? right.min : mm.min;

		mm.max = (left != null && left.max.data < mm.max.data) ? left.max : mm.max;
		mm.max = (right != null && right.max.data < mm.max.data) ? right.max : mm.max;

		mm.status = (left != null) ? left.status : false;
		mm.status = (right != null && right.status == false) ? right.status : mm.status;

		if(mm.status == false)
		{
			//this data in node is incorrect and these nodes are actually in wrong position.
			// We've to swap these nodes or data in these nodes
			
			
		}
		return mm;
	}

	
	
	
}

class NodePair{
	BSTNode a;
	BSTNode b;
	
	NodePair(BSTNode a,BSTNode b){
		this.a = a;
		this.b = b;
	}
}

class MaxMinPairNode{
	BSTNode a;
	
}