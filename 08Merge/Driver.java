import java.util.*;

public class Driver {

    public static int randInt(int min, int max) {
  	Random rand =  new Random();
	int randomNum = rand.nextInt((max - min) + 1) + min;
	return randomNum;
    }

    
    public static boolean testRep (int length) {
	int[] rev = new int[length];
	for (int i = 0 ; i < rev.length; i++){
	    rev[i] = randInt(0,length);
	}
	System.out.println (Merge.makeString(rev));
	int[]revAns = rev;
	int[]revMerge = rev;

	Merge.mergesort(revMerge);
	
	Arrays.sort(revAns);
System.out.println (Merge.makeString(revMerge));
	return (revAns == revMerge);
    }

    public static void main (String[]args){
	System.out.println(testRep(100));
    }
}
    

	   

    
