package com.dsa.functionalInterface;
import java.util.*;

public class Tester {
	public static void main(String[] args) {
	      Scanner scan = new Scanner(System.in);
		  int n = scan.nextInt();

		  int temp = n;
	      int ans = 0;

	while(temp>0){
		int val = temp%10;
		temp = temp/10;
      ans = ans+(int)Math.pow(val,3);
	}
	System.out.println(ans==n);

  scan.close();
	}
}


interface MathematicalOperation{
	public int operation(int a,int b);
}

class Addition implements MathematicalOperation{

	@Override
	public int operation(int a, int b) {
		return a+b;
	}
	
}