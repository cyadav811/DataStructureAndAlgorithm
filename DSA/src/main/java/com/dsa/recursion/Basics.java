package com.dsa.recursion;

import java.util.Arrays;

// Recursion is recurrence of something.. if a function is calling itself then it is known as recursion.
//KeyPoint : You should know when the recursion call stop calling the same function (base case and safety case)
// Point of application : if a problem is dependent on smaller version of same kind of problem then 
// at such condition we have to apply recursion. 

// Types of recrusion : head Recursion : if a function call is the first statement then it is known as the 
// head recursion and in tail recursion the function call is the last statement.
public class Basics {
// 0-1 Knapsack using Recursion 
	public static int knapSack(int [] val,int [] weight,int index,int maxWeight,int [][]dp) {
		if(maxWeight<=0 || index==val.length) return 0;
		
		if(dp[index][maxWeight]!=-1) {
			return dp[index][maxWeight];
		}
		if(weight[index]<=maxWeight) {
			dp[index][maxWeight] = Math.max(val[index]+knapSack(val,weight,index+1,maxWeight-weight[index],dp), 
					knapSack(val,weight,index+1,maxWeight,dp));
			
			return dp[index][maxWeight];
		}
		else {
			dp[index][maxWeight]=  knapSack(val,weight,index+1,maxWeight,dp);
			return dp[index][maxWeight];
		}
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
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[vLength][maxSize];
	}
	
	// Target Sum SubSet 

	
	
	public static void reverseArray(int [] arr, int n) {
		if(n==arr.length/2) return;
		int temp = arr[n-1];
		arr[n-1]= arr[arr.length-n];
		arr[arr.length-n]=temp;
		
		reverseArray(arr,n-1);
		
	}
	//String is palindrome 
	public static boolean isPalindorme1(String str, int index){
        if(index==str.length()/2 || index==0)  return true;

        if(str.charAt(index)==str.charAt(str.length()-index-1)) return isPalindorme1(str,--index);
        else return false;
    }
	public static void main(String[] args) {
		
		String str = "amanaplanacanalpanama";
		
		isPalindorme1(str,str.length()-1);
		
		int [] arr = {1,2,3,4,5,6};
		
       reverseArray(arr,6);
       
       System.out.println(Arrays.toString(arr));
		int [] val = {15,14,10,45,30};
		int [] weight = {2,5,1,3,4};
		int [][]dp = new int[val.length+1][7+1];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=-1;
			}
		}
		
		int pro= knapsack1(val,weight,7);
		System.out.println(pro);
		
		
		
		
	}
}
