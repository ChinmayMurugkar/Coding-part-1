package general;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and 
 * there exists one unique longest palindromic substring. 
 * 1. This problem has two parts - check if the string is palindrome and check go through all the combinations
 * 2. Each of the string we will check would have two pointers i.e. at the begining and at the end
 * 3. We can use sliding window method.
 */

public class LongestPalindromicString {
	
	public String getLongestPalindrome(String s){
		
		//base case
		if(s==null || s.isEmpty())
			throw new IllegalArgumentException("this is not a valid input");
		if(s.length()==1)
			return s;
		
		//go through the string
		for(int i=s.length(); i>0;i--){
			//got through the windows
			for(int j=0;j<s.length()-i;j++){
				if(isPalindrome(s.substring(j, j+i))){
					
				}
			}
		}
		
		return s;
	}
	
	//finding out the palindrome
	public boolean isPalindrome(String s){
		if(s.length()==1)
			return true;
		else
			return (s.charAt(0)==s.charAt(s.length()-1)) && isPalindrome(s.substring(1,s.length()-1));
			
		}
	}
	

