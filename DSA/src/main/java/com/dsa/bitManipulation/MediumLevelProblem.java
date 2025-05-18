package com.dsa.bitManipulation;

public class MediumLevelProblem {

	// Target Sum 
	public static boolean targetSum(int [] values, int target) {
		
		int leng = values.length;
		
		for(int i=0;i<Math.pow(2, leng);i++) {
			
				String binary = Integer.toBinaryString(i);
				
				int currentTarget = target;
				String str = "";
				for(int j=binary.length()-1;j>=0;j--) {
					
					//System.out.println("i "+i+" Current Target "+currentTarget+" j"+j);
					
					if(binary.charAt(j)=='1') {
						str+=" "+values[binary.length()-j-1];
						currentTarget-=values[binary.length()-j-1];
						
					}
					if(currentTarget==0) {
						return true;
					}
				}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		int [] values = {4,2,7,1,3};
		System.out.println(targetSum(values,0));
	}
}
