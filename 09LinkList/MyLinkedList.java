public class MyLinkedList {
    private LNode start;
    private int size;

    public MyLinkedList(){
	start = new LNode(null);
	size = 0;
    }

    public boolean add (int value){
	LNode first = new LNode(value, start);	
	size++;
    }
    
    public int size (){
	return size;
    }

    private boolean hasNext (LNode current){
	if(current.next==null){return false;}
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
	String fin = "";
	LNode current = start;
	while(hasNext){
	    fin += current.value;
	    current = current.next;
	}
	return fin;
    }



    private class LNode{
	private int next;
	private int value;

	public LNode (int val){
	    value = val;
	    next = null;
	}

	public LNode (int val, int nxt){
	    value = val;
	    next = nxt;
	}	
    }


    public static void main (String[]argssssss){
	MyLinkedList X = new MyLinkedList


}
