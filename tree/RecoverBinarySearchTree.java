package tree;

public class RecoverBinarySearchTree {
	/**
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	
	Recover the tree without changing its structure.
	
	Note:
	A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
	 */
	public void recoverTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        TreeNode leftMax;
		TreeNode rightMin;
        if(root.left == null){
        	rightMin = minNode(root.right);
        	if(root.val < rightMin.val){
        		recoverTree(root.right);
        	}else{
        		swap(root, rightMin);
        	}
        }else if(root.right == null){
        	leftMax = maxNode(root.left);
        	if(leftMax.val < root.val){
        		recoverTree(root.left);
        	}else{
        		swap(root, leftMax);
        	}
        }else{
        	leftMax = maxNode(root.left);
        	rightMin = minNode(root.right);
        	if(leftMax.val < root.val && root.val < rightMin.val){
        		recoverTree(root.left);
        		recoverTree(root.right);
        	}else if(leftMax.val < root.val){
        		swap(root, rightMin);
        	}else if(root.val <rightMin.val){
        		swap(root, leftMax);
        	}else{
        		swap(leftMax, rightMin);
        	}
        }
		
    }
	public void recoverTree2(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        TreeNode leftMax = maxNode(root.left);
		TreeNode rightMin = minNode(root.right);
        if(leftMax == null){
        	if(root.val > rightMin.val){
        		swap(root, rightMin);
        	}else{
        		recoverTree2(root.right);
        	}
        }else if(rightMin == null){
        	if(leftMax.val > root.val){
        		swap(root, leftMax);
        	}else{
        		recoverTree2(root.left);
        	}
        }else{
        	if(leftMax.val > rightMin.val){
        		swap(leftMax, rightMin);
        	}else if(leftMax.val > root.val){
        		swap(root, leftMax);
        	}else if(root.val > rightMin.val){
        		swap(root, rightMin);
        	}else{
        		recoverTree2(root.left);
        		recoverTree2(root.right);
        	}
        }
		
    }
	TreeNode maxNode(TreeNode root){
		if(root == null) return null;
		TreeNode left = maxNode(root.left);
		TreeNode right = maxNode(root.right);
		TreeNode max = root;
		if(left != null){
			max = max.val > left.val ? max : left;
		}
		if(right != null){
			max = max.val > right.val ? max : right;
		}
		return max;
	}
	TreeNode minNode(TreeNode root){
		if(root == null) return null;
		TreeNode left = minNode(root.left);
		TreeNode right = minNode(root.right);
		TreeNode min = root;
		if(left != null){
			min = min.val < left.val ? min : left;
		}
		if(right != null){
			min = min.val < right.val ? min : right;
		}
		return min;
	}
	void swap(TreeNode a, TreeNode b){
		int m = a.val;
		a.val = b.val;
		b.val = m;
	}
	public void recoverTree_MorrisTraversal(TreeNode root) {
		TreeNode cur = root, pre = null, preVisit = null;
		TreeNode x = null, y = null, xNext = null;
		while(cur != null){
			if(cur.left == null){
				//
				if(preVisit != null && preVisit.val > cur.val){
					if(x == null){
						x = preVisit;
						xNext = cur;
					}else{
						y = cur;
					}
				}
				preVisit = cur;
				cur = cur.right;
			}else{
				pre = cur.left;
				while(pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}else{
					//
					if(preVisit != null && preVisit.val > cur.val){
						if(x == null){
							x = preVisit;
							xNext = cur;
						}else{
							y = cur;
						}
					}
					preVisit = cur;
					pre.right = null;
					cur = cur.right;
				}
			}
		}
		if(y != null){
			swap(x, y);
		}else{
			swap(x, xNext);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecoverBinarySearchTree s = new RecoverBinarySearchTree();
		TreeNode t0 = Tree.createTree(5,3,7,2,4,6,8,1);
		TreeNode t1 = Tree.createTree(5,3,7,2,6,4,8,1);
		TreeNode t2 = Tree.createTree(5,7,3,2,4,6,8,1);
		TreeNode t3 = Tree.createTree(2,3,7,5,4,6,8,1);
		TreeNode t4 = Tree.createTree(5,3,7,2,4,6,1,8);
		s.recoverTree2(t1);
		s.recoverTree_MorrisTraversal(t2);
		s.recoverTree_MorrisTraversal(t3);
		s.recoverTree_MorrisTraversal(t4);
		Tree.visitByLevel(t1);
		Tree.visitByLevel(t2);
		Tree.visitByLevel(t3);
		Tree.visitByLevel(t4);
	}

}
