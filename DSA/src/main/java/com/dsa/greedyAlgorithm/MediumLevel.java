package com.dsa.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MediumLevel {

	 //1.Remaining with this problem....(backtracking-> medium problem1)
	 /* DenominationProblems...
	  * Given an array coins[] of size N and a target value sum, where coins[i] represents the coins of different 
	  * denominations. You have an infinite supply of each of coins. The task is to find minimum number of coins 
	  * required to make the given value sum. If it’s not possible to make a change, print -1.
	 */
//	 
//	public static int minCoins(int coins[], int sum) {
//		 
//		 Arrays.sort(coins);
//		 int i = coins.length-1;
//		 
//		 int noOfCoins =0;
//		 
//		 
//		 while(i>=0  && sum>0) {
//			 if(sum>=coins[i]) {
//				 noOfCoins = sum/coins[i];
//				 sum = sum%coins[i];
//			 }
//			 else {
//				 i--;
//			 }
//		 }
//		 
//		 
//		 if(sum>0) return -1;
//		 else return noOfCoins;
//		 
//	 }

	
	
//2.Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of 
//intervals you need to remove to make the rest of the intervals non-overlapping.
//Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] 
//are non-overlapping.
	  public static int eraseOverlapIntervals(int[][] intervals) {
	      Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
	     int count =0;
	     int currentInterval=intervals[0][0];

	    // lst.forEach(System.out::print);
	     for(int i=0;i<intervals.length;i++){
	        if(currentInterval<intervals[i][1] && currentInterval<=intervals[i][0]  ){
	        	 currentInterval = intervals[i][1];
	            
	        }
	        else{
	        	count++;
	        }
	     
	     }
	        return count;
	    }
	  
	  
	  //3.Chocola Problem
	  /*
	   * WE are given a box of chocolate composed of m*n square pieces. One should break chocolate into 
	   * single square. Each break of a part of the chocolate is charged a cost expressed by a positive integer. 
	   * This cost does not depend on the size of the part that is being broken but only depends on the line 
	   * of the break goes along. Let us denote the cost of breaking along consecutive vertical lines with 
	   * x1,x2,x3.... and along horizontal lines with y1,y2,y3....
	   * Compute the minimum cost of breaking the whole chocolate into single squares. 
	   */
	  public static int findTotalCost(int [] n, int []m) {
		//  Initially both horizontal and vertical part is a single part
		  int hCuts =1;
		  int vCuts =1;
		  Arrays.sort( n);
		  Arrays.sort(m);
		  int i = n.length-1;
		  int j = m.length-1;
		  int totalCost =0;
		  
		  while(i>=0 && j>=0) {
			  if(n[i]>m[j]) {
				  totalCost = totalCost+ n[i]* vCuts;
				  hCuts++;
				  i--;
			  }
			  else {
				  totalCost = totalCost+ n[j]* hCuts;
				  vCuts++;
				  j--; 
			  }
		  }
          while(i>=0) {
        	  totalCost = totalCost+ n[i]* vCuts;
			  hCuts++;
			  i--; 
		  }
        while(j>=0) {
        	 totalCost = totalCost+ n[j]* hCuts;
			  vCuts++;
			  j--; 
           }
        return totalCost;
	  }
	  
	  public static void main(String[] args) {
			int [] coins = {936 ,917, 205 ,483, 345, 307, 117, 20 ,679};
			//System.out.println(minCoins(coins,662));
			
//			   int[] coins = {20, 117, 205, 307, 345, 483, 679, 917, 936};
//		        int target = 662;
//
//		        if (canMakeSum(coins, target)) {
//		            System.out.println("Possible to make the sum of 662 with the given coins.");
//		        } else {
//		            System.out.println("Not possible to make the sum of 662 with the given coins.");
//		        }
	}
	   
	}

