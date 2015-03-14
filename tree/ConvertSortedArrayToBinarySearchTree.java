package tree;

public class ConvertSortedArrayToBinarySearchTree {
	/**
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
	public TreeNode sortedArrayToBST(int[] num) {
        if(num == null) return null;
        return sortedArrayToBST(num, 0, num.length);
    }
	TreeNode sortedArrayToBST(int[] num, int from, int to) {
        if(from == to) return null;
        if(from + 1 == to) return new TreeNode(num[from]);
        int mid = (from + to) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, from, mid);
        root.right = sortedArrayToBST(num, mid + 1, to);
        return root;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedArrayToBinarySearchTree s = new ConvertSortedArrayToBinarySearchTree();
		int[] a = {1,2,3,4,5,6};
		int[] b = {1,2,3,4,5,6,7};
		Tree.visitByLevel(s.sortedArrayToBST(a));
		Tree.visitByLevel(s.sortedArrayToBST(b));
	}

}
