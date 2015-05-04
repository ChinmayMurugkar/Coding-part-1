package general;

/*
 * Convert a binary search tree to a sorted double-linked list. We can only change the target 
 * of pointers, but cannot create any new nodes.
For example, if we input a binary search tree as shown on the left side of the Figure 1, 
the output double-linked list is shown on the right side.
 */

public class BSTandLL {
	/*
	 * Begining values:
	 * curr =- head
	 * prev = null
	 * LLNode = null
	 */
	//method1
	public LLNode convertTreeWithRoot(TreeNode curr, TreeNode prev, LLNode l){
		
		//get the head and start with left subtree and right sub-tree
		l.prev.data = prev.data;
		if(curr.left !=null || curr.right!=null){
			if(curr.left!= null)
				convertTreeWithRoot(curr.left,curr, new LLNode());
			LLNode newl = new LLNode();
			l.prev = newl;
			newl.next = l;
			newl.data = curr.data;
			
			if(curr.right != null)
				l.next = convertTreeWithRoot(curr.right,curr, new LLNode());
			
			return l;
		}
		
		return null;
		}
	//Method2
	public LLNode convertTree(TreeNode curr, TreeNode prev, LLNode l){
		
		//traversing to the left
		if(curr.left != null){
			//if node present traverse left
			convertTree(curr.left, curr, l);
		}
		//if its null on hte left
		else if(curr.left == null)
		{
			l.data = curr.data;
			LLNode newl = new LLNode();
			l.next = newl;
			if(curr.right != null){
				convertTree(curr.right, curr, newl);
			}
			else{
				newl.data = prev.data;
				return newl;
			}
		}
		
		return l.next;
	}
}