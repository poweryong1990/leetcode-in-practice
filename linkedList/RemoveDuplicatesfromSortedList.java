package linkedList;

public class RemoveDuplicatesfromSortedList {
	/*
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * For example,
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return head;//null
		ListNode p = head;
		while(p.next != null){
			if(p.val == p.next.val){
				p.next = p.next.next;
			}else{
				p = p.next;
			}
		}
		return head;
    }
	/*
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	 * For example,
	 * Given 1->2->3->3->4->4->5, return 1->2->5.
	 * Given 1->1->1->2->3, return 2->3.
	 */
	public ListNode deleteDuplicates_2(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode p, pre;
		while(head.val == head.next.val){
			pre = head;
			while(head.next != null && head.val == head.next.val){
				head = head.next;
			}
			if(head != pre){
				head = head.next;
			}
			if(head == null || head.next == null){
				return head;
			}
		}
		
		pre = head;
		p = head.next;
		while(p != null && p.next != null){
			while(p.next != null && p.val == p.next.val){
				p = p.next;
			}
			if(pre.next != p){
				pre.next = p.next;
				p = pre.next;
			}else{
				pre = pre.next;
				p = pre.next;
			}
		}
		return head;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedList s = new RemoveDuplicatesfromSortedList();
		ListNode a = ListNode.mkLinkedList(0,0,0,1,1,1,1,2,3,3,4,4);
		ListNode p = null;

		System.out.println("original list is ");
		ListNode.print(a);
		System.out.println("deleteDuplicates: ");
		p = s.deleteDuplicates(a);
		ListNode.print(p);
		ListNode.print(a);
		System.out.println("deleteDuplicates_2: ");
		
		p = s.deleteDuplicates_2(a);
		ListNode.print(p);
		
//		a = ListNode.mkLinkedList();
//		s.print(a);
	}

}
