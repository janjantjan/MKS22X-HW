import java.util.*;
public class MyHeap {

    private ArrayList<Integer> heap;
    private int size;
    private boolean max;


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

    
    public Integer remove(){
	int end = heap.size()-1;
	Integer ending = heap.get(end);
	Integer top = heap.get(1);
	heap.remove(end);
	heap.set(1, ending);
	size--;
	pushdown();
	
	return top;
    }
   

    public void add (int str){
	heap.add(str);
	size++;
	pushup();

    }

   
    public Integer peek(){
	
	return heap.get(1);
    }

    public int size(){
	return size;
    }
    
    private void swap(int a, int b){
	Integer x = heap.get(a);
	Integer y = heap.get(b);
	heap.set(a, y);
	heap.set(b, x);
    }

    private boolean toogreat(int x, int next){
	if (max){
	    if (x < next){
		return true;
	    }
	    else{return false;}}
	else{if (x < next){
		return false;
	    }
	    else{return true;}}
    }
    
    private void  pushup(){
	int end = heap.size()-1;
	int ending = heap.get(end);
	int moving = heap.get(end/2);
	while(toogreat(ending, moving) && (end/2)!= 0){
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

    
    private void pushdown(){
	int top = 1;
	int topval = heap.get(top);
	int moving1 = heap.get(2);
	int moving2 = heap.get(3);
	try{
	    while((toosmall(top, moving1) || toosmall(top, moving1))&& (top *4 < size-1))  {
	    if (toosmall(top, moving1)){
		swap(top, moving1);
		top = top*2;
		moving1 = heap.get(top *2);
		moving2 = heap.get(top *2 +1);
	    }
	    if(toosmall(top, moving2)){
		swap(top,moving2);
		top = top*2+1;
		moving1 = heap.get(top *2);
		moving2 = heap.get(top *2 +1);
	    }
	    }}	catch (IndexOutOfBoundsException e){
	    return;
	}
	
	return;	    
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

	 a.add(3);
	 a.add(3);
	 a.add(1);
	 a.add(1);
	 a.add(1);
	 a.add(1);
	 a.add(2);
	 a.add(1);
	 a.add(1);
	 a.add(0);
	 a.add(2);

	
	 System.out.println(a.makeString());
	

	 a.remove();
	
	
	 System.out.println("\n" + "\n" + a.makeString());


     }
}
