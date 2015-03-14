package tree;

public class ConstructBinaryTreeFromTraversal {
	/**
	 * Given inorder and postorder traversal of a tree, construct the binary tree.
	 * Note:
	 * You may assume that duplicates do not exist in the tree.
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || inorder.length < 1) return null;
        TreeNode root = null;
        int r = postorder[postorder.length-1];
        root = new TreeNode(r);
        int m = 0;
        while(inorder[m] != r) m++;
        root.left = buildTree(inorder, 0, m -1, postorder, 0, m -1);
        root.right = buildTree(inorder, m +1, inorder.length -1, postorder, m, postorder.length-2);
        return root;
    }
	public TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int x, int y) {
		if(i > j) return null;
		TreeNode root = null;
		if(i == j){
			root = new TreeNode(inorder[i]);
			root.left = root.right = null;
		}else{
			int r = postorder[y];
			root = new TreeNode(r);
			int m = i;
			while(inorder[m] != r) m++;
			int n = m - i;
			root.left = buildTree(inorder, i, m-1, postorder, x, x + n - 1);
			root.right = buildTree(inorder, m + 1, j, postorder, x + n, y-1);
		}
		return root;
	}
	/**
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
	 * Note:
	 * You may assume that duplicates do not exist in the tree.
	 */
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length < 1) return null;
        TreeNode root = null;
        int r = preorder[0];
        root = new TreeNode(r);
        int m = 0;
        while(inorder[m] != r) m++;
        root.left = buildTree2(preorder, 1, m, inorder, 0, m -1);
        root.right = buildTree2(preorder, m +1, preorder.length -1, inorder, m +1, inorder.length-1);
        return root;
    }
	public TreeNode buildTree2(int[] preorder, int i, int j, int[] inorder, int x, int y) {
		if(i > j) return null;
		TreeNode root = null;
		if(i == j){
			root = new TreeNode(preorder[i]);
			root.left = root.right = null;
		}else{
			int r = preorder[i];
			root = new TreeNode(r);
			int m = x;
			while(inorder[m] != r) m++;
			int n = m - x;
			root.left = buildTree2(preorder, i+1, i+n, inorder, x, m-1);
			root.right = buildTree2(preorder, i +n+1, j, inorder, m+1, y);
		}
		return root;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreeFromTraversal s = new ConstructBinaryTreeFromTraversal();
		int[] inorder = {2,6,4,1,3,5};
		int[] postorder = {6,4,2,5,3,1};
		TreeNode t = s.buildTree(inorder, postorder);
		Tree.visitByLevel(t);
		System.out.println();
		int[] preorder = {1,2,4,6,3,5};
		t = s.buildTree2(preorder, inorder);
		Tree.visitByLevel(t);
	}

}
