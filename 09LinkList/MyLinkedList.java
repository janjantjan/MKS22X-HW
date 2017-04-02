public class MyLinkedList {
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = null;
	size = 0;
    }

    public boolean add (int value){

	if (size==0){
	    start = new LNode(value, start);
	    size++;
	    return true;}
	else{
	    LNode current = start;
	    for (int i = 0; i < size-1; i++){
		current = current.next;
	    }
	    LNode neu = new LNode(value, null);
	    current.next = neu; 
	    size++;
	    return true;}
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
	try{
	    while (index > 0 ) {
		current = current.next;
		index--;
	    }
	    return current.value;

	}catch(NullPointerException e){
	    System.out.println("GET index out of bounds: " + index);
	    return 00000;
	}
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

  
   

    public void add (int index, int value){
	LNode current = start;
	
	try{
	    for (int i = 0; i < index; i++){
		current = current.next;
	    }
	    LNode neu = new LNode(value, current.next);
	    current.next = neu;
	    size++;

	}catch(NullPointerException e){
	    System.out.println("ADD index out of bounds: " + index);
	    return;
	}
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

	try{
	    for (int i = 0; i < index; i++){
	    b4 = current;
	    current = current.next;
	}

	int removed = current.value;
	b4.next = current.next;
	size--;
	
	return removed;}

	catch(NullPointerException e){
	    System.out.println("REMOVE index out of bounds: " + index);
	    return 00000;
	}
    }

    public int set(int index, int val){
	LNode current = start;
	int i = index;
	try{
	    while (i > 0){
		current = current.next;
		i--;
	    }
	    int save = current.value;
	    current.value = val;
	    //System.out.println(current.value);
	    return save;

	}catch(NullPointerException e){
	    System.out.println("SET index out of bounds: " + index);
	    return 00000;
	}
	
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

    




}
