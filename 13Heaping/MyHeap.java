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

    private void pushup(){
	int end = heap.size()-1;
	int moveto = end/2;
	String ending = heap.get(end);
	String moving = heap.get(moveto);
	if (ending.compareTo(moving)<0){
	    swap(end, moveto);}
	else{return;}
    
    }

    private void pushdown(){
	int end = heap.size()-1;
	int moveto = end/2;
	String ending = heap.get(end);
	String moving = heap.get(moveto);
	if (ending.compareTo(moving)>0){
	    swap(end, moveto);}
	else{return;}
    
    
    }

    private String makeString(){
	String fin = "";
	for (int i = 1 ; i< heap.size()-1 ; i++){
		fin += heap.get(i) + ", " ;
	}
    
	return fin + heap.get(heap.size()-1) + "]";
    }

    public static void main(String[]HELLOOOOOO){
	MyHeap a = new MyHeap();
	a.add("apple");
	a.add("zutter");
	a.add("carrot");
	a.add("zebra");
	a.add("chicken");
	a.add("happy");
	a.add("pun");
	a.add("aaaaa");
	System.out.println(a.makeString());
    }
}
