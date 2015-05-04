package general;

/*
 * How to check whether there is a loop in a linked list?
 * Thougths:
 * we can apply following method :
 * 1. go throught the list
 * 2. save pointer to each node in the hadhmap
 * 3. if any node already present in the hashmap then we have a loop
 * But in this the memory in O(N)
 * We can use hare and tortoise method to solve this in just O(N) time and memory
 * 1. Take two pointers,one fast and one slow i.e. one pointer moves through every node and another
 * jumps over every other node
 * 2. If these two pointers meet each other again then we got a loop
 */

public class CheckLoopInLL {
	
	public boolean ifLooped(LLNode head){
		
		if(head == null)
			return false;
		
		boolean flag = false;
		LLNode p1 = head;
		LLNode p2 = p1;
		while(p2.next.next != null){
			if(p1==p2){
				flag = true;
				break;
			}
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		return flag;
	}
}
