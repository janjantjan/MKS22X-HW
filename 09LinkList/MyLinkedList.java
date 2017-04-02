public class MyLinkedList {
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    public boolean add (int value){
        start = new LNode(value, start);
	size++;
	return true;
    }
    
    public int size (){
	return size;
    }

    private boolean hasNext(){
	LNode current = start;
	if(current.next == null){return false;}
	else{return true;}
    }

    public int get (int index){
	LNode current = start;
	while (index > 0 ) {
	    current = current.next;
	    index--;
	}
	return current.value;
    }


    public String toString (){
	String fin = "[";
	LNode current = start;
	for (int i = size; i > 0; i--){
	    if (i>1){
	    fin += current.value + ", ";
	    current = current.next;}
	    else{ fin += current.value;}
	}
	fin += "]";
	return fin;
    }

  
   
    // void add(int index, int value)    
    //     - insert a new element at the specified index, 0 at the front, size() at the end. 
   

    public void add (int index, int value){
	LNode current = start;
	
    }

    public int indexOf(int val){
	LNode current = start;
	for (int i = size; i > 0; i--){
	    //System.out.println(current.value);
	    if (current.value == val){
		return size - i;
	    }
	    current = current.next;
	}
				       
	return -1;
    }

    public int remove(int index){
	LNode current = start;
	LNode b4 = null;

	for (int i = 0; i < index; i++){
	    b4 = current;
	    current = current.next;
	}

	int removed = current.value;
	b4.next = current.next;
	size--;
	
	return removed;
    }

    public int set(int index, int val){
	LNode current = start;
	while (index > 0){
	    current = current.next;
	    index--;
	}
	int save = current.value;
	current.value = val;
	//System.out.println(current.value);
	return save;
	
    }
    
	private class LNode{
	    private LNode next;
	    private int value;

	    public LNode (int val){
		value = val;
		next = null;
	    
	    }

	    public LNode (int val, LNode nxt){
		value = val;
		next = nxt;
	    }	
	}

    


    public static void main (String[]argssssss){
	MyLinkedList X = new MyLinkedList();
	X.add(7);
	X.add(4);
	X.add(1);
	X.add(9);
	X.add(9);
	X.add(3);
	System.out.println(X.set(2,3));   
	//System.out.println(X.indexOf(8));
	System.out.println(X.toString());
	
    }


}
