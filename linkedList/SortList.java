package linkedList;

public class SortList {
	/**
	 * Sort a linked list using insertion sort.
	 */
	public ListNode insertionSortList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode p = head.next;
		head.next = null;
		ListNode end = head;
		while(p != null){
//			System.out.println("check");
//			ListNode.print(head);
//			ListNode.print(p);
			ListNode q = p;
			p = p.next;
			if(end.val <= q.val){
				end.next = q;
				end = q;
				end.next = null;
			}else if(q.val <= head.val){
				q.next = head;
				head = q;
			}else{
				ListNode j = head;
				while(j.next.val < q.val){
					j = j.next;
				}
				q.next = j.next;
				j.next = q;
			}
		}
		return head;
	}
	/**
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 */
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode l1 = this.sortList(head);
        ListNode l2 = this.sortList(fast);
        return this.mergeSortedList(l1, l2);
    }
	ListNode mergeSortedList(ListNode l1, ListNode l2){
		if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				p.next = l1;
				l1 = l1.next;
			}else{
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if(l1 != null){
			p.next = l1;
		}else{
			p.next = l2;
		}
		return dummy.next;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortList s = new SortList();
		ListNode a = ListNode.mkLinkedList();
		ListNode r = s.sortList(a);
		ListNode.print(r);
		
		ListNode b = ListNode.mkLinkedList(0);
		ListNode r1 = s.sortList(b);
		ListNode.print(r1);
		
		ListNode c = ListNode.mkLinkedList(4,5,1,65,5,12);
		System.out.println("List c:");
		ListNode.print(c);
		ListNode r2 = s.sortList(c);
		System.out.println("Sorted list c");
		ListNode.print(c);
		System.out.println("r2");
		ListNode.print(r2);
		
		ListNode m = ListNode.mkLinkedList(1,2,4);
		ListNode n = ListNode.mkLinkedList(3,5,7);
		ListNode j = s.mergeSortedList(m, n);
		ListNode.print(j);
		
		//insertionSortList
		ListNode d = ListNode.mkLinkedList(4,5,1,65,5,12);
		ListNode r3 = s.insertionSortList(d);
		ListNode.print(r3);
	}

}
