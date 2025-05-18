package com.dsa.dynamicProgramming;

import java.util.Arrays;

/*
 * Dynamic Programming : Dynamic Programming is a technique in computer programming that helps to efficiently solve
 * a class of problem that have overlapping(choices) and optimal substructure property. 
 * Dynamic programming is used when one can break a problem into minor issues that they can break down even 
 * further small problems. 
 * Additionally, these sub problems have overlapped. That's why we required previously calculate values 
 * to be compared. 
 *  
 *  1. Optimal Sub-Structure : If you can find optimal solution of subproblems then you can have optimal solution 
 *  to a bigger problem (that is dependent on subproblems)...
 *  
 *  2. Overlapping Sub Problems : DP is used for overlapping sub problems. 
 *  
 *  How to identify a problem is a dynamic Programming Problem ?
 *  1. All problems that requires maximizing , min certain quantities or counting problems
 *   under certain condition  (Optimal Problem) least, most, min, max,largest smallest
 *  2. All the DP problems satisfy overlapping subproblems. (choices ) 
 *  
 *  
 *  DP is optimized recursion 
 *  
 *  Ways to solve a dynamic programming ? 
 *  Memoization (top Down) -> recursion+storing solution of subproblems.
 *  2. Tabulation(bottom up approach) -> iterations +storing subproblems in tabular form.
 *  
 *  Tabulation is more efficient in dynamic programming 
 *  We can solve most of the problems in dyanmic programming with the help of the recursion 
 *  but in some cases it may occur stack out flow. 
 */
public class BasicsOfDp {

	
	// fibonacci series
	//top down approach to solve fibonacci series
	// Storing the previously calculated values inside memory to aviod recaculation of 
	// small problems solution
	public static int fibonacci(int n,int [] arr) {
		if(n==0 || n==1) return n; 
		if(arr[n]!=-1) {
			return arr[n];
		}
		arr[n]=fibonacci(n-1,arr)+fibonacci(n-2,arr);
		return arr[n];
	}
	
	//bottomUp
	public static int fib(int n) {
		
		if(n<0) return -1;
		if(n<=1) return n;
		
		int [] arr = new int[n+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<arr.length;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[n];
	}
	
	public  static int knapsack1(int [] value,int [] weight ,int maxSize) {
		int vLength = value.length;
		
		int [] [] dp = new int[vLength+1][maxSize+1];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
					continue;
				}
				
				int val = value[i-1];
				int weig = weight[i-1];
				
				if(weig<=j) {
					int consid = val+dp[i-1][j-weig];
					int nonConsi = dp[i-1][j];
					
					dp[i][j]=Math.max(consid, nonConsi);
				}
				else {
					dp[i][j]= dp[i-1][j];
				}
			
			}
		}
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		return dp[vLength][maxSize];
	}
	
	
  public static int recursionSolutionOfKnapSack1(int [][] dp,int [] value,int index,int [] weight, int maxWeight) {
	  
	  if(maxWeight==0 || index<0) {
		  return 0;
	  } 
	  if(dp[index][maxWeight]!=-1) {
			 return dp[index][maxWeight];
		 }
	 if(maxWeight>=weight[index]) {
		
		 int including = value[index]+recursionSolutionOfKnapSack1(dp,value,index-1, weight,maxWeight-weight[index]);
		 int excluding = recursionSolutionOfKnapSack1(dp,value,index-1, weight,maxWeight);
		 
		 dp[index][maxWeight]= Math.max(including, excluding);
		 return dp[index][maxWeight];
		 
	 }
	  
	 else {
		 dp[index][maxWeight]= recursionSolutionOfKnapSack1(dp,value,index-1, weight,maxWeight);
		 return dp[index][maxWeight];
	 }
  }
  
  
  public static boolean targetSumRecursion(boolean [][] dp, int [] value, int index, int target) {
	  if(target==0) return true;
	  if(index<0) return false;
	  
	  if(dp[index][target]) {
		  return dp[index][target];
	  }
	  if(target>=value[index]) {
		 boolean  include = targetSumRecursion(dp,value,index-1,target-value[index]);
		 boolean exclude = targetSumRecursion(dp,value,index-1,target);
		 dp[index][target]= include|| exclude;
		 return dp[index][target];
	  }
	  else {
		  dp[index][target]=  targetSumRecursion(dp,value,index-1,target);
		  return dp[index][target];
	  }
  }
	
	
	
	public  static boolean targetSum(int [] value,int target) {
		int vLength = value.length;
		
		if(target==0) return true;  //(empty set) for not taking any element from the list
		
		boolean [] [] dp = new boolean[vLength+1][target+1];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0 || j==0) {
					dp[i][j]=false;
					continue;
				}	
			  boolean b = dp[i-1][j];
			  int val = value[i-1];
			  
			  if(val==j || b) {
				  dp[i][j]= true;
				  continue;
			}
			  if(((j-val)>=0) && dp[i-1][j-val] ) {
				  dp[i][j]=true;
			  }
		}
		
	}
		
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}

		return dp[vLength][target];
	}
	
	public static void main(String[] args) {
		int [] value = {60,100,120};
		int [] weight = {1,2,3};
		int maxWeight = 11;
		

		
		System.out.println(knapsack1(value,weight,5));
		int [][] dp = new int[weight.length][maxWeight+1];
		
		for(int [] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(recursionSolutionOfKnapSack1(dp,value,weight.length-1,weight,5));
		
		System.out.println("++++++++++++++");
		
		int [] values = {4,2,7,1,3};
		System.out.println(targetSum(values,4));
		System.out.println(targetSum(values,2));
		System.out.println(targetSum(values,7));
		System.out.println(targetSum(values,1));
		System.out.println(targetSum(values,3));
		System.out.println(targetSum(values,6));
		System.out.println(targetSum(values,18));
		System.out.println(targetSum(values,11));
		System.out.println(targetSum(values,9));
		System.out.println(targetSum(values,13));
		System.out.println(targetSum(values,14));
		
		System.out.println("++++++++++++++++++++++++++++++++++");
		int target = 17 ;
		boolean [][] dp1 = new boolean[values.length][target+1];
		System.out.println(targetSumRecursion(dp1,values,values.length-1,target));
		
		
	}
 
}
