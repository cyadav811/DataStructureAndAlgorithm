package com.dsa.binarySearch;

public class MediumLevel {

	public static int binarySearchInRotatedSortedArray(int [] arr, int target) {
		int start =0;
		int end = arr.length-1;
		
		while(start<=end) {
			
			int mid = start+(end-start)/2;
			System.out.println(mid+"M ");
			if(arr[mid]==target) return mid;
			
			if(arr[start]<=arr[mid] ) {
				if( target>=arr[start] &&  target<=arr[mid]) end = mid-1;
				else  {       //if(arr[start]<=arr[mid]  && target<=arr[start])
					start = mid+1;
				}
			}
			
			else {
				if(target>=arr[mid] && target<=arr[end]) {
					start  = mid+1;
				}
				else {
					end = mid-1;
				}
			}
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		int [] arr = {7,8,9,1,2,3,4,5,6};
		
		System.out.println(binarySearchInRotatedSortedArray(arr,66));
	}
}
