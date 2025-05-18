package com.dsa.basicMathematics;

public class Maths {
	public static boolean isPrime(int n) {
		
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) return false;
		}
		
		return true;
	}
	
	
	//The time complexicity of such system is n root n
	public static void printPrimeNoTillN(int n) {
		for(int i=2;i<=n;i++) {
			if(isPrime(i)) {
				System.out.print(i);
			}
		}
	}
	
	// Reducing the time compleixicity of such system using Seive Method. 
    // According to the seive method initially assume that all the number are prime. 
	// then mark the numbers which are divisor of any other number as non prime number.
	public static void primeTillN(int n) {
		
		boolean [] isPrime = new boolean [n+1];
		
		for(int i=2;i*i<=n;i++) {
			if(isPrime[i]==false)
			for(int j = i*i;j<=n;j+=i) {
				isPrime[j] = true;
			}
		}
		
		for(int i=2;i<=n;i++) {
			System.out.print(isPrime[i]==false?i+" ":"");
		}
	}
	
	
	public static void primeTill(int n) {
		for(int i=2;i<=n;i++) {
			if(isPrime(i)) {
				System.out.print(i+" ");
			}
		}
	}

	
	
	// Exactly three divisor
	// if a number is exactly having 3 divisors then it should be a perfect square root. 
	// and not divisible by any other number.  Divisible by -> 1, perfect square root and no itself
	 public static boolean exactlyThreeDivisor(long number){
         long root = (long) Math.sqrt(number);
           if(root*root!=number) return false;
           
        int count = 0;
        long i;
        for(i = 2;i*i<number;i++){
            if(count>0) return false;
            if(number%i==0) count+=2;
        }
        
        return true;
    }
	 
	 
	 
	 // this is another best approach to find how many numbers are there 
	 // till 1-n which is having exactly 3 divisors. 
	 
	 
	 public static int primeTillRootN(long n){
	        int root =(int) Math.sqrt(n);
	        boolean [] isPrime = new boolean [root+1];
			
			for(int i=2;i*i<=root;i++) {
				if(isPrime[i]==false)
				for(int j = i*i;j<=n;j+=i) {
					isPrime[j] = true;
				}
			}
			int count =0;
			
			for(int i=2;i<=root;i++){
			    if(isPrime[i]==false){
			        count++;
			    }
			    
			}
			
			return count;
	    }
	 
	 
	 public static void main(String...strings) {
			
			
			 long val = System.currentTimeMillis();
			primeTillN(1000000);
			long val1 = System.currentTimeMillis(); 
			System.out.println();
			
			System.out.println(val1-val);
			
			System.out.println();
			
			 long val2 = System.currentTimeMillis();
			 primeTill(1000000);
				long val3 = System.currentTimeMillis();
				 System.out.println();
				System.out.println(val3-val2);
		}

}
