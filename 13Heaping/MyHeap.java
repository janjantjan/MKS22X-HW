/**Constructors
 -MyHeap() - construct empty max heap
 -MyHeap(boolean) - true: construct empty max heap, false: construct empty min heap.
 Methods
 -void add(String s)
 -String remove()
 -String peek()

Private methods:
 -pushUp()
 -pushDown()*/
import java.util.*;
public class MyHeap {

    private ArrayList<String> heap;
    private boolean max;


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

    public String remove(){
	int end = heap.size()-1;
	String ending = heap.get(end);
	heap.remove(end);
	return ending;
    }

    public String peek(){
	int end = heap.size()-1;
	return heap.get(end);
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
    
    private void pushup(){
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

    private void pushdown(){
	int end = heap.size()-1;
	int moveto = end/2;
	String ending = heap.get(end);
	String moving = heap.get(moveto);
	if (max){
	    if (ending.compareTo(moving)>0){
		swap(end, moveto);}
	    else{return;}}
	else{if (ending.compareTo(moving)<0){
		swap(end, moveto);}
	    else{return;}}
    
    
    }

    private String makeString(){
	String fin = "";
	int x = 1;
	int y = 48;
	int z = 0;
	for (int i = 1 ; i< heap.size()-1 ;i = i*2 ){
	    for (int j = 0; j < i ; j++){
		if (x < heap.size()-1){
		    z = heap.get(x).length();
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
    }
}
