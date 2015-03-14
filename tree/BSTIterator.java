package tree;

public class BSTIterator {
	/**
	 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
	
	Calling next() will return the next smallest number in the BST.
	
	Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
	 */
	private TreeNode cur = null;
	public BSTIterator(TreeNode root) {
		if(root == null) return;
        TreeNode pre;
        cur = root;
        while(cur.left != null){
        	pre = cur.left;
        	while(pre.right != null){
        		pre = pre.right;
        	}
        	pre.right = cur;
        	cur = cur.left;
        }    
	}

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        int ret = cur.val;
//        System.out.println("cur.val=" + cur.val);
        cur = cur.right;
        if(cur == null) return ret;
        while(cur.left != null){
//        	System.out.println("cur.left != null");
        	TreeNode pre = cur.left;
        	while(pre.right != null && pre.right != cur){
        		pre = pre.right;
//        		System.out.println("pre = pre.right");
        	}
        	if(pre.right == null){
        		pre.right = cur;
        		cur = cur.left;
        	}else{
        		pre.right = null;
        		break;
        	}
        }
        return ret;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = Tree.createTree(5,3,7,2,4,6,9,1,-1,-1,-1,-1,-1,8);
//		Tree.visitByLevel(tree);
		BSTIterator s = new BSTIterator(tree);
		while(s.hasNext()){
			System.out.print(s.next()+",");
		}
//		s.next();s.next();
//		Tree.print(tree);
//		Tree.print(tree.left);
//		Tree.print(tree.right);
//		Tree.print(tree.left.left);
//		Tree.print(tree.left.right);
//		Tree.print(tree.right.left);
//		Tree.print(tree.right.right);
//		Tree.print(tree.left.left.left);
//		Tree.print(tree.right.right.left);
//		System.out.println("root" + tree.val + "->" + tree.left.val );
//		System.out.println(s.hasNext());
//		System.out.println(s.next());
//		System.out.println(s.hasNext());
//		System.out.println(s.next());
//		System.out.println(s.hasNext());
//		System.out.println(s.next());
//		System.out.println(s.hasNext());
//		System.out.println(s.next());
	}

}
