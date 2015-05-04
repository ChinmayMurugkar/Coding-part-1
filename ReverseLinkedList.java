package general;

/*
 * Implement a function to reverse a linked list, and return the head of the reversed list.
 * Thoughts :
 * 1. We will write a recursive solution.
 * 2. So the recurse till the last node and save the previous node state for each recursion
 * 3. Then go back and change the pointer for current node to the previous node.
 * 4. The first node that was added has the previous node state saved as null. Thus, automatically
 * the last node would have the next element as null and the LinkedList is reversed.
 */

public class ReverseLinkedList {
	
	LLNode root;
	
	public void solution(LLNode root, LLNode prev){
		//base case
		if(root == null)
			return;
		if(root.next == null)
			return;
		
		if(root.next != null)
			solution(root.next, root);
		
		root.next = prev;
	}
}
