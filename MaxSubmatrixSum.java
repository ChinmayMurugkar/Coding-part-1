package general;\


import java.util.ArrayList;

/*
 * Given an NxN matrix of positive and negative integers, write code to find the sub- matrix with the largest possible sum. 
 * Thoughts :
 * Method 1 :
 * 1. We will fix the pointer on two ends of the column of matrix and take a pointer along the row ends of the matrix
 * 2. move the one pointer constantly across the rows determining the matrix and their sum
 * 3. If encountered with the max sum along the path we store it
 * 4. Repeat the process till we go through all possible rectangle and we have the winner
 * This method has the complexity of O(n^4)
 * Thoughts :
 * We can use Kadane`s algorithm to reduce the complexity. This algorithm is used on 1D Array to get the max sum sub set from 
 * the array.
 * 1. We will keep the pointers for row and column fixed and move move from each row. 
 * 2. for each row that we pass we will keep the sum of all the elements in temporary array - temp[i]
 * 3. We would get the best max sum subset from temp[i] which would be our best matrix
 * 4. We will do this for all the matrices and we would have our result.
 */

public class MaxSubmatrixSum {
	
	
	public class Result{
		int sum;
		int start;
		int finish;
		
		//set object using constructor
		public void result(int sum, int start, int finish){
			this.sum = sum;
			this.start = start;
			this.finish = finish;
		}
	}
	public int getmax(int[][] m){
		
		int max_sum = 0;	
		int start =0;
		int finish = 0;
		int temp[] = new int[m[0].length];
		//set the first two column pointers
		//fixing the first pointer
		for(int i=0; i<m.length-1; i++){
			//fixing the second pointer
			for(int j=i; j<m.length; j++){
				//going through all the rows
				for(int k=0; k<m[0].length;k++){
					temp[i] = temp[i] + m[k][j];
				
					Result result = Kadanes(temp); 
					if(result.sum > max_sum){
						max_sum =  result.sum;
						start = result.start;
						finish = result.finish;ioi
					}
				}
			}
		}
		
		return max_sum;
	}
	
	public Result Kadanes(int[] temp){
		
		int maxSumSoFar = 0;
		int curSum = 0;
		
		for(int i =0; i<)
	}
	
/*	//get maxinmum subset of the matrix
	public int getSubMax(int[][] m, int col1, int col2,int max_sum){
		
		//going through all the rows
		for(int i=0;i<m.length; i++){
			
		}
		
		return max_sum;
		
	}
*/
	
}












