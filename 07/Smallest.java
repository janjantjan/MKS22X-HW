import java.util.*;

public class Smallest{
    public static int[] part (int[] ary, int start, int end){
	int index = randInt(start, end);
	int num = ary[index];
	System.out.println("pivot: " + num);
	int last = ary.length-1;
	ary[index] = ary[last];
	ary[last] = num;

	for (int i = start; i < end; i++){
	    if (ary[end-i] < num){
		int less = ary[end-1];
		ary[end-1] = ary[i];
		ary[i] = less;
	    }
	    else{
		ary[index]=ary[index-1];
		ary[index-1] = num;
		index--;
	    }
	}
		 
	return ary;	

	

    }

    public static int randInt(int min, int max) {
  
	Random rand =  new Random();
	int randomNum = rand.nextInt((max - min) + 1) + min;
	return randomNum;
    }


    public static String  makeString (int[] ary){
	String fin = "";
	for (int i = 0; i < ary.length; i++){
	    fin += ary[i] + " ";
	}
	return fin;
    }


    public static void main (String[]args){
	int[] n = new int [10];
	n[0] = 5;
	n[1] = 9;
	n[2] = 1;
	n[3] = 10;
	n[4] = 8;
	n[5] = 2;
	n[6] = 3;
	n[7] = 6;
	n[8] = 4;
	n[9] = 7;
	System.out.println(makeString(n));
	part(n, 0, 9);
	System.out.println(makeString(n));
    }
}
						 
