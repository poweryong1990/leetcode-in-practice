package linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class CopyListWithRandomPointerTest {
	public static CopyListWithRandomPointer s = new CopyListWithRandomPointer();
	@Test
	public void testCopyRandomList() {
//		fail("Not yet implemented");
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
