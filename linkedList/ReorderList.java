package linkedList;

public class ReorderList {
	/**
	 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
	 * reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
	 * You must do this in-place without altering the nodes' values.
	 * For example,
	 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 */
	public void reorderList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return;
		}
		ListNode fast = head, slow = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		ListNode dummy = new ListNode(0);
		dummy.next = fast;
		slow = fast.next;
		fast.next = null;
		while(slow != null){
			fast = slow;
			slow = slow.next;
			fast.next = dummy.next;
			dummy.next = fast;
		}
		fast = head;
		while(dummy.next != null){
			slow = dummy.next;
			dummy.next = slow.next;
			slow.next = fast.next;
			fast.next = slow;
			fast = slow.next;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList s = new ReorderList();
		ListNode a = ListNode.mkLinkedList();
		s.reorderList(a);
		ListNode.print(a);
		
		a = ListNode.mkLinkedList(1);
		s.reorderList(a);
		ListNode.print(a);
		
		a = ListNode.mkLinkedList(1,2);
		s.reorderList(a);
		ListNode.print(a);
		
		a = ListNode.mkLinkedList(1,2,3);
		s.reorderList(a);
		ListNode.print(a);
		
		a = ListNode.mkLinkedList(1,2,3,4,5,6,7,8);
		s.reorderList(a);
		ListNode.print(a);
	}

}
