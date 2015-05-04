package general;

/*
 * Given two numbers calculate the exponential to the number
 * Thoughts :
 * 1. If the exponent is even then we will divide the exponent by 2 and then find square of the number
 * 2. If the number is odd then we will we will make the exponent even by reducing it by one and multiplying the result by 1
 */

public class CalculateExponential {
	
	public int calculateExponential(int number, int power){
		
		int result =0;
		boolean powerNeg = false;
		boolean numberNeg = false;
		//base cases
		if(number ==0)
			return 0;
		if(number >0 && power ==0)
			return 1;
		//if power is negative
		if(power<0){
			powerNeg = true;
			power = -(power);
		}
		
		//if number is negative
		if(number <0){
			numberNeg = true;
			number = -(number);
		}
		
		result = getPow(number,power);
		
		if(powerNeg == true)
			result = 1/number;
		
		if(numberNeg == true){
			if(power%2 !=0)
				result = -(result);
		}
		
		return result;
	}
	
	public int getPow(int number, int power){
		int  result = 0;
		
		//check if power is even or odd
		if(power%2==0){
			power = power/2;
			number = number * number;
		}
		else{
			power--;
			result = result * number;
		}
		
		return result;
	}
}
