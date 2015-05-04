package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 * WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 * assert(finder.distance("fox","the") == 3);
 * assert(finder.distance("quick", "fox") == 1);
 */

/*
 * Thoughts : 
 * For every word we can keep on storing the position of the word1 and word2 and keep the difference between the 
 * distances among them.
 * This is O(n) runtime complexity.
 * 1. For every word we can keep on storing the position1 and position2 and keep track of min_so_far
 * 2. We will find min(pos1-pos2,min_so_far) every time we find new position for either words where
 * pos1 = index of word1 and pos2 = index of word2
 * Finally we will have the closest distance
 * METHOD #2 : 
 * We will use hashmap to store the indexes and their positions so we don`t have to traverse through the words everytime
 * We can get the positions in  sorted order and find the pair indexes whixh are closer.
 */


public class WordDistanceFinder {
		boolean errorFlag = false;
		
	public int getDist(String[] words, String w1, String w2){
		
		int minDist = 0;
		//base case
		if(words == null)
			errorFlag = true;
		if(words.length == 1)
			return -1;
		//check if the words contains just letters
		for(int i=0; i<words.length;i++){
			if(!words[i].matches("[a-zA-Z]+")){
				errorFlag=false;
			}		
		}
		
		//hashmap to store the words and the position
		HashMap<String,ArrayList<Integer>> wordMap = new HashMap<String,ArrayList<Integer>>();
		
		for(int i=0; i<words.length-1;i++){
			//adding the words and position to map
			if(wordMap.containsKey(words[i])){
				wordMap.get(words[i]).add(i);
			}
			else{
				//now adding the new word to map
				wordMap.put(words[i],new ArrayList<Integer>(i));
			}
			
		}
		
		//get the words positions from the hasmap
		if(wordMap.containsKey(w1) && wordMap.containsKey(w2)){
			ArrayList<Integer> pos1 = wordMap.get(w1);
			ArrayList<Integer> pos2 = wordMap.get(w2);
			Collections.sort(pos1);
			Collections.sort(pos2);
			
			//getting the positions
			int i=0; int j=0;
			//traversing through both of these arrays
			while(i<pos1.size() && j<pos2.size()){
				minDist = Math.min(Math.abs(pos1.get(i)-pos2.get(j)), minDist);
				if(pos1.get(i)<pos2.get(j)){
					i++;
				}
				else if(pos2.get(j)<pos1.get(i))
					j++;
				else if(pos1.get(i) == pos2.get(j))
					throw new IllegalArgumentException("something went wrong");
			}
			
			//going through the leftover arrays
			if(i<pos1.size() && j>=pos2.size()){
				minDist = Math.min(Math.abs(pos1.get(i++)-pos2.get(j--)), minDist);
			}
			if(j<pos2.size() && i>=pos1.size()){
				minDist = Math.min(Math.abs(pos1.get(i--)-pos2.get(j++)), minDist);
			}
		}
		else
			return 0;
		
		return minDist;
	}

}
