package general;

import java.util.HashMap;

/*
 * Given an input string and a target string, find the minimum substring of the input string that contains 
 * all of the characters in the target string
 * Thoughts :
 * 1. We would store the second string in the hashmap with character and its count
 * 2. We would start from the first character in the given string and keep a count till all the charcters in target string are covered
 * 3. We will store the min_len of the string and start moving the cursor forward
 * 4. We would then move ahead till we are encountered with the first starting charcter of the min_len string and move start 
 * ahead till all the useless characters are skipped
 * 5. in the end we will end up with the min_len
 */

public class FindSubStrChars {
	
	public int getMinLen(String s, String targetString){
		boolean bugFlag = false;
		int min_len = 0;
		if(s.isEmpty())
			bugFlag = true;
		if(s == null)
			bugFlag = true;
		if(s.length() <=0)
			bugFlag = true;
		if(s.length() < targetString.length())
			bugFlag = true;
		
		//add all the characters in the target string to hashmap
		HashMap<Character,Integer> words = new HashMap<Character,Integer> ();
		char[] targetChars = targetString.toCharArray();
		//insert all charcters too hashmap
		for(int i=0; i<targetChars.length;i++){
			if(words.containsKey(targetChars[i]))
				words.put(targetChars[i], words.get(targetChars[i])+1);
			else{
				words.put(targetChars[i], 1);
			}
		}
		
		//basse case
		if(s.length() == targetString.length()){
			for(int i=0; i<s.length();i++){
				bugFlag = (!words.containsKey(s.charAt(i)))?true:false;
			}
		}
		
		min_len = getMin( s, targetString, words);
		
		return min_len;
	}
	
	public int getMin(String s, String targetString, HashMap<Character,Integer> words){
		HashMap<Character,Integer> mapCopy = words;
		int min_len = 0;
		int start = -1;
		int end = -1;
		
		//going through the array
		//ge the first min_len
		for(int i=0; i<s.length();i++){
			//for each charcter check if its present int hashmap and reduce the count in hashamap
			if(words.containsKey(s.charAt(i))&&start <0)
				start = i;
			else if(words.containsKey(s.charAt(i))&& start>0){
				int emptyCount = 0;
				for(char c: words.keySet()){
						emptyCount = emptyCount + words.get(c);
			}
				if(emptyCount == 0){
					end = i;
					min_len = end-start;
					break;
				}
		}
	}
		if(start >0 && end >0){
			//going through remianing array
			for(int i=end+1;i<s.length();i++){
				if(s.charAt(i)==s.charAt(start)){
					start = getNewStart(s,start,end,i,mapCopy);
					min_len = Math.min(min_len,end-start);
				}
			}
		}
		return min_len;
}
	
	public int getNewStart(String s, int start, int end,int i, HashMap<Character,Integer> mapCopy){
		//get neew start by moving to new word in the words in
		for(int j=0;j<end;j++){
			if(mapCopy.containsKey(s.charAt(j)))
				return j;
		}
		return start;
	}
}
