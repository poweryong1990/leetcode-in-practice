package linkedList;

public class RotateList {
	/**
	 * Given a list, rotate the list to the right by k places, where k is non-negative.
	 * For example:
	 * Given 1->2->3->4->5->NULL and k = 2,
	 * return 4->5->1->2->3->NULL.
	 * 
	 * Given 1->2->NULL and k = 3,
	 * return 2->1->NULL.
	 */
	public ListNode rotateRight(ListNode head, int n) {
        if(head == null || n < 1){
        	return head;
        }
        ListNode p = head, q = head;
        int k = 0;
        while(p != null){
        	k++;
        	p = p.next;
        }
        n = n % k;
        p = head;
        while(p.next != null && n-- > 0){
        	p = p.next;
        }
        if(n > 0){
        	return head;
        }
        while(p.next != null){
        	p = p.next;
        	q = q.next;
        }
        p.next = head;
        head = q.next;
        q.next = null;
        return head;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateList s = new RotateList();
		ListNode a = ListNode.mkLinkedList();
		ListNode r = s.rotateRight(a, 0);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(1,2,3,4,5,6,7,8,9);
		r = s.rotateRight(a, 0);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(1,2,3,4,5,6,7,8,9);
		r = s.rotateRight(a, 9);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(1,2,3,4,5,6,7,8,9);
		r = s.rotateRight(a, 8);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(1,2,3,4,5,6,7,8,9);
		r = s.rotateRight(a, 7);
		ListNode.print(r);
	}

}
