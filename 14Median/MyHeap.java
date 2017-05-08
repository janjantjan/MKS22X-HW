import java.util.*;
public class MyHeap {

    private ArrayList<String> heap;
    private boolean max;

    public String remove(){
	int end = heap.size()-1;
	String ending = heap.get(end);
	String top = heap.get(1);
	remover();
	heap.set(1, ending);
	pushdown();
	return top;

    }
    public MyHeap(){
        heap = new ArrayList<String>();
	max = true; 
	heap.add("");
    }

    public MyHeap(boolean bool){
	if (bool){
	    heap = new ArrayList<String>();
	    max = true;
	    heap.add("");
	}
	else{
	    heap = new ArrayList<String>();
	    max = false;
	    heap.add("");
	}
    }

    public void add (String str){
	heap.add(str);
	pushup();

    }

     private void  remover(){
    	int end = heap.size()-1;
     	String ending = heap.get(end);
     	heap.remove(end);
     	
     }

    public String peek(){
	
	return heap.get(1);
    }

    private void swap(int a, int b){
	String x = heap.get(a);
	String y = heap.get(b);
	heap.set(a, y);
	heap.set(b, x);
    }

    private boolean toogreat(String x, String next){
	if (max){
	    if (x.compareTo(next)<0){
		return true;
	    }
	    else{return false;}}
	else{if (x.compareTo(next)<0){
		return false;
	    }
	    else{return true;}}
    }
    
    private void  pushup(){
	int end = heap.size()-1;
	int moveto = end/2;
	String ending = heap.get(end);
	String moving = heap.get(moveto);
	while(toogreat(ending, moving)){
	    swap(end, moveto);
	    if(end >= 1){
		end = moveto;
		moveto = end/2;
		ending = heap.get(end);
		moving = heap.get(moveto);}
	    else{return;}
	}	    
    }

    private boolean toosmall(String x, String next){
	return !toogreat(x,next);
    }

    

    private void pushdown(){
	int top = 1;
	int moveto = 2;
	String toping = heap.get(1);
	String moving = heap.get(moveto);
	while(toosmall(toping, moving)){
	    swap(top, moveto);
	    if((top * 2) < (heap.size() -1)){
		top = moveto;
		moveto = top*2;
		toping = heap.get(top);
		moving = heap.get(moveto);}}
	    moveto+=1;
	    moving = heap.get(moveto);
	    if (toosmall(toping, moving)){
		 swap(top, moveto);;}
		
	    //else{return;}
    }

	
    


    private String makeString(){
	String fin = "";
	int x = 1;
	int y = 48;
	int z = 0;
	for (int i = 1 ; i< heap.size()-1 ;i = i*2 ){
	    for (int j = 0; j < i ; j++){
		if (x < heap.size()-1){
		    z = (heap.get(x).length())/2;
		    for (int k = 0; k < y-z; k++){
			fin += " ";
		    }
		   
		    fin += heap.get(x) ;
		    x++;
		    
		}
		else{
		    
		    for (int k = 0; k < y-z; k++){
			fin += " ";
		    }
		    fin += heap.get(heap.size() -1);
		    
		    return fin;}}
	    y = (y/3) * 2;
	    fin+= "\n";
	    fin+= "\n";
	}
	
	for (int k = 0; k < y; k++){
	    fin += " ";
	}
	fin += heap.get(heap.size() -1);
	return fin;
    }

     public static void main(String[]HELLOOOOOO){
     	MyHeap a = new MyHeap(false);
     	a.add("apple");
     	a.add("zutter");
     	a.add("carrot");
     	a.add("zebra");
     	a.add("chicken");
     	a.add("happy");
     	a.add("pun");
     	a.add("aaaaa");
     	a.add("mrk");
     	a.add("lala");

     	a.add("chip");
 	a.add("winning");

	
     	System.out.println(a.makeString());
	

     	System.out.println(a.remove());
	
	
     	System.out.println("\n" + "\n" + a.makeString());


     }
}
