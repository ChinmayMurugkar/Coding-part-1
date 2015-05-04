package general;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 *  array. Each element in the array represents your maximum jump length at that position.
 *   Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false. 

Thoughts :
1. We would start through the first index and get the number
2. assign that number for index and recurse through it to the next one
3. repeat the process to check if we reach the end
Time complexity : O(n!)
 */

public class JumpGame {
	
	//input bug flag
	boolean stat = false;
	
	public boolean checkDest(int[] a, int cur, int index){
		
		if(a[index]>=a.length)
			return true;
		else{
			//get the current index pointer and add the index to it
			cur = cur+index;
			//get the new value from the new index pointer
			int jump = a[cur];
			//go through all the jumps of the new value
			for(int i=1; i<=jump; i++)
				stat = checkDest(a,cur,i);
		}
			
		return stat;
	}
	
	/*
	 * The above method can exceed the time complexity. lets try to reduce the time complexity 
	 * We will use bottom up approach.
	 * 1. Check the which is the box that can access the current box
	 * 2. And keep on checking if any of the box can access it. if you reach the first box then we got a winner.
	 */
	
	public boolean checkDestBottomUp(int[] a){
		boolean finalResult = true;
		
		if(a==null)
			stat = true;
		if(a.length ==0)
			stat = true;
		
		finalResult = (a.length==1)? ((a[0]==0)?true:false) : getDest(a);
		
		return finalResult;
	}
	
	public boolean getDest(int[] a){
		boolean res = false;
		int destIndex = a.length;
		
		}
		
		return res;
	}boolean res = false;
	
}
