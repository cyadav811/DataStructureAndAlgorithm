package com.dsa.stack;

public class BasicQuestion {
	
	
	public static boolean validParanthesis(String str) {
		
		Stack<Character> stack = new Stack<>(str.length());
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==')'  && stack.peek()!=null && stack.peek()=='(') {
				stack.pop();
			}
			else if(str.charAt(i)=='}'  && stack.peek()!=null && stack.peek()=='{') {
				stack.pop();
			}
			else if(str.charAt(i)==']'  && stack.peek()!=null && stack.peek()=='[') {
				stack.pop();
			}
			else {
				stack.push(str.charAt(i));
			}
		}
		
		return stack.isEmpty();
	}

	
	
	//Given an integer array of distinct element. For every subarray find the summession of max element - min element.
	
    public static int sumOfMaxMin(int [] array) {
    	int sum = 0;
    	for(int i=0;i<array.length;i++) {
    		int min = array[i];
    		int max = array[i];
    		for(int j=i+1;j<array.length;j++) {
    			min = min<array[j]?min:array[j];
    			max = max>array[j]?max:array[j];
    				sum-=min;
                	sum+=max;
              //  System.out.println(max+" "+min);
    		}
    		
    	}
    	return sum;
    }
	
	public static void main(String ...strings) {
		boolean ans = validParanthesis("{{[()]}");
		System.out.println(ans);
		
		int [] arr = {12,123,12,1,11,16,15,2,0,1,11};
		
		for(int i=0;i<arr.length;i++) {
			String val = " "+arr[i];
			System.out.println(val);
			for(int j =i+1;j<arr.length;j++) {
				
				val+=" "+arr[j];
				System.out.println(val);
			}
		}
		
		System.out.println("!!!!!!!!!!"+sumOfMaxMin(arr));
		
	}
}
