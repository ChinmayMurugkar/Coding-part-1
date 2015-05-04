package general;

import java.util.ArrayList;

/*
 *  Given an array, please determine whether it contains three numbers whose sum equals to 0.
 *  Thoughts :
 *  1. We can use three pointers
 *  2. First pointer will go through each element and the next two pointers will go through 
 *  rest of the numbers after the first pointer in loop
 *  3. Everytime if the first pointer + second pointer macthes the -(third pointer number) then
 *  we have a 3sum triplet and return them
 *  4. if first pointer + second pointer number > third pointer number then decrease third pointer
 *  5. If first pointer + second pointer number < third pointer number then increase second pointer 
 */

public class Three3Sum {
	
	public ArrayList<ArrayList> get3Sum(int[] a){
		
		
		//base case
		if(a==null)
			return null;
		if(a.length <= 0)
			return null;
		
		ArrayList<ArrayList> finalResult = new ArrayList<ArrayList>();
		ArrayList<Integer> result;
		
		if(a.length ==3){
			result = new ArrayList<Integer>();
			result.add(a[0]);
			result.add(a[1]);
			result.add(a[2]);
			finalResult.add(result);
			return finalResult;
			}
		
		if(a.length > 3){
			
			for(int i=0;i<a.length-2;i++){
				if(i==0 || a[i] > a[i-1]){
					
					int negative = -a[i];
					int start = a[i+1];
					int end = a.length-1;
					
					while(start > end){
						if((start + end)==negative){
							result = new ArrayList<Integer>();
							result.add(a[start]);
							result.add(a[end]);
							result.add(a[negative]);
							finalResult.add(result);
							//handling duplicates in the array
							while (start < end && a[end] == a[end + 1])
								end--;
							while (start < end && a[start] == a[start - 1])
								start++;
						}
						else if((start+end)>negative)
							end--;
						else
							start++;
					}
					
				}
				
			}
		}
		
		return finalResult;
	}

}
