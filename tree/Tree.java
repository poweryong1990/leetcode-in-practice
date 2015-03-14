package tree;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Tree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree s = new Tree();
		TreeNode t1 = s.createTree(0,1,2,3,4,-1,-1,-1,-1,5,-1,-1,6);
		s.visit(t1);
		System.out.println();
		s.visitByLevel(t1);
		System.out.println();
		System.out.println("deepth: " + s.deepth(t1));
	}
	/**
	 * OJ's Binary Tree Serialization:
	The serialization of a binary tree follows a level order traversal, 
	where '#' signifies a path terminator where no node exists below.
	
	Here's an example:
	   1
	  / \
	 2   3
	    /
	   4
	    \
	     5
	The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
	 */
	public static TreeNode tree1 = Tree.createTree(1,2,3,-1,-1,4,-1,-1,5);
	/**
	 * Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	 */
	public static TreeNode tree2 = Tree.createTree(3,9,20,-1,-1,15,7);
	/**
	 * Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After linking, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
	 */
	public static TreeLinkNode linkTree1 = createLinkTree(1,2,3,4,5,-1,7);
	/**
	 *           1
	 *         /   \
	 *        2     3
	 *         \   / \
	 *          4 5   6
	 *               / \
	 *              7   8
	 */
	public static TreeLinkNode linkTree2 = createLinkTree(1,2,3,-1,4,5,6,-1,-1,-1,-1,7,8);
	public static TreeNode createTree(int ... arg){
		if(arg == null || arg.length == 0 || arg[0] == -1) return null;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode t = new TreeNode(arg[0]);
		q.offer(t);
		int i = 1;
		while(i < arg.length){
			TreeNode c = q.poll();
			if(arg[i] != -1){
				c.left = new TreeNode(arg[i]);
				q.offer(c.left);
			}else{
				c.left = null;
			}
			i++;
			if(i >= arg.length){
				c.right = null;
				break;
			}
			if(arg[i] != -1){
				c.right = new TreeNode(arg[i]);
				q.offer(c.right);
			}else{
				c.right = null;
			}
			i++;
		}
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			node.left = null;
			node.right = null;
		}
		return t;
	}
	public static TreeLinkNode createLinkTree(int ... arg){
		if(arg == null || arg.length == 0 || arg[0] == -1) return null;
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		TreeLinkNode t = new TreeLinkNode(arg[0]);
		q.offer(t);
		int i = 1;
		while(i < arg.length){
			TreeLinkNode c = q.poll();
			if(arg[i] != -1){
				c.left = new TreeLinkNode(arg[i]);
				q.offer(c.left);
			}else{
				c.left = null;
			}
			i++;
			if(i >= arg.length){
				c.right = null;
				break;
			}
			if(arg[i] != -1){
				c.right = new TreeLinkNode(arg[i]);
				q.offer(c.right);
			}else{
				c.right = null;
			}
			i++;
		}
		while(!q.isEmpty()){
			TreeLinkNode node = q.poll();
			node.left = null;
			node.right = null;
		}
		return t;
	}
	public static ListNode createListNode(int ... arg){
		if(arg == null || arg.length == 0) return null;
		ListNode head = null, p = null;
		for(int val: arg){
			if(p == null){
				head = new ListNode(val);
				p = head;
			}else{
				p.next = new ListNode(val);
				p = p.next;
			}
		}
		return head;
	}
	public void visit(TreeNode t){
		if(t.left != null) visit(t.left);
		System.out.print("->" + t.val);
		if(t.right != null) visit(t.right);
	}
	public static void print(TreeNode t){
		if(t != null){
			if(t.left != null && t.right != null){
				System.out.println(t.val + "->("+t.left.val+", "+t.right.val+")");
			}else if(t.left != null){
				System.out.println(t.val + "->("+t.left.val+", null)");
			}else if(t.right != null){
				System.out.println(t.val + "->(null, "+t.right.val+")");
			}else{
				System.out.println(t.val + "->(null, null)");
			}
//			print(t.left);
//			print(t.right);
		}
	}
	public static void visitByLevel(TreeNode t){
		if(t == null){
			System.out.println("empty tree!");
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(t);
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			System.out.print("->" + node.val);
			if(null != node.left) q.offer(node.left);
			if(null != node.right) q.offer(node.right);
		}
		System.out.println();
	}
	public int deepth(TreeNode t){
		if(t == null) return 0;
		int a = deepth(t.left);
		int b = deepth(t.right);
		return a > b ? a + 1 : b + 1;
	}
	public static void print(List<List<Integer>> ll){
		for(List<Integer> a: ll){
			for(int b: a){
				System.out.print("->"+b);
			}
			System.out.println();
		}
	}
	public static void printList(List<Integer> list){
		for(int a: list){
			System.out.print("->" + a);
		}
		System.out.println();
	}
	public static void print(TreeLinkNode root){
		if(root == null){
			System.out.println("Empty Link Tree!");
			return;
		}
		
		while(root != null){
			TreeLinkNode p = root;
			do{
				System.out.print("->" + p.val);
				p = p.next;
			}while(p != null);
			System.out.println();
			
			while(root != null && root.left == null && root.right == null){
				root = root.next;
			}
			if(root == null) break;
			if(root.left != null)
				root = root.left;
			else if(root.right != null)
				root = root.right;
		}
	}
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

 