import java.util.*;

public class Quick{


    public static int randInt(int min, int max){
	int range = (max - min) + 1;     
	return (int)(Math.random() * range) + min;
    }


   
     public static int part (int[] ary, int start, int end){
      	int pivot = randInt(start, end-1);
      	//System.out.println(makeString(ary));
      	//System.out.println("pivot: " + ary[pivot]);
      	change (ary, end-1, pivot);
      	//System.out.println(makeString(ary));
      	int pivpoint = end - 1;
  	for (int i = start; i < pivpoint;){
  	    if (ary[pivpoint-1] < ary[pivpoint]){
  		change(ary, i, pivpoint-1);
      		i++;}
      	    else {
      		change (ary, pivpoint, pivpoint -1);
     		pivpoint--;
     	    }
     	    //System.out.println(makeString(ary));
      	}
     	return pivpoint;
    }


    private static void change (int[] ary, int a, int b){
	int hold = ary[a];
	ary[a] = ary[b];
	ary[b] = hold;
    }

    
    public static int quickselect(int[] ary, int x){
	if (x < 0 || x >= ary.length) {
            throw new IndexOutOfBoundsException("Index out of Bounds");
        }
	int j = ary.length - 1;
	return helper(ary, 0, j, x);
    }
	
	
    
    public static int helper(int[] ary, int a, int b, int c){
	
	if(a < b){
	    int save = part(ary, a, b);
	    //System.out.println ("part" + save);
	    if(save == c){
		return ary[save];}
  
	    else{
		if(c < save)
		    return(helper(ary, a, save-1, c));
		else{
		    return(helper(ary, save+1, b, c));}
	    }
	}
	else{return ary[c];}

	
	
    }

    
	


   
    public static String  makeString (int[] ary){
	String fin = "";
	for (int i = 0; i < ary.length; i++){
	    fin += ary[i] + " ";
	}
	return fin;
    }
    
    public static void main (String[]args){
	int[] n = {5,999,2,5,1,5,5,2,999,9999,999};
	//{999,999,999,4,1,0,3,2,999,999,999};
	System.out.println(makeString(n));
	System.out.println("ANS: " + quickselect(n,0));
	//System.out.println(makeString(n));
    }

}
