package com.nel.chan.dsalgo.array.basic;

public class SumOfArray {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 4, 5, 8, 10};
		countOfElements(arr, 6, 9);
	}
	
	public static int countOfElements(int[] arr, int n, int x)
    {
        
        if(n == 1) {
            if(arr[0] <= x) {
                return 1;
            } else {
                return 1;
            }
        }
        
        boolean isFound = false;
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        while(low <= high) {
            mid = (low+high) / 2;
            
            if(arr[mid] == x) {
                isFound = true;
                break;
            }
            
            if(arr[mid] < x) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        if(isFound) {
           int index = mid + 1;
           while(arr[index] == x) {
                ++mid;
                ++index;
            } 
        } else {
            mid =(int) n;
        }
        
        
        return mid;
    }
}
