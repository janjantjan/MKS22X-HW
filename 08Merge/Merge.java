public class Merge {

    private static int[] copy(int[]ary, int start, int end){
	int[] neu =  new int[end-start];
	for (int i = 0; start < end; i++){
	    neu[i] = ary[start];
	    start++;
	}
	return neu;
    }

    public  static void  mergesort ( int[]ary){
	if (ary.length > 1){
	    
	    int mid = ary.length / 2;
	    int end = ary.length;
	    int[] left = copy(ary,0, mid);
	    int[] right = copy(ary, mid, end);
	    mergesort(left);
	    mergesort(right);
	    mergeAry(left, right, ary);
	}

    }    
	

    private  static void mergeAry(int[]a,int[]b,int[]destination){
	int x = 0;
	int y = 0;
	int i = 0;
	while((x < a.length) && (y < b.length)){
	    if (a[x] < b[y]){ 
		//System.out.println(a[x] + " " + b[y]);
		destination[i] = a[x];
		x++;}
	    else{
		//System.out.println(a[x] + " " + b[y]);
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
	    //System.out.println("i " + i);
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



    public static void main (String[]args){
	int[] ary = {0,9,8,7,6,5,4,2,1,3};
	mergesort(ary);
	System.out.println(makeString(ary));
    }

}
    //tests
    //randomized (0-10) (blah to blah)
    //Same val.
    // Sorted
	//reverse sorted
    // Size like.... 1 mill
