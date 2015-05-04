package general;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        boolean newCount = true;
        int N =0;
        int count=0;
        String input=null;
        List<Integer> cyclesList = new ArrayList<Integer>();
        try{
		BufferedReader br = 
                      new BufferedReader(new InputStreamReader(System.in));
		while((input=br.readLine())!=null){
			if(newCount = true){
                if(Integer.parseInt(input) <=10)
                    //get number of inputs
                 N = Integer.parseInt(input);
                System.out.println(N);
                newCount = false;
            }
            else{
                 
                cyclesList.add(Integer.parseInt(input));
                System.out.println(cyclesList);
            }
		}
	}catch(IOException io){
		io.printStackTrace();
	}	
        
            int cycles = 0;
            for(int i=0; i<N; i++){
                if(cyclesList.get(i)!=null)
                    cycles = cyclesList.get(i);
                else
                    throwError();
                if(cycles <=60){
                    int result = getHeight(cycles);
                    System.out.println(result);
                }
             
            }//end of for
        
        
    }
    
    public static int getHeight(int cycles){
        int result = 1;
        boolean spring = true;
        //got through the cycles
        for(int i=0; i<cycles; i++){
            //get spring height
            if(spring = true){
                result = result * 2;
                spring = false;
            }
            else{
                result ++;
                spring = true;
            }
        }
        return result;
    }
    
    public static void throwError(){
        throw new IllegalArgumentException("not a valid input");
    }
}