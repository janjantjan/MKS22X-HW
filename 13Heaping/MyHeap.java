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

public class MyHeap {

    private ArrayList<String> heap;
    private MyHeap top;
    private MyHeap left;
    private MyHeap right;
    private int size;


    public MyHeap(){
	top = null;
	
    }

    public MyHeap(boolean bool){
	if (bool){
	    
	}
	else{}
    }

    public void add (String str){

    }

    public String remove(){
    }

    public String peek(){
    }

    private void pushup(){
    }

    private void pushdown(){
    }
