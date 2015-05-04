package general;

import java.util.Stack;
import java.util.regex.Pattern;

/*
 * Phone Interview with Collabedit.

/** Compute the value of an expression in Reverse Polish Notation. Supported operators are "+", "-", "*" and "/".
* Reverse Polish is a postfix mathematical notation in which each operator immediately follows its operands.
* Each operand may be a number or another expression.
* For example, 3 + 4 in Reverse Polish is 3 4 + and 2 * (4 + 1) would be written as 4 1 + 2 * or 2 4 1 + *
*
* @param ops a sequence of numbers and operators, in Reverse Polish Notation
* @return the result of the computation
* @throws IllegalArgumentException ops don't represent a well-formed RPN expression
* @throws ArithmeticException the computation generates an arithmetic error, such as dividing by zero
*
* <p>Some sample ops and their results:
* ["4", "1", "+", "2.5", "*"] -> ((4 + 1) * 2.5) -> 12.5
* ["5", "80", "40", "/", "+"] -> (5 + (80 / 40)) -> 7
*/

/*
 * Thoughts :
 * We would use Stack to solve the problem.
 * 1. Start adding numbers to the stack
 * 2. as we hit operator, get the operator, pop two numbers after it and calculate and put it back
 * 3. continue the same procedure unless we are through the whole string.
 */


public class ReversePolishNotation {
	
	public int calcReverseNotation(String[] exp){
		int result = 0;
		boolean flag = true;
		String operators = "+/*";
		final Pattern valid_exp = Pattern.compile("[0-9+/*]");
		//base case
		if(exp.length==0)
			flag = false;
		if(exp == null)
			flag = false;
		String exps="";
		for(int i=0; i<exp.length-1; i++){
			exps = exps + exp[i];
		}
		flag = valid_exp.matcher(exps).matches();
		
		
		Stack<String> s = new Stack<String>();
		
		//start evaluating through the character input
		for(int i=0; i<exp.length-1;i++){
			if(!operators.contains(exp[i])){
				s.push(exp[i]);
			}
			else{
				int a = Integer.parseInt(s.pop());
				int b = Integer.parseInt(s.pop());
				int pointer = operators.indexOf(exp[i]);
				switch(pointer){
				case 0 :
					s.push(String.valueOf(a+b));
					break;
				case 1 :
					if(a==0){
						flag =false;
						break;
					}
					s.push(String.valueOf(b/a));
					break;
				case 2 :
					s.push(String.valueOf(a*b));
				}
			}
				
		}
		result = Integer.valueOf(s.pop());
		return result;
	}
}
