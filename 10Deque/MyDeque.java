import java.util.*;

public class Deque{
    private String[]  n;
    private int first;
    private int last;
    private int size;

    public Deque(){
	n = new String[2];
	size = 2;
	first = 0;
	last = 0;

    }

    private void double(){
	n = new String[size*2];
	size = size*2;
    }

    public void addFirst(String str){
	try{
	    
	
	    
	
    }

    public void addLast(String str){
	
    }

    public String removeFirst(){
    }

    public String removeLast(){
    }

    public String getFirst(){
    }

    public String getLast(){
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

   












}
