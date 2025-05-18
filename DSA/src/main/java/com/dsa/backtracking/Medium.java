package com.dsa.backtracking;

public class Medium {
	
	/*
	 * 2. Target Sum Subset : you are given an array you need to find all the subset 
	 *whose sum is equal to the target 
	 */
	
	public static boolean findTarget(int [] values,int index, int target) {
		
		 if(target==0 && index!=0) {
		     return true;
		 }
		 if(values.length==index ) {
			 return false;
		 }
		
		 if(values[index]<=target) {
			boolean b1 =  findTarget(values,index+1,target-values[index]);
			 boolean b2 = findTarget(values,index+1,target);
			 
			 return b1 || b2;
		 }
		 else {
			 return findTarget(values,index+1,target);
		 }
	}
	
	
	 /* DenominationProblems...
	  * Given an array coins[] of size N and a target value sum, where coins[i] represents the coins of different 
	  * denominations. You have an infinite supply of each of coins. The task is to find minimum number of coins 
	  * required to make the given value sum. If it’s not possible to make a change, print -1.
	 */
	
	 public static int helperMethod(int [] coins , int sum,int index,int count){
		   
		 
		 
		 
		    if(sum==0) return count;
		    if(index<0) return Integer.MAX_VALUE;
		    
		    if(sum>=coins[index]){
		     return Math.min(helperMethod(coins,sum,index-1,count),
		     helperMethod(coins,sum-=coins[index],index,count+1));
		    }
		    else{
		       return helperMethod(coins,sum,index-1,count);
		    }
		}
		    public static int minCoins(int coins[], int sum) {
		      //  Arrays.sort(coins);
		       int i= helperMethod(coins,sum,coins.length-1,0);
		       
		       if(i==Integer.MAX_VALUE) return -1;
		       else return i;
		    }
		    
		// Unbounded Knapsack ( you can take an element infinite times
	    public static int unboundedKnapsack(int [] val ,int [] weight,int index,int maxWeight) {
	    	return 0; //sif(maxWeight==0 || )
	    }
		    
		    public static void main(String[] args) {
				int [] values = {4,2,7,1,3};
				System.out.println(findTarget(values,0,17));
				
			}
		    
	

}
