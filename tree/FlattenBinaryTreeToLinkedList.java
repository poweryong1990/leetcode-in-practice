package tree;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	/**
	 * Given a binary tree, flatten it to a linked list in-place.
	
	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
	 */
	public void flatten(TreeNode root) {
		if(root == null) return;
		TreeNode parent;
		TreeNode right = root.right;
		if(root.left != null){
			parent = helper(root, root.left);
			root.left = null;
		}else{
			parent = root;
		}
		if(right != null){
			helper(parent, right);
		}
    }
	TreeNode helper(TreeNode parent, TreeNode root){
		parent.right = root;
		TreeNode right = root.right;
		if(root.left != null){
			parent = helper(root, root.left);
			root.left = null;
		}else{
			parent = root;
		}
		if(right != null){
			parent = helper(parent, right);
		}
		return parent;
	}
	public void flatten_Stack(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode pre = new TreeNode(0);
		while(!stack.isEmpty()){
			TreeNode p = stack.pop();
			pre.right = p;
			pre = p;
			if(p.right != null){
				stack.push(p.right);
				p.right = null;
			}
			if(p.left != null){
				stack.push(p.left);
				p.left = null;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlattenBinaryTreeToLinkedList s = new FlattenBinaryTreeToLinkedList();
		TreeNode t = Tree.createTree(1,2,5,3,4,-1,6);
		s.flatten_Stack(t);
		TreeNode p = t;
		while(p != null){
			System.out.print("->" + p.val);
			p = p.right;
		}
		System.out.println();
		
		t = Tree.createTree(1,2);
		s.flatten_Stack(t);
		p = t;
		while(p != null){
			System.out.print("->" + p.val);
			p = p.right;
		}
		System.out.println();
	}

}
