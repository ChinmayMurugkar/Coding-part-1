package general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given a m * n grid filled with non-negative numbers,find a path from top left to bottom 
 * right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time. 
 * Thougths :
 * 1. When in the matrix at the cell m[x,y] the minimum path from that cell to the last cell
 * will be = minSum = m[x,y] + minSum(m[x,y=1],m[x+1,y])
 * 2. Here we would be repeating lot of computations, thus we will try to 	
 */

public class MinimumPathSum {
	HashMap<List<Integer>,Integer> map = new HashMap<List<Integer>,Integer>();
	
	public int minPathSum(int[][] m, int x, int y){
		
		if(m == null)
			return 0;
		if(m.length <= 1 && m[0].length <= 1)
			return (m.length == 1 && m[0].length == 1)?m[0][0]:0;
		
		List<Integer> l;
		l = new ArrayList<Integer>();
		l.add(x);l.add(y);
		
		int sum = m[x][y];
		
		if(map.get(l)!=null)
			return map.get(l);
		else{
			
			if(x<m.length-1 && y<m[0].length-1)
				return sum = sum + Math.min(minPathSum(m, x+1, y), minPathSum(m,x,y+1));
			else if(x==m.length-1 && y==m[0].length-1)
				return sum = sum + 0;
			else if(x==m.length-1)
				return sum = sum + minPathSum(m,x,y+1);
			else if(y==m.length-1)
				return sum = sum + minPathSum(m,x+1,y);
			
			map.put(l, sum);
			return sum;
		}	
	}
}
