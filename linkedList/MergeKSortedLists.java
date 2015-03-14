package linkedList;
import java.util.ArrayList;
import java.util.List;


public class MergeKSortedLists {
	/*
	 * Merge two sorted linked lists and return it as a new list. 
	 * The new list should be made by splicing together the nodes of the first two lists.
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(l1 != null && l2 != null){
        	if(l1.val < l2.val){
        		p.next = l1;
        		p = l1;
        		l1 = l1.next;
        	}else{
        		p.next = l2;
        		p = l2;
        		l2 = l2.next;
        	}
        }
        if(l1 != null){
        	p.next = l1;
        }
        if(l2 != null){
        	p.next = l2;
        }
        return dummy.next;
    }
	/**
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.isEmpty()){
			return null;
		}
        ListNode dummy = new ListNode(0);
        ListNode l1 = lists.get(0);
        ListNode p = dummy;
        for(int i = 1; i < lists.size(); i++){
//        	dummy.next = null;
        	ListNode l2 =  lists.get(i);
        	
        	while(l1 != null && l2 != null){
        		if(l1.val < l2.val){
            		p.next = l1;
            		p = l1;
            		l1 = l1.next;
            	}else{
            		p.next = l2;
            		p = l2;
            		l2 = l2.next;
            	}
            }
            if(l1 != null){
            	p.next = l1;
            }
            if(l2 != null){
            	p.next = l2;
            }
            p = dummy;
            l1 = dummy.next;
            
        }
        return dummy.next;
    }
	public ListNode mergeKLists2(List<ListNode> lists) {
		if(lists == null || lists.isEmpty()){
			return null;
		}
		if(lists.size() == 1){
			return lists.get(0);
		}
        ListNode dummy = new ListNode(0);
        ListNode l1, l2, p;
        List t = new ArrayList();
//        int m = lists.size() / 2;
        int i = 0;
        if(lists.size() % 2 == 1){
        	i = 1;
        	t.add(lists.get(0));
        }
    	for(; i < lists.size(); i += 2){
    		dummy.next = null;
    		p = dummy;
    		l1 = lists.get(i);
    		l2 = lists.get(i + 1);
            while(l1 != null && l2 != null){
            	if(l1.val < l2.val){
            		p.next = l1;
            		p = l1;
            		l1 = l1.next;
            	}else{
            		p.next = l2;
            		p = l2;
            		l2 = l2.next;
            	}
            }
            if(l1 != null){
            	p.next = l1;
            }
            if(l2 != null){
            	p.next = l2;
            }
            t.add(dummy.next);
    	}
        return mergeKLists2(t);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeKSortedLists s = new MergeKSortedLists();
		ListNode a = ListNode.mkLinkedList(0,1,2,3,4,5);
		ListNode b = ListNode.mkLinkedList(1,2,2,5,6,7,8);
		ListNode c = s.mergeTwoLists(a, b);
		ListNode.print(c);
		
		ListNode d = ListNode.mkLinkedList(0,1,2,3);
		ListNode e = ListNode.mkLinkedList(0,1,4,5,6);
		ListNode f = ListNode.mkLinkedList(2,5,6,7,8);
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(d);
		lists.add(e);
		lists.add(f);
		lists.add(null);
		lists.add(null);
		ListNode p = s.mergeKLists2(lists);
		ListNode.print(p);
		
	}

}
