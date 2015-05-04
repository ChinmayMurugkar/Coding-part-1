package general;


/*
 * Determine whether an input array is a post-order traversal sequence of 
 * a binary tree or not. If it is, return true; otherwise return false. 
 * Assume all numbers in an input array are unique.
 * Thoughts :
 * 1. take the last node i.e. root for the tree
 * 2. start counting the numbers smaller than root from left till encountered by bigger ones
 * 3. count greater ones from left to right till before the root node number
 * 4. if we find the number smaller than the root in right subtree return fasle
 * 5. else go through the same process from left and right subtree
 */
public class IfArrayPostorder {
	
	public boolean checkOrder( int[] a, int start, int end){
		
		//getting the node data
		int rootData = a[end];
		
		int i=start;
		
		//get left subtree
		for(;i<end;i++){
			if(a[i]>=rootData)
				break;
		}
		
		//got hrough right subtree
		int j = i;
		for(;j<end;j++){
			if(a[j] <rootData)
				return false;
		}
		
		boolean leftSubtree = true;
		boolean rightSubtree = true;
		
		//check the left sub tree validility
		if(i<j)
			leftSubtree =  checkOrder(a,start,i-1);
		//check right subtree validity
		if(i>=j)
			rightSubtree =  checkOrder(a,i,end-1);
		
		return (leftSubtree && rightSubtree);	
	}
}
