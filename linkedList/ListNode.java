package linkedList;
// Definition for singly-linked list.
public class ListNode {
	int val;
    ListNode next;
    ListNode(int x) {
    	val = x;
        next = null;
    }
    @Override
    public String toString(){
    	return "->" + val;
    }
    public static ListNode mkLinkedList(int ... val){
		if(val.length == 0){
			return null;
		}
		if(val.length == 1){
			return new ListNode(val[0]);
		}
		ListNode head = new ListNode(val[0]);
		ListNode p = head;
		for(int i = 1; i < val.length; i++){
			p.next = new ListNode(val[i]);
			p = p.next;
		}
		return head;
	}
    public static void print(ListNode list){
		while (list != null){
			System.out.print(list);
			list = list.next;
		}
		System.out.println();
	}
}
