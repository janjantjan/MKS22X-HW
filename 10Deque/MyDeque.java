import java.util.*;

public class MyDeque{
    private String[]  n;
    private int first;
    private int last;
    private int size;
    private int maxsize;

    public MyDeque(){
	n = new String[2];
	maxsize = 2;
	size = 0;
	first = 0;
	last = 0;

    }

    public MyDeque(int x){
	n = new String[x];
	maxsize = x;
	size = 0;
	first = 0;
	last = 0;
    }

    private void ouble(){
	String[] m = new String[maxsize*2];
	
	for (int i = 0; i < n.length; i++){
	    m[i] = n[i];
	}

	n = m;
	maxsize = maxsize * 2;
	
    }

    public void addFirst(String str){
	if (maxsize == size+1){
	    ouble();}
	if (size==0){
	    n[0] = str;
	    size++;
	    return;
	}
	if (first == 0){
	    first = n.length-1;}
	else{ first--;}
	n[first] = str;
	
	size++;
	  
	
    }

    public void addLast(String str){
	if (maxsize == size+1){
	    ouble();}
	if (size==0){
	    n[0] = str;
	    size++;
	    return;}
	if (last == n.length-1){
	    last = 0;}
	else{last++;}
	n[last] = str;

	
	size++;
    }

    public String removeFirst(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	String save = n[first];
	n[first] = "";
	if (first == n.length){
	    first = 0;}
	else{first++;}

	size--;

	return save;
    }

    public String removeLast(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	String save = n[last];
	n[last] = "";
	if (last == 0){
	    last = n.length-1;
	}
	else{last--;}

	size--;

	return save;	
    }

    public String getFirst(){
	if (size==0){
	    throw new NoSuchElementException();
	    //return "Deque is empty";
	}
	else{return n[first];}
	
		
    }

    public String getLast(){
	if (size==0){
	    throw new NoSuchElementException();
	    //return "Deque is empty";
	}
	else{return n[last];}
	
    }

    private String makeString(){
	String fin = "";

	for (int i=0; i < n.length; i++){
	    fin += n[i] + "   ";
	}

	fin += "first: " + first + " last: " + last;
	return fin;


    }

    public static void main (String[] args){
	MyDeque x = new MyDeque();
	x.addFirst("carrot");
	System.out.println(x.makeString());
	x.addFirst("banana");
	System.out.println(x.makeString());
	x.addFirst("apple");
	System.out.println(x.makeString());
	x.addLast("dog");

	System.out.println(x.makeString());
	
	System.out.println(x.getLast());
	System.out.println(x.getFirst());

	System.out.println(x.removeFirst());
	System.out.println(x.removeLast());

	System.out.println(x.getLast());
	System.out.println(x.getFirst());
	
    }
}



    /**The add methods:
       These will add the element to the specified side. The deque will double capacity if there is no space left.
       void addFirst(String)
       void addLast(String)
       Throws: (this is a subset of the real deque)
       NullPointerException - if the specified element is null and this deque does not permit null elements

       The remove methods:
       These will retrieve and remove the element from the specified side.
       String removeFirst()
       String removeLast()
       Throws:
       NoSuchElementException - if this deque is empty

       The get methods:
       These will retrieve but not remove the element from the specified side.
       String getFirst()
       String getLast()
       Throws:
       NoSuchElementException - if this deque is empty*/

   












