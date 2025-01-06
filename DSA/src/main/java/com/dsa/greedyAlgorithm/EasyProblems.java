

//Greedy Algorithm : Greedy algorithm is a classes of algorithm that makes locally optimal choices at each step with the hope of finding a global 
//optimal solution...
//Greedy algorithm is the problem solving technique where we make the locally optimaum choices at each stage and hope to achieve a global 
//optimum solution.
//Advantages : Simple, Easy Good enough time complexicity.
//Disadvantages : A lot of time optimization is not achieved. 
//
//
//Optimization Problems : Greedy algorithm works on optimization problems means : min,max, least type of problems.
//
//Where to use the greedy Algorithm : 
//1.Optimization Problems : Sorting the problem....
 
package com.dsa.greedyAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class EasyProblems {
/*
 * Assume you are an awesome parent and want to give your children some cookies. But, 
 * you should give each child at most one cookie.Each child i has a greed factor g[i],
 *  which is the minimum size of a cookie that the child will be content with;
 *   and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, 
 *   and the child i will be content. Your goal is to maximize the number of your content children and
 *    output the maximum number.
 */
	 public int findContentChildren(int[] g, int[] s) {
	        int contentChildren = 0;
	        Arrays.sort(g);
	         Arrays.sort(s);
	        int i=0;
	        int j =0;
	        while(i<g.length && j<s.length){
	            if(g[i]<=s[j]){
	               contentChildren++;
	               i++;
	               j++; 
	            }
	            else{
	                j++;
	            }
	        }
	      return contentChildren;
	    }
	 
	 
	 /* DenominationProblems...
	  * Given an array coins[] of size N and a target value sum, where coins[i] represents the coins of different 
	  * denominations. You have an infinite supply of each of coins. The task is to find minimum number of coins 
	  * required to make the given value sum. If it’s not possible to make a change, print -1.
	 */
//	 
//	 static int minCoins(int coins[], int sum) {
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
		    
		    
		    
		    
		    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
		        
		        List<Obj> objList = new ArrayList<>();
		        
		        for(int i=0;i<val.size();i++){
		            Obj ob = new Obj((double)val.get(i),(double)wt.get(i));
		            objList.add(ob);
		        }
		        Collections.sort(objList,(x,y)->Double.compare((y.value/y.weight),(x.value/x.weight)));
		        
		        double ans =0;int i=0;
		        while(capacity>0 && i<objList.size()){
		            if(capacity>=objList.get(i).weight){
		                ans = ans + (objList.get(i).value);
		                capacity-=objList.get(i).weight;
		                i++;
		            }
		            else{ans = ans + (objList.get(i).value)*(capacity/objList.get(i).weight);  
		              capacity= 0;
		            }
		        }
		        
		         return ans;
		       }
		    
		    public static void main(String[] args) {
				int [] coins = {936 ,917, 205 ,483, 345, 307, 117, 20 ,679};
				System.out.println(minCoins(coins,662));
				
//				   int[] coins = {20, 117, 205, 307, 345, 483, 679, 917, 936};
//			        int target = 662;
//
//			        if (canMakeSum(coins, target)) {
//			            System.out.println("Possible to make the sum of 662 with the given coins.");
//			        } else {
//			            System.out.println("Not possible to make the sum of 662 with the given coins.");
//			        }
			}



    public static boolean canMakeSum(int[] coins, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: Zero sum is always possible.

        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                if (dp[i - coin]) {
                    dp[i] = true;
                }
            }
        }

        return dp[target];
    }
}


class Obj{
    public Double value;
    public Double weight;
    public Obj(Double value,Double weight){
        this.value = value;
        this.weight = weight;
    }
}

