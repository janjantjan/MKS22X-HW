import java.util.*;

public class Driver {

    public static int randInt(int min, int max) {
  	Random rand =  new Random();
	int randomNum = rand.nextInt((max - min) + 1) + min;
	return randomNum;
    }

    private static boolean check (int[] a, int[] b){
	if (a.length != b.length ) {return false;}
	for (int i = 0; i < a.length; i++){
	    if (a[i] != b[i]){return false;}
	}
	return true;
    }
    
    public static boolean testRep (int length) {
	int[] revAns = new int[length];
	int[] revMerge = new int[length];
	for (int i = 0 ; i < revAns.length; i++){
	    int x = randInt(0,length);
	    revAns[i] = x;
	    revMerge[i] = x;
		}
	
	//System.out.println(Merge.makeString(revMerge));
	Merge.mergesort(revMerge);
	Arrays.sort(revAns);

	
	//System.out.println( "\n Ans:" + Merge.makeString(revAns) + "\n MERGED: " + Merge.makeString(revMerge));

	return check(revMerge, revAns);
	
    }

    public static boolean testReverse (int length){
	int[] revAns = new int[length];
	int[] revMerge = new int[length];
	for (int i = 0; i < length; i++){
	    revAns[i] = length - i;
	    revMerge[i] = length - i;
	}

	//System.out.println(Merge.makeString(revMerge));
	Arrays.sort(revAns);
	Merge.mergesort(revMerge);

	//System.out.println("\n Ans:" + Merge.makeString(revAns) + "\n MERGED: " + Merge.makeString(revMerge));
	
	return check(revMerge, revAns);
    }

    public static boolean testOrdered (int length){
	int[] revAns = new int[length];
	int[] revMerge = new int[length];
	for (int i = 0; i < length; i++){
	    revAns[i] = i;
	    revMerge[i] = i;
	}
	//System.out.println(Merge.makeString(revMerge));
	Arrays.sort(revAns);
	Merge.mergesort(revMerge);
	//System.out.println( ": " + "\n Ans:" + Merge.makeString(revAns) + "\n MERGED: " + Merge.makeString(revMerge));
		return check(revMerge, revAns);
    }


    public static boolean testNoRep (int length){
	int[] prevAns = new int[length];
	int[] prevMerge = new int[length];
	for (int i = 0; i < length; i++){
	    prevAns[i] = i;
	    prevMerge[i] = i;
	}
	int[] revAns = new int[length];
	int[] revMerge = new int[length];
	for (int i = 0; i < length-1;){
	    int x = randInt(0,length-1);
	    if (prevAns[x] != 0){
		revAns[i] = prevAns[x];
		revMerge[i] = prevMerge[x];
		i++;
		prevMerge[x]=0;
		prevAns[x]=0;}
	}	

	//System.out.println(Merge.makeString(revMerge));
	Arrays.sort(revAns);
	Merge.mergesort(revMerge);

	//System.out.println( "\n Ans:" + Merge.makeString(revAns) + "\n MERGED: " + Merge.makeString(revMerge));
	
	return check(revMerge, revAns);
    }
    
    public static void main (String[]args){
	System.out.println(testRep(100000000)); //10^8 is slow
	System.out.println(testReverse(100000000)); //10^8 is slow
	System.out.println(testOrdered(100000000)); //10^8 is slow
	System.out.println(testNoRep(10000000)); //10^8 is slow
    }
}
    

	   

    
