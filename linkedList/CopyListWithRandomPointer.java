package linkedList;

public class CopyListWithRandomPointer {
	/**
	 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
     * Return a deep copy of the list.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null){
			return null;
		}
        RandomListNode p = head, q, random;
        while(p != null){
        	q = new RandomListNode(p.label);
        	q.next = p.random;
        	p.random = q;
        	p = p.next;
        }
        p = head;
        while(p != null){
        	q = p.random;
        	if(q.next != null){
        		q.random = q.next.random;
        	}else{
        		q.random = null;
        	}
        	p = p.next;
        }
        p = head;
        RandomListNode h = head.random;
        while(p != null){
        	q = p.random;
        	p.random = q.next;
        	if(p.next != null){
        		q.next = p.next.random;
        	}else{
        		q.next = null;
        	}
        	p = p.next;
        }
        return h;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyListWithRandomPointer s = new CopyListWithRandomPointer();
		RandomListNode a = new RandomListNode(1);
		RandomListNode b = new RandomListNode(2);
		RandomListNode c = new RandomListNode(3);
		RandomListNode d = new RandomListNode(4);
		RandomListNode e = new RandomListNode(5);
		RandomListNode f = new RandomListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = null;
		
		a.random = c;
		b.random = c;
		c.random = a;
		d.random = d;
		e.random = null;
		f.random = d;
		
		RandomListNode.print(a);
		
		RandomListNode r = s.copyRandomList(a);
		a.label = b.label = c.label = d.label = e.label = f.label = -1;
		RandomListNode.print(r);
		
		RandomListNode g = new RandomListNode(0);
		g.next = null;
		g.random = null;
		r = s.copyRandomList(g);
		g.label = -1;
		RandomListNode.print(r);
		
		g.random = g;
		g.label = 0;
		r = s.copyRandomList(g);
		g.label = -1;
		RandomListNode.print(r);
	}

}
//Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x;}
    
    static int num = 0;
    public static void print(RandomListNode h){
    	System.out.println("No." + ++num);
    	while(h != null){
    		System.out.print("-->("+h.label+", "+(h.random!=null? h.random.label:null)+")");
    		h = h.next;
    	}
    	System.out.println();
    }
}