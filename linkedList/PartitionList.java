package linkedList;

public class PartitionList {
	/**
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	 * You should preserve the original relative order of the nodes in each of the two partitions.
	 * For example,
	 * Given 1->4->3->2->5->2 and x = 3,
	 * return 1->2->2->4->3->5.
	 */
	public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode end1 = dummy1, end2 = dummy2;
        ListNode p = head;
        while(head != null){
        	p = head;
        	head = head.next;
        	if(p.val < x){
        		end1.next = p;
        		end1 = p;
        	}else{
        		end2.next = p;
        		end2 = p;
        	}
        }
        end1.next = dummy2.next;
        end2.next = null;
        return dummy1.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionList s = new PartitionList();
		ListNode a = ListNode.mkLinkedList();
		ListNode r = s.partition(a, 3);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(1);
		r = s.partition(a, 3);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(6,23,67,1,4,6,23,66);
		r = s.partition(a, 10);
		ListNode.print(r);
		
		a = ListNode.mkLinkedList(545,67,2,34,467,3,457,8,76,98,34,6,76);
		r = s.partition(a, 1);
		ListNode.print(r);
	}

}
