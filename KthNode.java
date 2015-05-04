package general;

/*
 * Get the Kth node from end of a linked list. It counts from 
 * 1 here, so the 1st node from end is the tail of list. 
 * Thoughts:
 * 1. Consider two pointers
 * 2. jump one of the pointer to the Kth node from the first node while keeping the other pointer still
 * 3. Now, jump both pointer once each node until second pointer reaches the end
 * 4. return forst pointer
 */

public class KthNode {
	
	public LLNode getKthNode(LLNode head, int k){
		LLNode pt1 = head;
		LLNode pt2 = pt1;
		
		//go to the kth node
		int i=0;
		while(i<k){
			if(i<k && pt1!= null)
				pt1 = pt1.next;
			else
				throw new IllegalArgumentException("not a valid Linked List");
		}
		
		while(pt1.next != null){
			pt1 = pt1.next;
			pt2 = pt2.next;
		}
		
		return pt2;
		
	}
	
}
