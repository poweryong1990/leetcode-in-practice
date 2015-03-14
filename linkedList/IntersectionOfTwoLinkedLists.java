package linkedList;

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
        	return null;
        }
        ListNode end = headA, fast = headB, slow = headB;
        while(end.next != null){
        	end = end.next;
        }
        end.next = headA;
        while(fast.next != null && fast.next.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast){
        		fast = headB;
        		while(slow != fast){
        			slow = slow.next;
        			fast = fast.next;
        		}
        		end.next = null;
        		return fast;
        	}
        }
        end.next = null;
        return null;
    }
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
        	return null;
        }
        ListNode end = headA, fast = headA, slow = headB;
        int a = 1;
        int b = 1;
        while(fast.next != null){
        	a++;
        	fast = fast.next;
        }
        while(slow.next != null){
        	b++;
        	slow = slow.next;
        }
        if(fast != slow){
        	return null;
        }
        end = fast;
        if(a <= b){
        	end.next = headA;
        	fast = slow = headB;
        }else{
        	end.next = headB;
        	fast = slow = headA;
        }
        
        while(fast.next != null && fast.next.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast){
        		if(a <= b)
        			fast = headB;
        		else
        			fast = headA;
        		while(slow != fast){
        			slow = slow.next;
        			fast = fast.next;
        		}
        		end.next = null;
        		return fast;
        	}
        }
        end.next = null;
        return null;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();
		ListNode a = new ListNode(1);
		ListNode p = a;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(3);
		p = p.next;
		ListNode intersec = p;
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(5);
		ListNode b = new ListNode(-1);
		p = b;
		p.next = new ListNode(-2);
		p = p.next;
		p.next = new ListNode(-3);
		p = p.next;
				
		System.out.println("intersection node: " + s.getIntersectionNode2(a, b));
		
		p.next = intersec;
		System.out.println("intersection node: " + s.getIntersectionNode2(a, b));
		
	}

}
