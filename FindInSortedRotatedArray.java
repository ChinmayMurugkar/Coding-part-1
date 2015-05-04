package general;

/*
 * Find a given element in sorted array.

arr= [1, 2, 3, 4, 5, 6]

follow up: If the sorted array is shifted left by unknown number, modify existing binary search to find a element in modified array

arr = [4, 5, 6, 1, 2, 3]
 */

public class FindInSortedRotatedArray {
	
	public void findElem(int[] a, int n){
		boolean flag1 = false;
		boolean flag2 = false;
		int startPt = a[0];
		int endPt = a[a.length-1];
		
		flag1 = findElemNoramlArray(a, startPt, endPt, n);
		flag2 = findElemRotatedArray(a,startPt,endPt,n); 
		
	}
	
	private boolean findElemNoramlArray(int[]a,int startPt, int endPt,int n){
		boolean result = false;
		
		while(startPt<endPt){
			int mid = (startPt + endPt)/2;
			if(a[mid] == n)
				return true;
			else if(mid > n)
				findElemNoramlArray(a,startPt, mid-1,n);
			else if(mid<n)
				findElemNoramlArray(a,mid+1,endPt,n);
		}
		return result;
		
	}
	
	private boolean findElemRotatedArray(int[] a, int startPt, int endPt, int n){
		boolean result=false;
		
		int pivot = findPivot(a, 0, a.length-1);
		if(pivot == -1)
			findElemNoramlArray(a,0,a.length-1,n);
		if(a[pivot]==n)
			return true;
		if(a[pivot] > n){
			return findElemNoramlArray(a,startPt,pivot-1,n);
		}
		else{
			return findElemNoramlArray(a,pivot+1,endPt,n);
		}
	}
	
	int findPivot(int arr[], int low, int high)
	{
	   // base cases
	   if (high < low)  return -1;
	   if (high == low) return low;
	 
	   int mid = (low + high)/2;   /*low + (high - low)/2;*/
	   if (mid < high && arr[mid] > arr[mid + 1])
	     return mid;
	   if (mid > low && arr[mid] < arr[mid - 1])
	     return (mid-1);
	   if (arr[low] >= arr[mid])
	     return findPivot(arr, low, mid-1);
	   else
	     return findPivot(arr, mid + 1, high);
	}
}
