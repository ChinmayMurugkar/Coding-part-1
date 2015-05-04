package general;

/*
 * Please implement a function to get the number of 1s in an integer.
 *  For example, the integer 9 is 1001 in binary, so it returns 2 since there are two bits of 1s.
 *  First method :
 *  1. CHeck most right bit for 1 or 0 and keep on right shifting
 *  2. keep on repeating the process till the number is 0
 *  The problem with his method is that the negative case is not handled 
 */

public class Get1sFromInteger {
		public int get1s(int n){
			if(n==0)
				return 0;
			int counter = 0;
			int one = 1;
			while(n >0){
				if((n&1)>0 )
					counter++;	
				n = n>>1;
			}
			return counter;
		}
}
