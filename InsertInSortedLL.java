package general;

import java.util.LinkedList;

/*
 * Given a linked list which is sorted, how will you insert in sorted way
 * Thoughts :
 * 1. check the current node if its higher than the element to be inserted then insert element before it
 * 2. else search for the next highest element in Linked List
 * 3. once found insert the element before the larger element.
 */

public class InsertInSortedLL {
	
	public LLNode ll = new LLNode();
	boolean flag = true;
	
	public void insertElement(LLNode head, int n){
		
		//base case
		if(head==null)
			flag =false;
		LLNode last_ptr = null;
		LLNode cur_ptr = head;
		
		while(head.next != null){
			if(cur_ptr.data == n){
				LLNode temp = cur_ptr.next;
				LLNode newNode = new LLNode(n);
				cur_ptr.next = newNode;
				newNode.next = temp;
			}
			else if(cur_ptr.data > n){
				LLNode temp = last_ptr.next;
				LLNode newNode = new LLNode(n);
				last_ptr.next = newNode;
				newNode.next = temp;
			}
			last_ptr = cur_ptr;
		}	
	}
}
