package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
	/**
	 * Given a binary tree, return the preorder traversal of its nodes' values.
	
	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,2,3].
	
	Note: Recursive solution is trivial, could you do it iteratively?
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode t = stack.pop();
        	list.add(t.val);
        	if(t.right != null) stack.push(t.right);
        	if(t.left != null) stack.push(t.left);
        }
        return list;
    }
	public List<Integer> preorderTraversal_without_Stack(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		TreeNode pre, cur = root;
		while(cur != null){
			if(cur.left == null){
				list.add(cur.val);
				cur = cur.right;
			}else{
				pre = cur.left;
				while(pre.right != null && pre.right != cur){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = cur;
					list.add(cur.val);
					cur = cur.left;
				}else{
					pre.right = null;
//					list.add(cur.val);
					cur = cur.right;
					
				}
			}
		}
		return list;
	}
	/**
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null){
        	stack.push(p);
        	p = p.left;
        }
        while(!stack.isEmpty()){
        	TreeNode a = stack.pop();
        	list.add(a.val);
        	p = a.right;
        	while(p != null){
            	stack.push(p);
            	p = p.left;
            }
        }
        return list;
    }
	public List<Integer> inorderTraversal_without_Stack(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		TreeNode pre, cur = root;
		while(cur != null){
			if(cur.left == null){
				list.add(cur.val);
				cur = cur.right;
			}else{
				pre = cur.left;
				while(pre.right != null && pre.right != cur){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}else{
					pre.right = null;
					list.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return list;
	}
	/**
	 * Given a binary tree, return the postorder traversal of its nodes' values.
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode visit = null;
//        while(p != null){
//        	stack.push(p);
//        	if(p.left != null) p = p.left;
//        	else p = p.right;
//        }
//        while(!stack.isEmpty()){
//        	visit = stack.pop();
//        	list.add(visit.val);
//        	if(stack.isEmpty()) break;
//        	p = stack.peek();
//        	if(p.right == visit) continue;
//        	p = p.right;
//        	while(p != null){
//            	stack.push(p);
//            	if(p.left != null) p = p.left;
//            	else p = p.right;
//            }
//        }
        while(p != null || !stack.isEmpty()){
        	while(p != null){
            	stack.push(p);
            	if(p.left != null) p = p.left;
            	else p = p.right;
            }
        	p = stack.peek();
        	if(p.right == null || p.right == visit){
        		visit = p;
        		list.add(visit.val);
        		stack.pop();
        		p = null;
        	}else{
        		p = p.right;
        	}
        }
        return list;
    }
	public List<Integer> postorderTraversal_without_Stack(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		TreeNode dummy = new TreeNode(0);
		dummy.left = root;
		dummy.right = null;
		TreeNode pre, cur = dummy;
		while(cur != null){
			if(cur.left == null){
				cur = cur.right;
			}else{
				pre = cur.left;
				while(pre.right != null && pre.right != cur){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = cur;
					cur = cur.left;
				}else{
					reverse(cur.left, pre);
					TreeNode p = pre;
					while(p != cur.left){
						list.add(p.val);
						p = p.right;
					};
					list.add(p.val);
					reverse(pre, cur.left);
					pre.right = null;
					cur = cur.right;
					
				}
			}
		}
		return list;
	}
	void reverse(TreeNode head, TreeNode end){
		TreeNode i = head, j = i.right, k;
		while(i != end){
			k = j.right;
			j.right = i;
			i = j;
			j = k;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeTraversal s = new BinaryTreeTraversal();
		System.out.println("preorder:");
		Tree.printList(s.preorderTraversal(Tree.tree1));
		Tree.printList(s.preorderTraversal_without_Stack(Tree.tree1));
		Tree.printList(s.preorderTraversal(Tree.tree2));
		Tree.printList(s.preorderTraversal_without_Stack(Tree.tree2));
		System.out.println("inorder:");
		Tree.printList(s.inorderTraversal(Tree.tree1));
		Tree.printList(s.inorderTraversal_without_Stack(Tree.tree1));
		Tree.printList(s.inorderTraversal(Tree.tree2));		
		Tree.printList(s.inorderTraversal_without_Stack(Tree.tree2));
		System.out.println("postorder:");
		Tree.printList(s.postorderTraversal(Tree.tree1));
		Tree.printList(s.postorderTraversal_without_Stack(Tree.tree1));
		Tree.printList(s.postorderTraversal(Tree.tree2));
		Tree.printList(s.postorderTraversal_without_Stack(Tree.tree2));
	}

}
