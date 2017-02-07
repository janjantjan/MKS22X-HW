public class Recursion{ 
    public static String name(){
	return ("Tjan,Janice");}
    
     public static double sqrt(double n){
     	if (n<0) {throw new IllegalArgumentException();}
     	return resqrt (n,1);
     }
    
    public static double resqrt (double n, double guess){
     	double better = ((n/guess) + guess)/2;
     	if (closenuf((better*better), n, 0.000000001)){return better;}
     	return resqrt(n, better);
     }
    
    public static boolean closenuf (double x, double y, double ref){
	if ((x-y)>0){
	    return ((x-y)<ref);}
	return ((y-x)<ref);
    }

    public static void main (String[]arg){
	System.out.println(sqrt(100)+" should be 10");
	System.out.println(sqrt(81)+" should be 9");
	System.out.println(sqrt(64)+" should be 8");
	System.out.println(sqrt(50)+" should be 7.07...");
	System.out.println(sqrt(72)+" should be 8.485...");
	System.out.println(sqrt(101)+" should be 10.0498...");
	System.out.println(sqrt(20000)+" should be 141.42135...");
	System.out.println(sqrt(2)+" should be 1.41...");
	System.out.println(sqrt(9)+" should be 3");
	System.out.println(sqrt(31)+" should be 5.56776...");
	System.out.println(sqrt(56)+" should be 7.4833...");
	System.out.println(sqrt(-1)+" should be an error");
	
    }
	
}
