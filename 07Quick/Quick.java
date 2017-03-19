import java.util.*;

public class Quick{

    public static int part (int[] ary, int start, int end){
	int pivot = randInt(start, end-1);
	System.out.println(makeString(ary));
	System.out.println("pivot: " + ary[pivot]);
	change (ary, end-1, pivot);
	System.out.println(makeString(ary));
	int pivpoint = end - 1;
	
	for (int i = start; i < pivpoint;){
	    if (ary[pivpoint-1] < ary[pivpoint]){
		change(ary, i, pivpoint-1);
		i++;}
	    else {
		change (ary, pivpoint, pivpoint -1);
		pivpoint--;
	    }
	    System.out.println(makeString(ary));
	}

	return pivpoint;
    }


    private static void change (int[] ary, int a, int b){
	int hold = ary[a];
	ary[a] = ary[b];
	ary[b] = hold;
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

    public static int quickselectH(int []data, int k, int start, int end){
	int index = part(data, start, end);

	if (data[index] < data[k]) {quickselectH(data, k, index, end);}
	if (data[index] > data[k]) {quickselectH(data, k, start, index);}
	
	return data[k];
	  
    }
    
    public static int quickselect(int []data, int k){
	return quickselectH(data, k, 0, data.length);

    }

    public static void main (String[]args){
	
    }
}
