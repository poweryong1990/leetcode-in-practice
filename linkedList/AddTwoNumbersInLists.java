package linkedList;

public class AddTwoNumbersInLists {
	/**
	 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while(p1 != null && p2 != null){
        	int sum = carry + p1.val + p2.val;
        	carry = sum / 10;
        	sum = sum % 10;
        	p.next = new ListNode(sum);
        	p = p.next;
        	p1 = p1.next;
        	p2 = p2.next;
        }
        if(p2 != null){
        	p1 = p2;
        }
        while(p1 != null){
        	int sum = carry + p1.val;
        	carry = sum / 10;
        	sum = sum % 10;
        	p.next = new ListNode(sum);
        	p = p.next;
        	p1 = p1.next;
        }
        if(carry > 0){
        	p.next = new ListNode(carry);
        }
        return dummy.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbersInLists s = new AddTwoNumbersInLists();
		ListNode a = ListNode.mkLinkedList();
		ListNode b = ListNode.mkLinkedList();
		ListNode r = s.addTwoNumbers(a, b);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(1,2,3);
		b = ListNode.mkLinkedList();
		r = s.addTwoNumbers(a, b);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(1,2,3);
		b = ListNode.mkLinkedList(4,5,6);
		r = s.addTwoNumbers(a, b);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(1,2,3);
		b = ListNode.mkLinkedList(4,5,6,7);
		r = s.addTwoNumbers(a, b);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(1,2,3);
		b = ListNode.mkLinkedList(8,9,9,9,9);
		r = s.addTwoNumbers(a, b);
		ListNode.print(r);
	}

}
