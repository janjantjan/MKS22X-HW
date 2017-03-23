public class Merge {
// ef mergesort(int[]ary) //not enough parameters
//    int[]left = copy of the left side;
//    int[]right = copy of the right side;
//    mergesort(left)
//    mergesort(right)
//    mergeTheTwoHalvesIntoTheOriginalArray

// This will use more space but is still very fast. This is the easiest way and will be all that I require.

// One possible way to make the merge method work well in this situation is to merge directly into the array you want to put the values into (DO NOT return a new array and then copy that over
    public static void mergesort(int[]ary){
	int part = ary.length/2;
	int otherpart = ary.length - part;
	int[]left = 




    private static void mergesortH(int[]ary, int[] copy){
	
	//fill with alt method later

    }
	
	private static int[] copy(int[]ary, int start, int end){

	}
	    



    private  static void merge(int[]a,int[]b,int[]destination){
	int x = 0;
	int y = 0;
	int i = 0;
	while((x < a.length) && (y < b.length)){
	    if (a[x] < b[y]){ 
		System.out.println(a[x] + " " + b[y]);
		destination[i] = a[x];
		x++;}
	    else{
		System.out.println(a[x] + " " + b[y]);
		destination[i] = b[y];
		y++;
	    }
	    i++;
	}

	while (x < a.length){ 
	    destination[i]= a[x];
	    x++;
	    i++;
	}
	while(y < b.length){
	    System.out.println("i " + i);
	    destination[i] = b[y];
	    y++;
	    i++;
	}
    }


    private static String makeString( int[] ary){
	String fin = "";
	for (int i = 0; i < ary.length; i++){
	    fin += ary[i] + " ";
	}
	return fin;}

    
// Postcondition:
//      destination contains all of the elements of a and b, and is sorted. 
// Preconditions:
//     a is sorted, b is sorted
//     destination.length == a.length + b.length

    public static void main (String[]args){
	int[] a = {1,3,5,7,9};
	int[] b = {2,4,6,8,10,12,14};
	int[] c = new int[12];

	merge(a,b,c);
	System.out.println(makeString(c));
    }

}
