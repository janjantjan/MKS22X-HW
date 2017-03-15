import java.util.*;

public class Quick{

    public static int[] part (int[] ary, int start, int end){
	int index = randInt(start, end);
	int num = ary[index];
	System.out.println("pivot: " + num);
	int last = ary.length-1;
	ary[index] = ary[last];
	ary[last] = num;
	System.out.println(makeString(ary));
	int x = start;
	for (int i = start; i < end;i++){
	    if (ary[last-1] < num){
		int less = ary[last-1];
		ary[last-1] = ary[i];
		ary[x] = less;
		x++;
System.out.println(makeString(ary));
	    }
	    if (ary[last-1] >= num){
		int more = ary[last-1];
		ary[last-1] = num;
		ary[last] = more;
		last--;
System.out.println(makeString(ary));
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
