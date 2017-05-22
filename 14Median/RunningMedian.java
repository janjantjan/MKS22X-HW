import java.lang.*;
public class RunningMedian{
    
    MyHeap less;
    MyHeap more;

    public RunningMedian(){
	less = new MyHeap(true);
	more = new MyHeap(false);
    }
	

    public void add(int num){
	if (less.size() == 0) {
	    less.add(num);
	    return;}
	
	if (more.size() == 0) {
	    more.add(num);
	    return;}

	
	double median = getMedian();
	if (num > median){
	    less.add(num);
	}
	else{
	    more.add(num);}

	 if (Math.abs(less.size() - more.size()) > 1){
	     if (less.size()> more.size()){
	 	int move = less.remove();
	 	more.add(move);
	     }
	     else{ int moves = more.remove();
	 	less.add(moves);
	     }
	 }
    
    }

    public double getMedian(){
	
	if(more.size()== less.size()){
	    int a = less.peek();
	    int b = more.peek();
	    double sum = 0.0 + a + b;
	    return sum/2;
	}
	if(more.size()>less.size()){
	    return 0.0 + more.peek();
	}
	else{ return 0.0 + less.peek();}
    }

    private String printMore(){
	return more.makeString();
    }

   private String printLess(){
	return less.makeString();
    } 

    public static void main (String[]argss){
	RunningMedian a = new RunningMedian();
	a.add(1);
	a.add(2);
	a.add(4);
	a.add(5);//
	a.add(9);
	a.add(11);
	a.add(100);
							
	System.out.println(a.getMedian());
	System.out.println(a.printMore());
	System.out.println(a.printLess());
    }
    
}

    
