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
	    fin += current.value;
	    current = current.next;
	}
	fin += "]";
	return fin;
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
	System.out.println(X.toString());
    }


}
