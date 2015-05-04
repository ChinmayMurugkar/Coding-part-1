package general;

/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0
 */


public class MatrixConvertRowsCols_0s {

	boolean bugFlag = false;
	public int[][] setZero(int[][] m){
		
		//base case
		if(m==null)
			bugFlag = true;
		if(m.length ==0)
			bugFlag = true;
		
		//checking if matrix has given number
		for(int i=0;i<m.length-1; i++){
			for(int j=0; j<m[0].length-1;j++){
				if(m[i][j] != 1 || m[i][j] != 0){
					bugFlag = true;
				}
			}
		}
		
		//going through the array from second row and second column
		for(int i=1; i<m.length-1; i++){
			for(int j=1; j<m.length-1;j++){
				//check and update status of first row accordingly
				if(m[i][j] == 0){
					m[0][j]=0;
					m[i][0] = 0;
				}
			}
		}
		
		convertCols(m);
		convertRows(m);
		
		return m;
	}
	
	//cols converted to zero
	public int[][] convertCols(int[][] m){
		
		//go through the first row
		for(int i =0; i<m.length-1; i++){
			if(m[0][i] == 0){
				//convert all rows for that column into
				for(int j=0; j<m[0].length-1; j++)
					m[j][i]=0;
			}
		}
		return m;
	}
	
	//rows converted to zero
	public int[][] convertRows(int[][] m){
		
		//go through first col
		for(int i=0; i<m[0].length-1; i++){
			if(m[i][0] == 0){
				//convert cols for that row to zero
				for(int j=0; j<m.length-1;j++)
					m[i][j] = 0;
			}
		}
		return m;
	}
}








