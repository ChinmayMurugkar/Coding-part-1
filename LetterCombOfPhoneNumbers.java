package general;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 *  Thoughts :
 *  1. We will take each of the number and call the function again with the remaining letters
 *  2. this will done till we are done with all the numbers and add it to the arraylist 
 *  3. In the end we will return the array list
 *  4. Running Complexity : O(n^2)
 */


public class LetterCombOfPhoneNumbers {
			HashMap<Character,String> map = new HashMap<Character,String>();

	
			public ArrayList<ArrayList> getComb(String s){
				map.put('1', "");
		        map.put('2', "abc");
		        map.put('3', "def");
		        map.put('4', "ghi");
		        map.put('5', "jkl");
		        map.put('6', "mno");
		        map.put('7', "pqrs");
		        map.put('8', "tuv");
		        map.put('9', "wxyz");
		        map.put('0', " ");
				
				ArrayList<ArrayList> a = new ArrayList<ArrayList>();
				
				//base case
				if(s.isEmpty())
					return null;
				
				if(s.length() ==0)
					return null;
				
				try{
					Double num = Double.parseDouble(s);
				}catch(NumberFormatException e){
					System.out.println("Error :" + e + "not a valid input");
				}
				
				if(s.length() > 10)
					throw new IllegalArgumentException("Not a valid input");
				
				calcComb(s,new String(), 0,a);

				return a;
			}
			
			public ArrayList<ArrayList> calcComb(String s, String newS, int index, ArrayList<ArrayList>a){
				
				if(newS.length()>s.length())
					return null;
				else if(newS.length()==s.length()){
					ArrayList<String> newA = new ArrayList<String>();
					newA.add(newS);
					a.add(newA);
					return a;
				}else{
					for(int i=index;i <s.length()-1;i++){
				
						String numS = map.get(s.charAt(index));
						for(int j=0; j<numS.length()-1; j++)
							a = calcComb(s,newS+numS.charAt(j),index++,a);
						}
				}
				
				return a;
			}
}
