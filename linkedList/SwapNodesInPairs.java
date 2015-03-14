package linkedList;

public class SwapNodesInPairs {
	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * For example,
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
	 */
	public ListNode swapPairs(ListNode head) {
//		if(head == null || head.next == null){
//			return head;
//		}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, pn, pnn;
        pn = p.next;
        while(pn != null && pn.next != null){
        	pnn = pn.next;
        	pn.next = pnn.next;
        	pnn.next = pn;
        	p.next = pnn;
        	
        	p = pn;
        	pn = p.next;
        }
        return dummy.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapNodesInPairs s = new SwapNodesInPairs();
		ListNode a = ListNode.mkLinkedList();
		ListNode r1 = s.swapPairs(a);
		ListNode.print(r1);
		
		ListNode b = ListNode.mkLinkedList(1);
		ListNode r2 = s.swapPairs(b);
		ListNode.print(r2);
		
		ListNode c = ListNode.mkLinkedList(1,2,3,4,5,6,7,8);
		ListNode r3 = s.swapPairs(c);
		ListNode.print(r3);
	}

}
