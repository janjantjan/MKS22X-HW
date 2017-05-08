public class RunningMedian{
    
    MyHeap less;
    MyHeap more;

    public RunningMedian(){
	less = new MyHeap(true);
	more = new MyHeap(false);
    }
	

    public void add(int num){
	if (less.size()> more.size()){
	    more.add(num);
	}
	if (more.size()>less.size()){
	    less.add(num);
	}
	else{ more.add(num);}
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
}

    
