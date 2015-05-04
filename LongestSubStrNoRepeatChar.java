package general;

import java.util.HashMap;

/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for “abcabcbb” is “abc”,
 *  which the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1. 
 *  Thoughts :
 *  1. We will keep a  
 */


public class LongestSubStrNoRepeatChar {
	
	HashMap<Character, Integer> map = new HashMap<Character,Integer>();
	
	public int getLongestStr(String s){
		
		int sLen = s.length();
		int maxlength = 0;
		int start = sLen; int end=0;
		//lets go through the aray
		for(int i=0; i<sLen; i++){
			if(map.get(s.charAt(i)) != null || map.get(s.charAt(i)) > 0 ){
				if(i-start > maxlength)
					maxlength = i-start;
				while(s.charAt(start)!=s.charAt(i)){
					start++;
					map.put(s.charAt(start),0);
				}
				start++;
			}
			else{
				map.put(s.charAt(i), map.get(s.charAt(i)+1));
				end = i;
			}
		}
		return maxlength;
	}
	
}
