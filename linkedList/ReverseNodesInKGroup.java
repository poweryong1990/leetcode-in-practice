package linkedList;

public class ReverseNodesInKGroup {
	/**
	 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
	 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
	 * You may not alter the values in the nodes, only nodes itself may be changed.
	 * Only constant memory is allowed.	
	 * For example,
	 * Given this linked list: 1->2->3->4->5
	 * For k = 2, you should return: 2->1->4->3->5
	 * For k = 3, you should return: 3->2->1->4->5
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || k <= 1){
			return head;
		}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, prev, next;
        while(p.next != null){
        	prev = p;
        	for(int i = 0; i< k; i++){
        		p = p.next;
        		if(p == null){
        			return dummy.next;
        		}
        	}
        	next = p.next;
        	p = prev.next;
        	while(p.next != next){
        		ListNode pnext = p.next;
        		p.next = pnext.next;
        		pnext.next = prev.next;
        		prev.next = pnext;
        	}
        }
		return dummy.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNodesInKGroup s = new ReverseNodesInKGroup();
		ListNode a = ListNode.mkLinkedList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
		ListNode r = s.reverseKGroup(a, 4);
		ListNode.print(r);
	}

}
