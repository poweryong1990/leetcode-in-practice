package tree;

public class ConvertSortedListToBinarySearchTree {
	/**
	 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
	 */
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return sortedListToBST(head, null);
    }
	TreeNode sortedListToBST(ListNode from, ListNode to){// to is not included!
		if(from == to) return null;
		if(from.next == to) return new TreeNode(from.val);
		TreeNode root = null;
		ListNode mid = from, end = from;
//		while(end.next != to){
//			mid = mid.next;
//			end = end.next;
//			if(end.next != to)
//				end = end.next;
//		}
		while(end != to && end.next != to){
			mid = mid.next;
			end = end.next.next;
		}
		root = new TreeNode(mid.val);
		root.left = sortedListToBST(from, mid);
		root.right = sortedListToBST(mid.next, to);
		return root;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedListToBinarySearchTree s = new ConvertSortedListToBinarySearchTree();
		ListNode l1 = Tree.createListNode(1,2,3,4,5,6,7);
		Tree.visitByLevel(s.sortedListToBST(l1));
		ListNode l2 = Tree.createListNode(1,2,3,4,5,6,7,8);
		Tree.visitByLevel(s.sortedListToBST(l2));
	}

}
