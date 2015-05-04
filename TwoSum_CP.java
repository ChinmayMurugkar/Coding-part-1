package general;

import java.util.HashMap;
import java.util.LinkedList;


//Implement Two Sum Interface -

public class TwoSum_CP implements TwoSum{
	
	//we will store all the inputs that are coming in in linkedlist
	LinkedList<Integer> ll = new LinkedList<Integer>();
	
	@Override
	public void store(int input) {
		// TODO Auto-generated method stub
		ll.add(input);
	}
	
	//this would generate pairs for the given input
	public boolean generatepairs(int input){
		if(input > Integer.MAX_VALUE || input < Integer.MIN_VALUE )
			throw new IllegalArgumentException("This is not a valid input");
		HashMap<Integer, Integer> pair = new HashMap<Integer,Integer>();
		for(Integer lm: ll){
			if(pair.containsKey(lm)){
				//to get  the pair indexes follow following code
				/*
				 * int index = pair.get(lm);
				 * int p1 = index
				 * int p2 = lm;
				 */
				return true;
			}else{
				pair.put(input - lm,ll.indexOf(lm));
			}
		}
		return false;
	}

	@Override
	public boolean test(int val) {
		// TODO Auto-generated method stub
		return false;
	}
	
}