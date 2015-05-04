package general;

/*
 * Reverse the order of words in a sentence, but keep words themselves
 *  unchanged. Words in a sentence are divided by blanks. For instance, 
 *  the reversed output should be “student. a am I” when the input is “I am a student”.
 */
/*
 * Thoughts : 
 * 1. We can reverse each of the word throughout the sentence 
 * 2. Kepp two pointers at each end and keep on swapping every element till both of 
 * the pointers meet or cross each other
 */

public class ReverseWordsInSent {
	
	//reverse method
	public String reverseSent(String s){
		
		//get string length
		int sLen = s.length();
	
		//get word array from string:
		String[] news = s.split(" ");
		
		int newsLen = news.length;
		
		//go through each word in string and reverse it
		for(int i =0; i<newsLen; i++){
			s = s +" " +reverse(news[i]);
		}
		
		//now reverse each character in the string
		s = reverse(s);
		
		return s;
	}
	//reverse the word
	
	public String reverse(String s){
		//convert to character array
		char[] c = s.toCharArray();
		
		int i=0;
		int j= c.length-1;
		//swap the characters
		while(i<=j){
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
			i++; j--;
		}
		s = c.toString();
		return s;
	}
	
}
