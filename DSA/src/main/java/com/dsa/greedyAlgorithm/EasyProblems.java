

//Greedy Algorithm : Greedy algorithm is a classes of algorithm that makes locally optimal
// choices at each step with the hope of finding a global 
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
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class EasyProblems {
/* 1.
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
	 
	
	 
		    
		    // 2.
		    //You are given n activities with their start and end times. Select the maximum number of activities that
		    // can be performed by single person. Assuming that a person can only work on a single
		    //activity at a time. 
		    // Approach : You should be greedy. Sort the activities based on thier end times 
		    // because 
		    public static int maxActivities(int [] start, int [] end) {
		    	int length = start.length;
		    	String str ="";
		    	
		    	int [][] activities = new int[length][3];
		    	
		    	for(int i=0;i<length;i++) {
		    		activities[i][0]=i;
		    		activities[i][1]=start[i];
		    		activities[i][2]=end[i];
		 
		    	}
		    	
		    	Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
		    	
		    	
		    	int count =0;
		    	int time =0;
		    	int i=length-1;
		    	while(i>=0) {
		    		if(activities[i][2]>=time) {
		    			str+=" "+activities[i][0];
		    			count++;
		    			time++;
		    			i++;
		    		}
		    		else {
		    			break;
		    		}
		    	}
		    	System.out.println(str);
		    	return count;
		    	
		    }	    
		    
// 3.
/*
 * Given the weights and profits of N items, in the form of {profit, weight} 
 * put these items in a knapsack of capacity W to get the maximum total profit in the knapsack.
 *  In Fractional Knapsack, we can break items for maximizing the total value of the knapsack.
 */	    
 public static  double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
		        
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

 //4. Given an array of Jobs where every job has a deadline and profit if the job 
 // is finished before the deadline. It is also given that every Job takes a single unit of time.
 // So the minimium possible deadline for every job is 1. 
 // Maximize the total profit if only one job can be scheduled at a time. 
 
 // here the condition is that every job takes 1 unit of times. 
 // prioritize the jobs based on the maximum profit..(Be greedy at every point)
 public static int JobSequencing(int [][] jobs) {
	 int sum =0;
	 int currentInterval = 0;
	 
	 
	 Arrays.sort(jobs, (a,b)->Integer.compare(a[1], b[1]));
	 int i = jobs.length;
	 while(i>=0) {
		 if(currentInterval<=jobs[i][0]) {
			 currentInterval++;
			 sum +=jobs[i][1];
		 }
	 }
	 
	 return sum;
 }
	
 
 
 
 //5. Minimum Absolute Difference Pairs.
 // Given Arrays A and B of equal length n. Pair each element of array A to an element of Array B.
 // Such that sum of absolute difference of all the pairs is minimum
 public static int minAbsDiff(int [] A, int [] B) {
	 
	 
	 Arrays.sort(A);
	 Arrays.sort(B);
	 int sum =0;
	 
	 for(int i=0;i<A.length;i++) {
		 sum+=Math.abs(A[i]-B[i]);
	 }
	  
	 return sum;
 }
 
 //6. Max Length Chain of Pairs..
 /*
  * You are given n pairs of numbers. In every pair the first number is always smaller than the second number.
  * A pair(c,d) can come after (a,b) if b<c
  * find the longest chain which can be formed from a given set of pairs.
  * 
  *
  */
 public static String maxLenChain(int [][] pairs) {
	 int[][] ar = new int[pairs.length][3];
	 
	 for(int i=0;i<pairs.length;i++) {
		 ar[i][0]=i;
		 ar[i][1] = pairs[i][0];
		 ar[i][2] = pairs[i][1];
	 }
	 
	 Arrays.sort(ar,(a,b)->Integer.compare(a[2],b[2]));
	 
	 String str = ""+ar[0][0];
	 int count =1;
	 for(int i=1;i<ar.length;i++) {
		 if(ar[i][1]>ar[i-1][2]) {
			 str+=" "+ar[i][0];
			 count++;
			 
		 }
	 }
	 
	 return "Sequence of Pairs :"+str+ "\n Total pairs: "+count;
 }
		    public static void main(String[] args) {
		    	
		    	int[][] pairs = { {5, 24}, {15, 25}, {27, 40}, {50, 60} };
		    	
		    	System.out.println(maxLenChain(pairs));
		    	
			
			}



		    
		    // Try to relate this question 
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

