package general;

import java.util.ArrayList;

/*
 * Given two positive integers n and k, print all increasing sequences of length k such that the elements in every sequence are from first n natural numbers.

Examples:

Input: k = 2, n = 3
Output: 1 2
        1 3
        2 3 

Input: k = 5, n = 5
Output: 1 2 3 4 5

Input: k = 3, n = 5
Output: 1 2 3
        1 2 4
        1 2 5
        1 3 4
        1 3 5
        1 4 5
        2 3 4
        2 3 5
        2 4 5
        3 4 5
 */

/*
 *Thoughts :
 * Method 1 [recursion] - running time complexity : O(n^2)
 * 1. Go through the each array in the number
 * 2. While going through the number get the next increasing sequence and keep on adding it to the result 
 * unless have k numbers in it.
 * 3. 
 */
public class PrintIncreasingSeqNandK {
	
	ArrayList<ArrayList> allSeq = new ArrayList<ArrayList>();
	public void getSeq(int n, int k){
		
		//go through the each element
		for(int i=1; i<n; i++){
			int j = k;
			getComb(n,j--,new ArrayList<Integer>(i));
		}
		
	}
	
	public void getComb(int n, int k, ArrayList<Integer> a){
		if(k==0){
			allSeq.add(a);
			return;
		}
		else{
			for(int i=a.size()+1; i<n;i++){
				a.add(i);
				getComb(n,k--,a);
			}
		}
	}
}
