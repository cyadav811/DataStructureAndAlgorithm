package com.dsa.string;
import java.util.*;

public class Lexograhpical {
	
	public static String smallestLexographicalString(String bead,int k){
		System.out.println();
	    StringBuilder ans = new StringBuilder(bead);
	    StringBuilder currentBead = new StringBuilder(bead);
	    for(int i=0;i<bead.length();i++){
	      char c = currentBead.charAt(k-1);
	      currentBead.deleteCharAt(k-1);
	      
	      currentBead = currentBead.append(c);
	      
	      
	      int comparision = ans.toString().compareTo(currentBead.toString());
	     // System.out.println(ans.toString()+" "+currentBead.toString()+" "+comparision+" "+i);
	       if(comparision>0){
	    	  // System.out.println(ans.toString()+" "+currentBead.toString()+" "+comparision+"!!!!!"+i);
	         ans = new StringBuilder(currentBead.toString());
	         //System.out.println(ans.toString()+" "+currentBead.toString()+" "+comparision+"######"+i);
	       }
	    }
	    return ans.toString();
	  }
		public static void main (String[] args) throws java.lang.Exception
		{
			
			Scanner s = new Scanner(System.in);
	      int n = s.nextInt();
	          s.nextLine();
		for(int i=1;i<=n;i++){
	         String bead = s.nextLine();
	         String [] ss = bead.split(" ");
	         System.out.println(smallestLexographicalString(ss[1],Integer.parseInt(ss[0])));
	    }
			
			//System.out.println("Hello");
		}
	}
