package general;

import java.util.ArrayList;
import java.util.regex.Pattern;

/*
 * Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from the given set.

Examples:

Input: 
set[] = {'a', 'b'}, k = 3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb


Input: 
set[] = {'a', 'b', 'c', 'd'}, k = 1
Output:
a
b
c
d
 */


public class CombinationsOfStringForK {
	
	ArrayList<ArrayList> Strings = new ArrayList<ArrayList>();
	boolean flag = true;
	public void getStrings(String s, int n){
		
		//check if the input is not null
		if(s==null)
			flag = false;
		//base case
		if(s.isEmpty())
			flag = false;
		//check if string contains only alphabets
		if(!(Pattern.matches("[a-zA-Z]+", s)))
				flag = false;
		
		
		
		for(int i=0; i<s.length()-1;i++){
			getComb(s,new ArrayList<Character>(s.charAt(i)), n);
		}
		
	}
	
		public void getComb(String s,ArrayList<Character> a, int n){
			
			if(a.size() == n){
				return;
			}
			else{
				//go through each element again
				for(int i=0;i<s.length()-1;i++){
					a.add(s.charAt(i));
				}
			}
			
		} 
	
}













