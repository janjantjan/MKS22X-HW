public class MyLinkedList {
    private LNode start;
    private int size;
    private LNode end;     

    public MyLinkedList(){
	start = null;
	end = null;
	size = 0;
    }

    private void remove(LNode nod){
	if (size == 1){
	    start = null;
	    end = null;}
	
	if (nod == start){
	    LNode neu = start.next;
	    neu.prev = null;
	    start = neu;
	    size--;
	}

	else if (nod == end){
	    LNode neu = end.prev;
	    neu.next = null;
	    end = neu;
	}
	else{   
	    nod.prev.next = nod.next;
	    nod.next.prev = nod.prev;
	    size--;}
    }

    private LNode getNode (int index){
		if (index >= size || index < 0){
	    return null;}
	
	int half = size/2;
	LNode current = null;
	if (index < half){
	    current = start;
	    for (int i = 0; i < index; i++){
		current = current.next;
	    }
	}
	else {
	    current = end;
	    for (int i = size; i > index; i--){
		current = current.prev;
	    }
	}
	System.out.println(current.value);
	return current;
    }

    private void insertAfter(LNode tba, LNode loc){
	if (loc == end){
	    loc.next = tba;
	    tba.prev = loc;
	    end = tba;
	    size++;
	}
	else{
	    tba.next = loc.next;
	    tba.prev = loc;
	    loc.next.prev = tba;
	    loc.next = tba;
	    size++;}
    }

    private void insertBefore (LNode tba, LNode loc){
	if (loc == start){
	    loc.prev = tba;
	    tba.next = loc;
	    start = tba;
	    size++;
	}
	else{
	    tba.next = loc;
	    tba.prev = loc.prev;
	    loc.prev.next = tba;
	    loc.prev = tba;
	    size++;}
    }
		
      public void add (int index, int value){
	try{
	    LNode loc = getNode(index);
	    LNode neu = new LNode(value);
	    insertAfter(neu, loc);
     	}catch(NullPointerException e){
     	    System.out.println("ADD index out of bounds: " + index);
     	    return;
    	}
    }
    
    public boolean add (int value){
	try{
	    if (size==0){
		start = new LNode(value, start, null);
		end = start;
		size++;
		return true;}
	    else{
		LNode neu = new LNode (value);
		insertAfter(neu, end);
        
		return true;}
	}catch (NullPointerException e){
	    System.out.println("Null Pointer");
	    return false;}
}
    
    public int size (){
	return size;
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
	for (int i = 0; i < size; i++){
	    if (i<1){
		int cur = current.value;
		LNode bef = current.prev;
		int aft = current.next.value;
		//System.out.println("(" + bef + ")" + cur + "(" + aft + ")" + ", ");
		fin += "(" + bef + ")" + cur + "(" + aft + ")" + ", ";
		current = current.next;}
	    else if (i == size-1){
		//System.out.println("blah");
		int cur = current.value;
		//System.out.println(cur);
		int bef = current.prev.value;
		//System.out.println(bef);
		LNode aft = current.next;
		//System.out.println(aft);
		//System.out.println("(" + bef + ")" + cur + "(" + aft + ")" + ", ");
		fin += "(" + bef + ")" + cur + "(" + aft + ")";}
	    else{
		int cur = current.value;
		int bef = current.prev.value;
		int aft = current.next.value;
		//System.out.println("(" + bef + ")" + cur + "(" + aft + ")" + ", ");
		fin += "(" + bef + ")" + cur + "(" + aft + ")" + ", ";
		current = current.next;}
	  
	}
	fin += "]";
	return fin;
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
	

	try{
	    LNode neu = getNode(index);
	    remove (neu);
	    return neu.value;

	}catch(NullPointerException e){
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
	    private LNode prev;

	    public LNode (int val){
		value = val;
		next = null;
		prev = null;
	    
	    }

	    public LNode (int val, LNode nxt, LNode prv){
		value = val;
		next = nxt;
		prev = prv;
	    }	
	}

    public static void main (String[]sfho){
	MyLinkedList n = new MyLinkedList();
	n.add(1);
	n.add(2);
	n.add(3);
	n.add(72);
	n.add(12);
	System.out.println(n.toString());
	n.add(2, 700);
	System.out.println(n.toString());
	System.out.println(n.indexOf(700));

    }




}
