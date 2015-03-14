package linkedList;

public class ReverseLinkedList {
	/**
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	 * For example:
	 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note:
	 * Given m, n satisfy the following condition:
	 * 1 ¡Ü m ¡Ü n ¡Ü length of list.
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy1 = new ListNode(0);
        dummy1.next = head;
        ListNode dummy2 = new ListNode(0);
        ListNode end1, end2, p, next = null;
        end1 = dummy1;
        n = n - m;
        while(--m > 0){
        	end1 = end1.next;
        }
        p = end1.next;
        next = p.next;
        dummy2.next = p;
        end2 = p;
        
        while(n-- > 0){
        	p = next;
        	next = p.next;
        	p.next = dummy2.next;
        	dummy2.next = p;
        	
        }
        end1.next = dummy2.next;
        end2.next = next;
        return dummy1.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList s = new ReverseLinkedList();
		ListNode a = ListNode.mkLinkedList(1,2,3,4,5,6,7,8,9);
		ListNode r = s.reverseBetween(a, 1, 4);
		ListNode.print(r);
	}

}
