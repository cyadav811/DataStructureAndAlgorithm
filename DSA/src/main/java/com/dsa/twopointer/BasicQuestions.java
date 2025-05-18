package com.dsa.twopointer;

import java.util.Arrays;
import java.util.*;

public class BasicQuestions {
	
	
	/*
	 * They have an array ‘NUMS’ of length ‘N’. Ninja’s friend gives him an arbitrary 
	 * integer ‘K’ and asks him to find the length of the longest subarray in which 
	 * the sum of elements is equal to ‘K’.
	 */
	public static int getLongestSubarray(int []nums, int k) {
		Map<Integer,Integer> map = new LinkedHashMap<>();

		int sum = 0;
		int ans = 0;
		map.put(0,-1);

		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			if(map.containsKey(sum-k)){
                  ans = Math.max(ans,i-map.get(sum-k));
			}
			if(!map.containsKey(sum)){
				map.put(sum,i);
			}
		}

		return ans;
	}
	
	
// You are given an array you need to find such pair whose sum is equal to k 
	public static int [] pair(int [] values, int k) {
		 
		Arrays.sort(values);
		
		int start = 0;
		int end = values.length-1;
		
		while(start<end) {
			
			if(values[start]+values[end]==k) {
				return new int[]{start,end};
			}
			if(values[start]+values[end]>k) {
				end--;
			}
			if(values[start]+values[end]<k) {
				  start++;
			}
		}
		
		return new int[]{-1,-1};
	}
	
	
	public static void main(String[] args) {
		int [] arr = {-1, 0, 1, 1, -1, -1, 0};
		getLongestSubarray(arr,0);
	}
}
