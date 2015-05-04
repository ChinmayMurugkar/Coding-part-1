package general;

import java.util.Stack;

/*
 * Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * 
 * Thoughts :
 * 1. We will go through each element in the array once and add it to the stack
 * 2. We will add all the elements of the array in to the stack untill we encounter with the element 
 * of lesser value than the one that si on the top of the stack
 * 3. pop until we come back in to the non decreasing order
 * 4. While popping each element keep the running counter and find the area of the histogram
 * 5. push back in the value to maintain the height back in.
 */

public class LargestRectangleInHistogram {
	
	public int getHistoogram(int[] a){
		
		Stack<Integer> s = new Stack<Integer>();
		int i=0;
		int max = 0;
		while(i < a.length-1){
			
			if(s.isEmpty() || a[i]>s.peek()){
				s.push(a[i]);
				i++;
			}
			else{
				int count = 0;
				while(!s.isEmpty()&& a[i] < s.peek()){
					count++;
					int top = s.pop();
					max = Math.max(max, top*count);
				}
				
				for(int k=0; k<count+1; k++){
					s.push(a[i]);
				}
				i++;
			}
			
		}
		
		int count = 0;
        while(!s.isEmpty()) {
            count++;
            max = Math.max(max, s.pop() * count);
        }
        return max;
	}

}



