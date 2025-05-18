package com.dsa.basicAlgorithm;
import java.util.*;

public class SweepLineAlgorithm {
	
	

	public static void main (String[] args) throws java.lang.Exception
	{
		
		System.out.println('c'-'a');
		
		Scanner s = new Scanner(System.in);
		//String inputString = s.nextLine();*/
        
         Map<Integer,Integer> ansMap = new TreeMap<>();
         int n = s.nextInt();
         s.nextLine();
      
      for(int i=0;i<n;i++){
       String str = s.nextLine();
        String [] inputs = str.split(" ");
        
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);
        
        ansMap.put(start,ansMap.getOrDefault(start,0)+1);
        ansMap.put(end+1,ansMap.getOrDefault(end+1,0)-1);
      }
      
      for (Map.Entry<Integer, Integer> entry : ansMap.entrySet()) {
           System.out.println(entry.getKey()+" "+entry.getValue());
        }
      
      System.out.println("______________________________________________________");
      int maxHappy = Integer.MIN_VALUE;
      int currentHappy =0;
      int sweets = 0;
     for (Map.Entry<Integer, Integer> entry : ansMap.entrySet()) {
       currentHappy += entry.getValue(); 
       if (currentHappy > maxHappy) {
         maxHappy = currentHappy; 
         sweets = entry.getKey();
       } 
     }
      System.out.println(sweets + " " + maxHappy);  
        
      }
}
