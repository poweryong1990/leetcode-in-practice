package tree;

public class PopulatingNextRightPointersInEachNode {
	/**
	 * Given a binary tree
					    struct TreeLinkNode {
					      TreeLinkNode *left;
					      TreeLinkNode *right;
					      TreeLinkNode *next;
					    }
	Populate each next pointer to point to its next right node. 
	If there is no next right node, the next pointer should be set to NULL.
	
	Initially, all next pointers are set to NULL.
	
	Note:
	
	You may only use constant extra space.
	You may assume that it is a perfect binary tree 
	(ie, all leaves are at the same level, and every parent has two children).
	For example,
	Given the following perfect binary tree,
	         1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \  / \
	    4->5->6->7 -> NULL
	 */
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode cur = root;
        while(cur.left != null /* && cur.right != null */){
        	cur.left.next = cur.right;
        	TreeLinkNode p = cur.right, next = cur.next;
        	while(next != null){
        		next.left.next = next.right;
        		p.next = next.left;
        		p = next.right;
        		next = next.next;
        	}
        	cur = cur.left;
        }
    }
	/**
	 * Follow up for problem "Populating Next Right Pointers in Each Node".
	
	What if the given tree could be any binary tree? Would your previous solution still work?
	
	Note:
	
	You may only use constant extra space.
	For example,
	Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
	 */
	public void connectArbitraryBinaryTree(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode cur = root;
        TreeLinkNode p, next;
        while(cur != null){
        	next = cur.next;
        	if(cur.left != null && cur.right != null){
        		cur.left.next = cur.right;
        		p = cur.right;
        		cur = cur.left;
        	}else if(cur.left != null){
        		p = cur.left;
        		cur = cur.left;
        	}else if(cur.right != null){
        		p = cur.right;
        		cur = cur.right;
        	}else{
        		cur = next;
        		continue;
        	}
        	while(next != null){
        		if(next.left != null){
        			p.next = next.left;
        			p = p.next;
        		}
        		if(next.right != null){
        			p.next = next.right;
        			p = p.next;
    			}
        		next = next.next;
        	}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRightPointersInEachNode s = new PopulatingNextRightPointersInEachNode();
		s.connectArbitraryBinaryTree(Tree.linkTree1);
		Tree.print(Tree.linkTree1);
		System.out.println("Tree.linkTree2:");
		s.connectArbitraryBinaryTree(Tree.linkTree2);
		Tree.print(Tree.linkTree2);
	}

}
