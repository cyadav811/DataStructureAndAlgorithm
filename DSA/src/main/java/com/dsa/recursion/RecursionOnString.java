package com.dsa.recursion;

public class RecursionOnString {
	
	// Reverse a String using Recursion 
	// here the concept of the head recursion is used 
	public static String reverseString(String str) {
		
		if(str==null || str.length()<=1) {
			return str;
		}
		
		return reverseString(str.substring(1))+str.charAt(0);
	}
	
	
	// Find all the subsequences of a string using Recursion 
	
	public static int counter =0;
	public static void printAllSubSequences(String str,String ans,int index) {
		if(str.length()==index) {
			System.out.print(ans+" ");
			counter++;
		     return ;
		}
		
		 
		 printAllSubSequences(str,ans,index+1);
		 printAllSubSequences(str,ans+str.charAt(index),index+1);
	}
	
	
	public static void main(String[] args) {
		printAllSubSequences("Chandra","",0);
		System.out.println();
		System.out.println(counter);
	}

}
