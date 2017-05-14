import java.util.*;
public class MyHeap {

    private ArrayList<Integer> heap;
    private int size;
    private boolean max;

    public Integer remove(){
	int end = heap.size()-1;
	Integer ending = heap.get(end);
	Integer top = heap.get(1);
	remover();
	heap.set(1, ending);
	pushdown();
	size--;
	return top;


    }
    public MyHeap(){
        heap = new ArrayList<Integer>();
	max = true; 
	size = 0;
	heap.add(0);
    }

    public MyHeap(boolean bool){
	if (bool){
	    heap = new ArrayList<Integer>();
	    max = true;
	    size = 0;
	    heap.add(0);
	}
	else{
	    heap = new ArrayList<Integer>();
	    max = false;
	    size = 0;
	    heap.add(0);
	}
    }

    public void add (int str){
	heap.add(str);
	size++;
	pushup();

    }

     private void remover(){
    	int end = heap.size()-1;
     	int ending = heap.get(end);
     	heap.remove(end);
     	
     }

    public Integer peek(){
	
	return heap.get(1);
    }

    private void swap(int a, int b){
	Integer x = heap.get(a);
	Integer y = heap.get(b);
	heap.set(a, y);
	heap.set(b, x);
    }

    private boolean toogreat(int x, int next){
	if (max){
	    if (x<next){
		return true;
	    }
	    else{return false;}}
	else{if (x>next){
		return false;
	    }
	    else{return true;}}
    }
    
    private void  pushup(){
	int end = heap.size()-1;
	int ending = heap.get(end);
	int moving = heap.get(end/2);
	while(toogreat(ending, moving)){
	    swap(end, end/2);
	    if(end >= 1){
		end = end/2;
		ending = heap.get(end);
		moving = heap.get(end/2);}
	    else{return;}
	}	    
    }
		
	    


    private boolean toosmall(Integer x, Integer next){
	return !toogreat(x,next);
    }

    
    private void  pushdown(){
	int top = 1;
	while (top*2 < heap.size()-1){
	    
	    int val = heap.get(top);
	    if (heap.get(top*2)< heap.get(top*2+1)){
		if (heap.get(top*2)<heap.get(top)){
		    swap (top, top*2);
		    top = top*2;}
	    }
	    else {
		if (heap.get(top*2+1)<heap.get(top)){
		    swap (top, top*2+1);
		    top = top*2+1;}
	    }
	}	
	if (heap.get(top*2)<heap.get(top)){
	    
	    swap (top, top*2);
	    top = top*2;
	    return;}
    
	    
	else if (heap.get(top*2+1)<heap.get(top)){
	    
	    swap (top, top*2+1);
	    top = top*2+1;
	    return;}
	
    }
	



private String makeString(){
    String fin = "";
	int x = 1;
	int y = 48;
	
	for (int i = 1 ; i< heap.size()-1 ;i = i*2 ){
	    for (int j = 0; j < i ; j++){
		if (x < heap.size()-1){
		   
		    for (int k = 0; k < y; k++){
			fin += " ";
		    }
		   
		    fin += heap.get(x) ;
		    x++;
		    
		}
		else{
		    
		    for (int k = 0; k < y; k++){
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
	 a.add(5);
	 a.add(7);
	 a.add(2);
	 a.add(9);
	 a.add(0);
	 a.add(4);
	 a.add(1);
	 a.add(555);
	 a.add(7);
	 a.add(2);
	 a.add(9);
	 a.add(0);
	 a.add(4);
	 a.add(1);
	 a.add(555);

	
	 System.out.println(a.makeString());
	

	 System.out.println(a.remove());
	
	
	 System.out.println("\n" + "\n" + a.makeString());


     }
}
