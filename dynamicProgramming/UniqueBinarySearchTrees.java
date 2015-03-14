package dynamicProgramming;
import tree.Tree;
import tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
	/**
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	
	For example,
	Given n = 3, there are a total of 5 unique BST's.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	 */
	public int numTrees(int n) {
		if(n <= 1) return 1;
		int num = 0;
		for(int i = 1; i <= n; i++){
			num += numTrees(i-1) * numTrees(n - i);
		}
		return num;
    }
	public int numTrees_DP(int n) {
		int[] num = new int[n + 1];
		num[0] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < i; j++){
				num[i] += num[j] * num[i - j - 1];
			}
		}
		return num[n];
	}
	/**
	 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
	
	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	 */
	public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> list = new ArrayList<List<TreeNode>>(n + 1);
        List<TreeNode> a = new ArrayList<TreeNode>();
        a.add(null);
        list.add(a);
        for(int node = 1; node <= n; node++){
        	a = new ArrayList<TreeNode>();
        	for(int root = 1; root <= node; root++){
        		List<TreeNode> left = list.get(root -1);
        		List<TreeNode> right = list.get(node - root);
        		for(TreeNode l: left){
        			for(TreeNode r: right){
        				TreeNode tree = new TreeNode(root);
        				tree.left = l;
        				tree.right = increase(r, root);
        				a.add(tree);
        			}
        		}
        	}
        	list.add(a);
        }
        return list.get(n);
    }
	TreeNode increase(TreeNode root, int x){
		if(root == null) return null;
		TreeNode newRoot = new TreeNode(root.val + x);
		newRoot.left = increase(root.left, x);
		newRoot.right = increase(root.right, x);
		return newRoot;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
		System.out.println(s.numTrees(1) + "->" + s.numTrees_DP(1));
		System.out.println(s.numTrees(2) + "->" + s.numTrees_DP(2));
		System.out.println(s.numTrees(3) + "->" + s.numTrees_DP(3));
		System.out.println(s.numTrees(4) + "->" + s.numTrees_DP(4));
		System.out.println(s.numTrees(5) + "->" + s.numTrees_DP(5));
		System.out.println("output Tree");
		List<TreeNode> list = s.generateTrees(3);
		for(TreeNode tree: list){
			Tree.visitByLevel(tree);
		}
	}

}

