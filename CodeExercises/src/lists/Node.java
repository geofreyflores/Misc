package lists;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Node {
	
	int value;
	Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
	// Convenience method for method chaining.
	public Node next(Node n) {
		return (this.next = n);
	}
	
	
	public Node reverseList() {
		if (this.next == null) return this;
		
		Node newHead = this.next.reverseList();
		this.next.next = this;
		this.next = null; // new tail
		
		return newHead;
	}
	
	@Test
	public static void testReverseList() {
		Node head = new Node(1); // need to keep head reference
		head.next(new Node(2)).next(new Node(3)).next(new Node(4));
		
		head = head.reverseList();
		
		Assert.assertEquals(head.value, 4);
		Assert.assertEquals(head.next.value, 3);
		Assert.assertEquals(head.next.next.value, 2);
	}
}
